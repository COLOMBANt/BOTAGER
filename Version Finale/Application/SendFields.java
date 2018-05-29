/*
Ceci est la partie principale de l"application
C'est ici que l'on va récupérer les choix de l'utilisateur et les envoyer au module HC-06
 */


package com.example.thomas.botager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.UUID;



public class SendFields extends AppCompatActivity implements View.OnClickListener {


    //Déclaration des variables
    Button V;
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private Button monBoutonY = null; Button monBoutonX = null; Button monBouton2 = null; Button monBouton3 = null; Button monBouton4=null;Button monBouton5=null;Button monBouton6=null;Button monBouton7=null;Button monBouton8=null;Button monBouton9=null;Button monBouton10=null;Button monBouton11=null;Button monBouton12=null;Button monBouton13=null;Button monBouton14=null;Button monBouton15=null;Button monBouton16=null;Button monBouton17=null;
    private int deux=0; int trois=0; int quatre = 0; int cinq = 0; int six = 0; int sept=0; int huit=0; int neuf=0; int dix=0; int onze=0; int douze=0; int treize=0; int quatorze=0; int quinze=0; int seize=0; int dixsept=0;
    private int matrice[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_fields);

        setContentView(R.layout.activity_device_list);
        monBoutonY = findViewById(R.id.Y);
        monBoutonY.setOnClickListener(this);

        //Reçoit l'adresse Bluetooth du module HC-06 via le programme DeviceList.java
        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS);


        setContentView(R.layout.activity_send_fields);

        new ConnectBT().execute();

        //Appel de tous les widgtes
        V = findViewById(R.id.V);
        monBoutonX = findViewById(R.id.X);
        monBouton2 = findViewById(R.id.button2);
        monBouton3 = findViewById(R.id.button3);
        monBouton4 = findViewById(R.id.button4);
        monBouton5 = findViewById(R.id.button5);
        monBouton6 = findViewById(R.id.button6);
        monBouton7 = findViewById(R.id.button7);
        monBouton8 = findViewById(R.id.button8);
        monBouton9 = findViewById(R.id.button9);
        monBouton10 = findViewById(R.id.button10);
        monBouton11 = findViewById(R.id.button11);
        monBouton12 = findViewById(R.id.button12);
        monBouton13 = findViewById(R.id.button13);
        monBouton14 = findViewById(R.id.button14);
        monBouton15 = findViewById(R.id.button15);
        monBouton16 = findViewById(R.id.button16);
        monBouton17 = findViewById(R.id.button17);



        //Lors de l'appuie sur le bouton Valider, on appelle la fonction sendData()
        V.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendData();
            }
        });


        //Bouton Annuler: initialise toutes les variables et les couleurs
        monBoutonX.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                deux=0;
                trois=0;
                quatre=0;
                cinq=0;
                six=0;
                sept=0;
                huit=0;
                neuf=0;
                dix=0;
                onze=0;
                douze=0;
                treize=0;
                quatorze=0;
                quinze=0;
                seize=0;
                dixsept=0;
                monBouton2.setBackgroundColor(Color.GRAY);
                monBouton3.setBackgroundColor(Color.GRAY);
                monBouton4.setBackgroundColor(Color.GRAY);
                monBouton5.setBackgroundColor(Color.GRAY);
                monBouton6.setBackgroundColor(Color.GRAY);
                monBouton7.setBackgroundColor(Color.GRAY);
                monBouton8.setBackgroundColor(Color.GRAY);
                monBouton9.setBackgroundColor(Color.GRAY);
                monBouton10.setBackgroundColor(Color.GRAY);
                monBouton11.setBackgroundColor(Color.GRAY);
                monBouton12.setBackgroundColor(Color.GRAY);
                monBouton13.setBackgroundColor(Color.GRAY);
                monBouton14.setBackgroundColor(Color.GRAY);
                monBouton15.setBackgroundColor(Color.GRAY);
                monBouton16.setBackgroundColor(Color.GRAY);
                monBouton17.setBackgroundColor(Color.GRAY);
            }
        });



        //Partie très répetitive mais je n'ai pas trouvé d'autres moyens plus efficaces pour faire ça


        //On rentre dans cette boucle lorsqu'on appuie sur le Bouton/carré 2
        monBouton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //On implémente la variable 2 et le tableau multidimensionnel
                deux+=1;
                matrice[0][0] =deux%4;

                //On change la couleur en fonction de la variable
                if (deux%4==1){
                    monBouton2.setBackgroundColor(Color.RED);
                }
                else if (deux%4==2){
                    monBouton2.setBackgroundColor(Color.GREEN);
                }
                else if (deux%4==3){
                    monBouton2.setBackgroundColor(Color.CYAN);
                }
                else if (deux%4==0){
                    monBouton2.setBackgroundColor(Color.GRAY);
                }

            }
        });

        monBouton3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                trois+=1;
                matrice[0][1] =trois%4;
                if (trois%4==1){
                    monBouton3.setBackgroundColor(Color.RED);
                }
                else if (trois%4==2){
                    monBouton3.setBackgroundColor(Color.GREEN);
                }
                else if (trois%4==3){
                    monBouton3.setBackgroundColor(Color.CYAN);
                }
                else if (trois%4==0){
                    monBouton3.setBackgroundColor(Color.GRAY);
                }
            }
        });

        monBouton4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                quatre+=1;
                matrice[0][2] =quatre%4;
                if (quatre%4==1){
                    monBouton4.setBackgroundColor(Color.RED);
                }
                else if (quatre%4==2){
                    monBouton4.setBackgroundColor(Color.GREEN);
                }
                else if (quatre%4==3){
                    monBouton4.setBackgroundColor(Color.CYAN);
                }
                else if (quatre%4==0){
                    monBouton4.setBackgroundColor(Color.GRAY);
                }
            }
        });

        monBouton5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cinq+=1;
                matrice[0][3] =cinq%4;
                if (cinq%4==1){
                    monBouton5.setBackgroundColor(Color.RED);
                }
                else if (cinq%4==2){
                    monBouton5.setBackgroundColor(Color.GREEN);
                }
                else if (cinq%4==3){
                    monBouton5.setBackgroundColor(Color.CYAN);
                }
                else if (cinq%4==0){
                    monBouton5.setBackgroundColor(Color.GRAY);
                }
            }
        });

        monBouton6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                six+=1;
                matrice[1][0] =six%4;
                if (six%4==1){
                    monBouton6.setBackgroundColor(Color.RED);
                }
                else if (six%4==2){
                    monBouton6.setBackgroundColor(Color.GREEN);
                }
                else if (six%4==3){
                    monBouton6.setBackgroundColor(Color.CYAN);
                }
                else if (six%4==0){
                    monBouton6.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sept+=1;
                matrice[1][1] =sept%4;
                if (sept%4==1){
                    monBouton7.setBackgroundColor(Color.RED);
                }
                else if (sept%4==2){
                    monBouton7.setBackgroundColor(Color.GREEN);
                }
                else if (sept%4==3){
                    monBouton7.setBackgroundColor(Color.CYAN);
                }
                else if (sept%4==0){
                    monBouton7.setBackgroundColor(Color.GRAY);
                }
            }
        });

        monBouton8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                huit+=1;
                matrice[1][2] =huit%4;
                if (huit%4==1){
                    monBouton8.setBackgroundColor(Color.RED);
                }
                else if (huit%4==2){
                    monBouton8.setBackgroundColor(Color.GREEN);
                }
                else if (huit%4==3){
                    monBouton8.setBackgroundColor(Color.CYAN);
                }
                else if (huit%4==0){
                    monBouton8.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                neuf+=1;
                matrice[1][3] =neuf%4;
                if (neuf%4==1){
                    monBouton9.setBackgroundColor(Color.RED);
                }
                else if (neuf%4==2){
                    monBouton9.setBackgroundColor(Color.GREEN);
                }
                else if (neuf%4==3){
                    monBouton9.setBackgroundColor(Color.CYAN);
                }
                else if (neuf%4==0){
                    monBouton9.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dix+=1;
                matrice[2][0] =dix%4;
                if (dix%4==1){
                    monBouton10.setBackgroundColor(Color.RED);
                }
                else if (dix%4==2){
                    monBouton10.setBackgroundColor(Color.GREEN);
                }
                else if (dix%4==3){
                    monBouton10.setBackgroundColor(Color.CYAN);
                }
                else if (dix%4==0){
                    monBouton10.setBackgroundColor(Color.GRAY);
                }
            }
        });

        monBouton11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onze+=1;
                matrice[2][1] =onze%4;
                if (onze%4==1){
                    monBouton11.setBackgroundColor(Color.RED);
                }
                else if (onze%4==2){
                    monBouton11.setBackgroundColor(Color.GREEN);
                }
                else if (onze%4==3){
                    monBouton11.setBackgroundColor(Color.CYAN);
                }
                else if (onze%4==0){
                    monBouton11.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                douze+=1;
                matrice[2][2] =douze%4;
                if (douze%4==1){
                    monBouton12.setBackgroundColor(Color.RED);
                }
                else if (douze%4==2){
                    monBouton12.setBackgroundColor(Color.GREEN);
                }
                else if (douze%4==3){
                    monBouton12.setBackgroundColor(Color.CYAN);
                }
                else if (douze%4==0){
                    monBouton12.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                treize+=1;
                matrice[2][3] =treize%4;
                if (treize%4==1){
                    monBouton13.setBackgroundColor(Color.RED);
                }
                else if (treize%4==2){
                    monBouton13.setBackgroundColor(Color.GREEN);
                }
                else if (treize%4==3){
                    monBouton13.setBackgroundColor(Color.CYAN);
                }
                else if (treize%4==0){
                    monBouton13.setBackgroundColor(Color.GRAY);
                }            }
        });



        monBouton14.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                quatorze+=1;
                matrice[3][0] =quatorze%4;

                if (quatorze%4==1){
                    monBouton14.setBackgroundColor(Color.RED);
                }
                else if (quatorze%4==2){
                    monBouton14.setBackgroundColor(Color.GREEN);
                }
                else if (quatorze%4==3){
                    monBouton14.setBackgroundColor(Color.CYAN);
                }
                else if (quatorze%4==0){
                    monBouton14.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton15.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                quinze+=1;
                matrice[3][1] =quinze%4;
                if (quinze%4==1){
                    monBouton15.setBackgroundColor(Color.RED);
                }
                else if (quinze%4==2){
                    monBouton15.setBackgroundColor(Color.GREEN);
                }
                else if (quinze%4==3){
                    monBouton15.setBackgroundColor(Color.CYAN);
                }
                else if (quinze%4==0){
                    monBouton15.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton16.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                seize+=1;
                matrice[3][2] =seize%4;
                if (seize%4==1){
                    monBouton16.setBackgroundColor(Color.RED);
                }
                else if (seize%4==2){
                    monBouton16.setBackgroundColor(Color.GREEN);
                }
                else if (seize%4==3){
                    monBouton16.setBackgroundColor(Color.CYAN);
                }
                else if (seize%4==0){
                    monBouton16.setBackgroundColor(Color.GRAY);
                }            }
        });

        monBouton17.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dixsept+=1;
                matrice[3][3] =dixsept%4;
                if (dixsept%4==1){
                    monBouton17.setBackgroundColor(Color.RED);
                }
                else if (dixsept%4==2){
                    monBouton17.setBackgroundColor(Color.GREEN);
                }
                else if (dixsept%4==3){
                    monBouton17.setBackgroundColor(Color.CYAN);
                }
                else if (dixsept%4==0){
                    monBouton17.setBackgroundColor(Color.GRAY);
                }            }
        });



    }


    //Affiche un message à l'écran
    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }


    //Connection Bluetooth partie 2
    private class ConnectBT extends AsyncTask<Void, Void, Void>
    {
        private boolean ConnectSuccess = true;

        @Override
        protected void onPreExecute() {

            progress = ProgressDialog.show(SendFields.this, "Connection...", "Veuillez patienter");
        }

        @Override
        protected Void doInBackground(Void... devices)
        {
            try {
                if (btSocket == null || !isBtConnected) {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    //Connecte l'appareil au périphérique Bluetooth
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    //Démarre la connection
                    btSocket.connect();
                }
            } catch (IOException e) {
                ConnectSuccess = false;
            }
            return null;
        }


        //Vérifie que tout est fonctionnel
        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            if (!ConnectSuccess) {
                msg("Echec de la connection");
                finish();
            } else {
                msg("Connecté.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }




    //Envoi le tableau multidimensionnel au module HC-06
    private void sendData()
    {

            try{
                if (btSocket != null) {
                    for (int i=0 ; i< 4 ; i++) {
                        for (int j=0 ; j<4 ; j++) {
                            btSocket.getOutputStream().write(Integer.toString(matrice[i][j]).getBytes());

                        }
                    }
                }
                }catch (IOException e){
                    msg("error");
                }


    }

    public void onClick(View v) {}


}