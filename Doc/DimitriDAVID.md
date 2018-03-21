
# Cahier de suivi du projet de David Dimitri

* Séance du 20 Décembre 2017 

J'ai formé mon groupe avec Thomas COLOMBAN et Charly NAKACHE. 
Nous sommes partis sur une idée de robot piloté par smartphone qui servirait a planter un potager.
L'utilisateur pourra choisir l'organisation du potager (Type de graines/Emplacement des plantes)

Nous avons défini le planning des prochains mois et nous nous sommes répartis les différentes tâches et
nous avons fait un diagramme fonctionnel du projet.


* Vacances de Noël 

J'ai recherché des solutions et voies à explorer pour reussir a positionné le robot dans l'espaces.

* Séance du 12 Janvier 2018 : 

Familiarisation avec les module LoRa, et élaboration du github.

* Séance du 19 janvier 2018 :

Réalisation du modèle de notre robot sur inventor.
Premier test des modules Heltec Lora.

* Séance du 26 janvier 2018 :

Réalisation d'une première maquette virtuelle sur AutoDesk.
Début de la rédaction d'un code de trilatération.

* Séance  du 2 février 2018 :

Réception des modules commander, premier pas avec eux et encore rédaction du programme de trilatération.

* Séance du 9 février 2018 :

Après test de mon code de trilatération, je me rend compte que la précision des mesures pouvaient mettre dans un cas où l'étude de l'intersection de 3 cercles ne comportais pas de solutions. Je suis donc à la recherche du solution alternative.


* Séance du 15 février 2018 :

Après des recherches j'essaye de trouver une méthode utilisant la barycentre pondéré des 3 poteaux pour trouver l'emplacement du mobile. La tache la plus compliqué dans cela est de trouver des coefficients permettant de retrouvé l'emplacement dans tout les cas, je suis donc actuellment en trin d'étudier diverses solutions possibles.

*Semaine du 22 février 2018 :

Beaucoup de problème pour trouver une methode permettant la résolution sytematique du problème. Je pense négliger cette partie pour le moment, je vais pour l'instant faire seulement un solveur d'équation puis si le temps me le permet essayer de retrouver une solution a la fin. Je rencontre aussi beaucoup de probleme avec les codes, les variables numériques ont tendances à s'arrondir lors de convertion d'une façon qu'il ne devrais pas être.

*Semaine du 1 Mars :

Des problèmes d'interference entre les modules, les messages s'enmêle. Je cherche une solution pour s'incroniser les différents envoie de données.

*Semaine du 7 Mars :

Probleme regler, en utilisant des intervalles et la fonction millis. Le temps d'acquisition est certes plus long, mais cela fonctionne parfaitement. Aussi, il me semble qu'un des module presente un default, il refusent de se compiler, même si le codes est fonctionneles sur les autres modules.

*Semaine du 14 mars :*

Sur la proposition de monsieur Ferrero je vais integrer une variation de frequence d'envoie dans le systeme afin d'optimiser la mesure de distance. Aussi, il m'as mit a dispostion ses codes qu'il utilisent sur les même modules que moi, domage que ce soit si tard.
