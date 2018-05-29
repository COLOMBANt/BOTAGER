
#include <SPI.h>
#include <LoRa.h>
// definition des différents pin de bases de l'arduino-Lora
// Pin definetion of WIFI LoRa 32
// HelTec AutoMation 2017 support@heltec.cn 
#define SCK     5    // GPIO5  -- SX1278's SCK
#define MISO    19   // GPIO19 -- SX1278's MISO
#define MOSI    27   // GPIO27 -- SX1278's MOSI
#define SS      18   // GPIO18 -- SX1278's CS
#define RST     14   // GPIO14 -- SX1278's RESET
#define DI0     26   // GPIO26 -- SX1278's IRQ(Interrupt Request)

#define BAND    433E6  //you can set band here directly,e.g. 868E6,915E6
#define PABOOST true

String outgoing;              // message sortant
int rssi;
byte localAddress = 0xBC;     // adresse des poteaux (0xBE pour le poteau 1 et OxBC pour le poteau 2)
byte destination = 0xBA;      // destinataire
String incoming = "";
byte msgCount = 0;            //conteur de messages
long lastSendTime = 0;        // "Heure" du dernier envoie
int interval = 2000;          //interval entre chaque envoie
byte robot=0xBB;              //adresse du robot
int rssiE=-58;                //Valeur de Rssi à 1m

void setup()
{
  Serial.begin(115200);                   // initialisation serial
  while (!Serial);

  SPI.begin(SCK,MISO,MOSI,SS); //iniialisation du bluetooth
  LoRa.setPins(SS,RST,DI0);

  if (!LoRa.begin(BAND,PABOOST))
  {             // initialize ratio at 915 MHz
    Serial.println("LoRa init failed. Check your connections.");
    while (true);                      //En cas d'échec de la connection
  }

  Serial.println("LoRa init succeeded.");  //En cas de succes de la connexion
}

void loop()
{ /*On re-envoie un message avec un intervalle aléatoire compris entre 1 et 3 secondes
 (Pour éviter une interférence avec d'autres messages circulant sur les mêmes fréquences*/
  if (millis() - lastSendTime > interval) 
  {
    String message = String(distance(rssi)); //Renvoie la distance liée à la RSSI du message émit par le robot
    Serial.println(rssi);//Simplement pour controler
    sendMessage(message);
    
    lastSendTime = millis();            //actualise "l'heure" du dernier envoie
    interval = random(2000) + 1000;    // génère un nouvel interval
  }

 
  onReceive(LoRa.parsePacket()); //Action à effectuer à la réception
}

void sendMessage(String outgoing)
{
  LoRa.beginPacket();                   // start packet
  LoRa.write(destination);              // add destination address
  LoRa.write(localAddress);             // add sender address
  LoRa.write(msgCount);                 // add message ID
  LoRa.write(outgoing.length());        // add payload length
  LoRa.print(outgoing);                 // add payload
  LoRa.endPacket();                     // finish packet and send it
  msgCount++;                           // increment message ID
}

void onReceive(int packetSize)
{
   int recipient = LoRa.read();          // recipient address
  byte sender = LoRa.read();            // sender address
  byte incomingMsgId = LoRa.read();     // incoming msg ID
  byte incomingLength = LoRa.read();    // incoming msg length

  String incoming = "";
  if (packetSize == 0) return;          // if there's no packet, return
  if (sender ==robot) {rssi=LoRa.packetRssi();
  Serial.println(rssi);}
  while (LoRa.available()){
   incoming+= (char)LoRa.read();}

}

double distance (int rssi){
  float ratio=rssiE-rssi;
  double d=pow(10,(ratio/20));
  return(d);
}


