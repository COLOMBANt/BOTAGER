
# Cahier de suivi du projet de David Dimitri

* Séance du 20 Décembre 2017 

J'ai formé mon groupe avec Thomas COLOMBAN et Charly NAKACHE. 
Nous sommes partis sur une idée de robot piloté par smartphone qui servirait a planter un potager.
L'utilisateur pourra choisir l'organisation du potager (Type de graines/Emplacement des plantes)

Nous avons défini le planning des prochains mois et nous nous sommes répartis les différentes tâches et
nous avons fait un diagramme fonctionnel du projet.


* Vacances de Noël 

J'ai recherché des solutions et voies à explorer pour reussir a positionné le robot dans l'espaces.

* Semaine du 12 Janvier 2018 : 

Familiarisation avec les module LoRa, et élaboration du github.

* Semaine du 19 janvier 2018 :

Réalisation du modèle de notre robot sur inventor.
Premier test des modules Heltec Lora.

* Semaine du 26 janvier 2018 :

Réalisation d'une première maquette virtuelle sur AutoDesk.
Début de la rédaction d'un code de trilatération.

* Semaine  du 2 février 2018 :

Réception des modules commander, premier pas avec eux et encore rédaction du programme de trilatération.

* Semaine du 9 février 2018 :

Après test de mon code de trilatération, je me rend compte que la précision des mesures pouvaient mettre dans un cas où l'étude de l'intersection de 3 cercles ne comportais pas de solutions. Je suis donc à la recherche du solution alternative.


* Semaine du 15 février 2018 :

Après des recherches j'essaye de trouver une méthode utilisant la barycentre pondéré des 3 poteaux pour trouver l'emplacement du mobile. La tache la plus compliqué dans cela est de trouver des coefficients permettant de retrouvé l'emplacement dans tout les cas, je suis donc actuellment en trin d'étudier diverses solutions possibles.

* Semaine du 22 février 2018 :

Beaucoup de problème pour trouver une methode permettant la résolution sytematique du problème. Je pense négliger cette partie pour le moment, je vais pour l'instant faire seulement un solveur d'équation puis si le temps me le permet essayer de retrouver une solution a la fin. Je rencontre aussi beaucoup de probleme avec les codes, les variables numériques ont tendances à s'arrondir lors de convertion d'une façon qu'il ne devrais pas être.

* Semaine du 1 Mars :

Des problèmes d'interference entre les modules, les messages s'enmêle. Je cherche une solution pour s'incroniser les différents envoie de données.

* Semaine du 7 Mars :

Probleme regler, en utilisant des intervalles et la fonction millis. Le temps d'acquisition est certes plus long, mais cela fonctionne parfaitement. Aussi, il me semble qu'un des module presente un default, il refusent de se compiler, même si le codes est fonctionneles sur les autres modules.

* Semaine du 14 mars :

Sur la proposition de monsieur Ferrero je vais integrer une variation de frequence d'envoie dans le systeme afin d'optimiser la mesure de distance. Aussi, il m'as mit a dispostion ses codes qu'il utilisent sur les même modules que moi, domage que ce soit si tard.

* Semaine du 21 mars :

 Finissions du code pour trouver la postion du robot, celui marche même avec les écart de mesures des modules bluetooth.
 Redaction d'un code pour rassembler les données sur le robot.
 
 * Semaine du 28 Mars :
 
 Dessins des plans des pièces à découper ou à imprimer pour la construction de la structure du robot.
 
 * Semaine du 5 Avril :

  Assemblage de la structure du robot avec Charly , et teste des différents éléments mobiles (actionneur, moteur pas à pas, ...)
  
  * Semaine du 12 Avril :
  
  Début de rédaction du programme pour venir chercher et déposer la graine que l'utilisateur à choisit.
  
  * Semaine du 20 Avril :
  
  Etablissement d'une fonction permettant de positionner le robot dans un certain angle choisie, par rapport au repère.
  Utilisation du magnétomètre.
  
  *Semaine du 30 avril :
  
  Nouveau problème dans la communication entre les modules LoRa,source du probleme inconnue, j'ai du reprendre les codes.
  
  * Semaine du 1 mai :
  
  Redaction du programme de deplacment d'un point A à un point B.
  
  * Semaine du 7 mai :
  
  Test de déplacment du robot. Echec à cause de mesure de RSSI variant de plusisuer dizaies de décibels.
  
  * Semaine du 14 mai :
  
  idem que la semaine passé, nous n'arrivons pas à solutionner le problème.
  
  * Semaine du 21 mai :
  
  Redaction d'un programme de démonstration n'utilisant pas la localisation
  
  * Semaine du 28 mai :
  
  Compte rendu et préparation de l'oral, denière finissions, tournage de la vidéo de présentation.
 
 
