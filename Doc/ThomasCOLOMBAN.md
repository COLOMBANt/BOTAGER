# Cahier de suivi du projet de Thomas COLOMBAN

* Séance du 20 Décembre 2017 

J'ai formé mon groupe avec Dimitri DAVID et Charly NAKACHE. 
Nous sommes partis sur une idée de robot piloté par smartphone qui servirait a planter un potager.
L'utilisateur pourra choisir l'organisation du potager (Type de graines/Emplacement des plantes)

Nous avons défini le planning des prochains mois et nous nous sommes répartis les différentes tâches et
nous avons fait un diagramme fonctionnel du projet.



* Séance du 12 Janvier 2018 


Dans le cadre du projet, je me suis occupé de deux sous-parties :
-	L’application smartphone sous Android qui permet à l’utilisateur de choisir le type de graine à planter, et la disposition des graines sur le champ. 
-	La gestion des 4 moteurs à courant continu pour faire se déplacer le robot.

La plus grande partie de mon travail a été de programmer une application sous Android sur laquelle l’utilisateur peut choisir où et quoi planter comme graines et qui ensuite envoi les informations en Bluetooth à la carte Arduino du robot.
Pour cela j’ai choisi de tout coder moi-même que ce soit le visuel de l’application ou le protocole Bluetooth.
J’ai donc réalisé l’application avec le logiciel Android Studio qui permet de coder des applications pour Android.
Premièrement j’ai dû suivre plusieurs tutoriels pour comprendre le fonctionnement du logiciel, qui est très puissant mais donc assez complexe à prendre en main.



Voici les premiers visuels de l'appli

![Image appli 1](https://user-images.githubusercontent.com/35371013/35154120-3f38b266-fd29-11e7-9b32-c70ba3651036.png )

![Image appli 2](https://user-images.githubusercontent.com/35371013/35154241-c894b0dc-fd29-11e7-910d-800c89e948d6.png)

![Image appli 3](https://user-images.githubusercontent.com/35371013/35154243-c8fbe162-fd29-11e7-81dc-25ec536ee70f.png)

J’étais partis du principe que le rectangle central représentait le champ, et grâce au bouton inventaire situé en bas on ouvrait l’inventaire avec les différentes plantes (voir 3ème image).
Ensuite en appuyant sur un icone on pourrait faire glisser la plante là où on le souhaite sur le champ.
Il y a aussi un bouton en haut à gauche pour faire apparaitre la liste des appareils Bluetooth.

                        
* Séance du 19 Janvier 2018                        

Rédaction du README.md

J'ai fait ma partie PowerPoint dans la présentation du 23/01.
J'ai aussi commencé l'application sous Android Studio.


* Séance du 23 Janvier 2018

Présentation Orale  
Application sous AndroidStudio


* Séance du 6 février


Après plusieurs semaines passées sur le logiciel j’ai décidé de simplifier certaines fonctions de l’application, à cause de leur complexité et par manque de temps, et d’en ajouter d’autres.
Voici les nouveaux visuels:

![interface_1](https://user-images.githubusercontent.com/35371013/36198415-d8ed2458-1176-11e8-9754-c1c463bed122.png)


![interface_2](https://user-images.githubusercontent.com/35371013/36198422-df307fae-1176-11e8-8025-d30a758cd4bb.png)


Le champ où l’on va planter les graines sera modélisé par une grille de 16 boutons, car pour simplifier nous partons du principe que le champ sera divisé en 16 carreaux et il est possible de planter une graine dans chaque.
A chaque appui sur un bouton ce dernier change de couleur, pour signifier le type de plante.
Au départ tous les boutons sont grisés et c’est l’utilisateur qui choisis sur quoi appuyer en fonction du résultat qu’il veut. Il y a aussi un bouton Effacer (la croix en haut à gauche) qui va remettre toutes les cases grises, et un bouton Envoyer qui va récupérer la valeur associée à chaque bouton et l’envoi au robot par Bluetooth. 


* Séance du 22 février

Fin de la partie XML de l'application

![28942654_430170724103745_731970666_o](https://user-images.githubusercontent.com/35371013/37463904-ea8963c4-2856-11e8-9314-3dac1657d4dc.png)



![28822561_430170720770412_221739668_o](https://user-images.githubusercontent.com/35371013/37463911-efe3ecb8-2856-11e8-8d90-e533c68b748b.png)



* Séance du 15 mars 

Partie Bluetooth en Java


* Séance du 27 mars

Diaporama et présentation orale 


* Séance du 04 avril

J'ai commencé la partie de gestion des moteurs :
    - Recherche de la documentation constructeur
    - Schéma de câblage de l'arduino, de la batterie et de la carte de gestion des moteurs
    
Mon travail consistait donc à faire les fonctions de base Avancer, Reculer, Rotation et Stop du robot.
J’ai donc dû cabler ensemble les moteurs, la carte L298 V3 et une arduino Uno, et ensuite coder un programme arduino pour réaliser ces fonctions.
    
Ebauche du câblage:
![30849423_450469662073851_1439568072_o](https://user-images.githubusercontent.com/35371013/39211266-68f26b56-480b-11e8-8581-ee7544c25736.jpg)


* Séance du 17 avril


J’ai tout d’abord rencontré quelques difficultés pour comprendre le fonctionnement de la carte L298 V3. Il y a peu de documentation sur internet de cette carte car une autre carte la L298 V1 est beaucoup plus connue et remplit la même fonction avec seulement 2 entrées moteur au lieu de 4 pour la L298 V3. J’ai donc principalement raisonné par déduction en me basant sur la documentation constructeur de la L298 V1 et j’ai effectué de nombreux tests pour comprendre son fonctionnement.

Soudure des différentes parties de la carte
Problème avec l'alimentation de la carte L298N V3


* Séance du 02 mai

Schéma de câblage final:

![cablage](https://user-images.githubusercontent.com/35371013/40678945-28257266-6382-11e8-90ee-5eb36963c260.png)

Test de rotation du robot avec le programme du magnétomètre (partie de Charly Nakache)
Le robot arrive bien à se repérer dans l'espace(orientation) et à tourner jusqu'à l'angle indiqué


* Séance du 07 mai


Réglage des derniers bugs sur l'application Android


* 20 mai 

Partie Bluetooth terminée
Partie gestion des moteurs finie
Et tout fonctionne !! 
