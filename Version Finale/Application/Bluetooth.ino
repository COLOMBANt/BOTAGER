//**********************************************
//Code de reference pour le module bluetooth HC-06  
// envoi de commandes AT et affichage de la rÃ©ponse du module
//
//***********************************************/*  
#include <SoftwareSerial.h>  //Software Serial Port  
#define RxD 10    //Pin 10 pour RX, PB2 sur votre board, a brancher sur le TX du HC-06
#define TxD 11    //Pin 11 pour TX, PB3 sur votre board, a brancher sur le RX du HC-06
SoftwareSerial BTSerie(RxD,TxD);  
int matrice[4][4]={{0,0,0,0},
                   {0,0,0,0}, 
                   {0,0,0,0},
                   {0,0,0,0}};
int i=0, j=0;
int cmp;

void setup()  
{  
  Serial.begin(9600);
    // Configuration du bluetooth  
  pinMode(RxD, INPUT);  
  pinMode(TxD, OUTPUT);  
  BTSerie.begin(9600); 
    Serial.println("En attente de la commandes AT"); 
    delay(100);
  // Test des commandes AT  
  BTSerie.print("AT+VERSION");  //Demande le NÂ° de version 
  delay(1000);  
  cmp=0;
//  for(int n=0;n<4;n++){
//    for(int m=0;m<4;m++){
//      matrice[n][m]=0;
//    }
//  }
  }  
void loop()  
{  
  char recvChar;  
  //On lit caractere par caractere sur le BTSerie et on affiche sur le Terminal Serie  
  if (BTSerie.available()) {  
    recvChar = (int)BTSerie.read(); //lecture

   
    Serial.print("i ");
    Serial.print(i);
    Serial.print("\t");
    Serial.print("j ");
    Serial.print(j);
    Serial.print("\t");
    Serial.print(matrice[i][j]);
    Serial.print("\t");
    Serial.print(recvChar);
    Serial.print("\t");
    
    matrice[i][j]=recvChar;
    j=j+1;
    if(j>3){
      j=0;
      i=i+1;
    }
    if(i>3){
      j=0;
      i=0;
    }
    Serial.print(recvChar);
    Serial.print("\t");
    Serial.println(matrice[i][j]);  //ecriture
    
   
  }
  //On lit caractere par caractere sur le terminal et on affiche sur le BT Serie 
  if (Serial.available()) {  
    recvChar = Serial.read(); //lecture
    BTSerie.write(recvChar);  //ecriture
  }  
  cmp=cmp+1;
}  
