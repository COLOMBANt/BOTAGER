
/*
Cette partie gère la recherche et le premier appairage avec le module Bluetooth HC-06
*/
package com.example.thomas.botager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Set;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public class DeviceList extends AppCompatActivity {


    Button btnPaired;
    ListView devicelist;
    private BluetoothAdapter myBluetooth = null;
    private Set pairedDevices;
    public static String EXTRA_ADDRESS = "device_address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        //On déclare le bouton Bluetooth et la ListView
        btnPaired = (Button) findViewById(R.id.Y);
        devicelist = (ListView) findViewById(R.id.listView);


        myBluetooth = BluetoothAdapter.getDefaultAdapter();

        //Test si le smartphone est équipé du Bluetooth
        if (myBluetooth == null) {
            //Affiche un message d'erreur
            Toast.makeText(getApplicationContext(), "L'appareil ne dispose pas du Bluetooth", Toast.LENGTH_LONG).show();
            //ferme l'application
            finish();
        } else {
            if (myBluetooth.isEnabled()) {
            } else {
                //Demande à l'utilisateur d'activer le Bluetooth via un bouton qui va apparaitre à l'écran
                Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(turnBTon, 1);
            }

            btnPaired.setOnClickListener(new View.OnClickListener() {

                /*Appareillage avec le périphérique Bluetooth sur lequel on appuie

                    /!\  On peut théoriquement se connecter à n'importe quel périphérique Bluetooth mais le programme
                         va se bloquer car il n'aura pas la réponse adequate du périphérique*/
                @Override
                public void onClick(View v) {
                    pairedDevicesList();
                }
            });
        }
    }
        private void pairedDevicesList(){

            Set<BluetoothDevice> pairedDevices = myBluetooth.getBondedDevices();
            ArrayList list = new ArrayList();

            if (pairedDevices.size()>0)
            {
                //Affiche la liste des périphériques Bluetooth disponibles
                for( BluetoothDevice bt : pairedDevices){

                    list.add(bt.getName() + "\n" + bt.getAddress()); //Get the device's name and the address
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Pas de périphériques trouvés ", Toast.LENGTH_LONG).show();
            }

            final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
            devicelist.setAdapter(adapter);
            devicelist.setOnItemClickListener(myListClickListener);

        }

    private AdapterView.OnItemClickListener myListClickListener = new AdapterView.OnItemClickListener()
    {
        public void onItemClick (AdapterView av, View v, int arg2, long arg3)
        {
            // Ici on récupère l'adresse MAC du périphérique
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);
            Log.e("tag",address);
            // On fait la liaison avec le programme SendFields.java
            Intent i = new Intent(DeviceList.this, SendFields.class);
            i.putExtra(EXTRA_ADDRESS, address);
            startActivity(i);
        }
    };
    }




