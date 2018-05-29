


#include <Arduino.h>
#include <Wire.h>
#include <HMC5883L_Simple.h>
#include <math.h>

HMC5883L_Simple Compass;



const int moteurD1=5;
const int moteurD2=4;
const int moteurG1=2;
const int moteurG2=3;
const int pwm=9;
String tableau[3];
double d1=0;
double d2=12;
double d3=12;
int x1=12;
int y2=12;
float x;
float y;
double angleRef;
const int pwmPiston=6;
const int piston1=7;
const int piston2=8;




void setup() {
Serial1.begin(115200);
Serial.begin(9600);
pinMode(moteurD1, OUTPUT);
pinMode(moteurD2, OUTPUT);

pinMode(moteurG1, OUTPUT);
pinMode(moteurG2, OUTPUT);

pinMode(piston1, OUTPUT);
pinMode(piston2, OUTPUT);

pinMode(pwm, OUTPUT);
pinMode(pwmPiston,OUTPUT);
analogWrite(pwmPiston,250);
analogWrite(pwm, 110);        // Sortie PWM qui modifie la vitesse de rotation des moteurs

Wire.begin();
Compass.SetDeclination(23, 35, 'E'); 
Compass.SetSamplingMode(COMPASS_SINGLE);
Compass.SetScale(COMPASS_SCALE_130);
Compass.SetOrientation(COMPASS_HORIZONTAL_Y_NORTH);

}

void loop() {
  //Serial.println("oui");
  String incoming="";
  int i=0;
  String courant;
  String chaineCourante;
  while(Serial1.available()) {      // If anything comes in Serial (USB),
    incoming+=(char)Serial1.read();   // read it and send it out Serial1 (pins 0 & 1)
  }
  Serial.println(incoming);
  delay(500);
  if(incoming.length()>4){
  distance(incoming);}
  getX();
  getY();
  //Serial.println("d1 :"+ String(d1)+"d2 :"+String(d2)+"d3 :"+String(d3));
  Serial.println("x :"+String(x)+",y :"+String(y)); 
}



void goTo(double tX, double tY){
  getX();
  getY();
  double angle=atan((tY-y)/(tX-x));
  if(tX>x && tY<y){
    rotation(angleRef+90+angle);
    while(tX>x || tY<y){
      avancer(500);
      getX();
      getY();
      if(x>tX){rotation(angleRef+180);}
      else if (y<tY){rotation(angleRef+90);}
      else if (x>tX-0,5 && x<tX+0,5 && y>tY+0,5 && y<tY-0,5){
        stop();
        return;
      }
    }
  }
  else if(tX>x && tY>y){
    rotation(angleRef+angle);
    while(tX>x && tY>y){
      avancer(500);
      getX();
      getY();
      if(x>tX){rotation(angleRef);}
      else if (y>tY){rotation(angleRef+90);}
      else if(x>tX-0,5 && x<tX+0,5 && y>tY+0,5 && y<tY-0,5){
        stop();
        return;
      }
      }
    }
  
  else if(tX<x &&tY>y){
    rotation(angleRef-90+angle);
    while(tX<x && tY>y){
      avancer(500);
      getX();
      getY();
      if(x<tX){rotation(angleRef);}
      else if (y>tY){rotation(angleRef-90);}
      else if(x>tX-0,5 && x<tX+0,5 && y>tY+0,5 && y<tY-0,5){
        stop();
        return;
      }
      }
    
  }

  else if(tX<x &&tY<y){
    rotation(angleRef-90+angle);
    while(tX<x && tY<y){
      avancer(500);
      getX();
      getY();
      if(x<tX){rotation(angleRef-180);}
      else if (y<tY){rotation(angleRef-90);}
      else if(x>tX-0,5 && x<tX+0,5 && y>tY+0,5 && y<tY-0,5){
        stop();
        return;
      }
      }
    
  }
}


void getX(){
  int d12=d1*d1;
  int d22=d2*d2;
  int d32=d3*d3;
  int x12=x1*x1;
  int y22=y2*y2;
  x=(d12-d22+x12)/(2*x1);}

void getY(){
  int d12=d1*d1;
  int d22=d2*d2;
  int d32=d3*d3;
  int x12=x1*x1;
  int y22=y2*y2;
   y=(d12-d32+y22)/(2*y2);
}

void avancer(int t){

  digitalWrite(moteurD1, HIGH);     // Les sorties D1/D2 et G1/G2 correspondent aux + et - des moteurs droit et gauche
  digitalWrite(moteurD2, LOW);      // La sortie 1 en HIGH et 2 en LOW fait avancer le moteur CC

  digitalWrite(moteurG1, HIGH);
  digitalWrite(moteurG2, LOW);
  
  delay(t);                          // On le fait avancer pendant une periode de t millisecondes 
  
}

void reculer(int t){

  digitalWrite(moteurD1, LOW);       // Même fonction que avancer mais en inverse
  digitalWrite(moteurD2, HIGH);

  digitalWrite(moteurG1, LOW);
  digitalWrite(moteurG2, HIGH);
  
  delay(t);

}

void rotation(int degre){
  int angle = 0;
  int angleTo=degre%360;
  angle = Compass.GetHeadingDegrees();      // Le magnétomètre nous donne l'orientation du robot à travers cette fonction
  int ecart = angleTo - angle;              // On calcul l'écart entre l'angle voulu et la position actuelle
  bool test=true;
  while(test){
    Serial.println(angle);
  if(angle>degre-10 && angle<degre+10){test=false;}
  
      digitalWrite(moteurD1, LOW);          // On fait avancer une roue et reculer l'autre pour faciliter la rotation
      digitalWrite(moteurD2, HIGH);

      digitalWrite(moteurG1, HIGH);
      digitalWrite(moteurG2, LOW);
      
      delay(500);
      stop();
      delay(100);
      Serial.println("sens 1");
      angle = Compass.GetHeadingDegrees();    // On recalcule la position du robot après le mouvement
  
//     digitalWrite(moteurD1, LOW);
//      digitalWrite(moteurD2, HIGH);
//
//      digitalWrite(moteurG1, LOW);
//      digitalWrite(moteurG2, HIGH);
//      delay(500);
//      stop();
//      delay(100);
//      Serial.println("sens 2");
//      angle = Compass.GetHeadingDegrees();
       
    
  }}
 
void stop(){
  
      digitalWrite(moteurD1, LOW);        // Mettre les deux sorties en LOW permet de stopper les moteurs 
      digitalWrite(moteurD2, LOW);

      digitalWrite(moteurG1, LOW);
      digitalWrite(moteurG2, LOW);
  
}

void distance(String entree){
  int i=0;
  String courant="";
  String chaineCourante="";
  Serial.println("oui");
  while(i<3){
    for(int j=0;j<entree.length();j++){
      courant=entree.charAt(j);
      if(courant==","){
        tableau[i]=chaineCourante;
        chaineCourante="";
        i++;
      }
      else{
        chaineCourante+=courant;
      }}}
      d1=tableau[0].toFloat();
      d2=tableau[1].toFloat();
      d3=tableau[2].toFloat();}



