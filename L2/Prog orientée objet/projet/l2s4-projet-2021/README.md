# l2s4-projet-2021

# Equipe

- Churchill ATCHEDJI
- Maxime COLLE
- Benjamin DOUCHET
- Amel GUENNINECHE


## Présentation

Ce dépot renferme les fichiers sources correspondant au projet (en JAVA) de la L2-S4 dont le sujet est accessible via le lien ci-joint :  [le sujet](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

L'objectif visé est de mettre en place une modélisation basée sur le cahier de charges fourni tout en permettant de faciliter de possibles extensions à tout développeur voulant créer son propre jeu en se basant sur la modélisation proposée.

Comme indiqué dans le sujet, deux jeux ont donc été réalisés dans le projet et ont été conçus pour être joués à plusieurs.

*Ces jeux se déroulent tous de manière automatique lorsqu'une partie est lancée et les choix possibles sont faits de manière aléatoire, mais le code mis en place tient compte de possibles interactions hommes-machines s'il arrivait qu'on passe vers une version manuelle des jeux.*


Dans le répertoire racine on dispose du répertoire *bin* où sont stockés les fichiers de classe, un Makefile pour exécuter certaines commandes, le readme du projet et le répertoire *project* dans lequel se trouve les sous-répertoire *src* pour les sources, *jar* pour les archives, *tests* pour les tests , *docs* pour la documentation et *l'UML du projet* ainsi que d'autres fichiers.

Voici une vue réduite de l'arborenscense du répertoire racine.  

```sh
.
├── bin
│   ├── ...
├── docs
│   ├── ...
├── jar
│   ├── ...
├── Makefile
├── manifest-agricole
├── manifest-war
├── README.md
├── src
│   ├── ...
├── tests
│   ├── ...
└── UMLProjet2021.pdf


```

## Mise en place de l'environnement d'exécution
Tout le projet étant codé en JAVA et se trouvant sur un dépôt git, il est indispensable de disposer de git, d'un terminal (sous linux serait bien pour le Makefile), de JAVA(jre et jdk) pour la compilation des fichiers de classe et l'exécution des classes main.


Tout d'abord il faut récupérer le projet via git :

> * depuis votre poste de travail placer vous dans un répertoire courant,
> * ouvrer votre terminal dans ce répertoire ou depuis votre terminal accéder à votre répertoire courant,
> * vérifier si vous disposez du logiciel de gestion de version git en entrant dans le terminal la commande : __*git --version*__ ,une version de git devrait donc s'afficher si c'est le cas, sinon se référer à ce __lien : [installer git](https://git-scm.com/book/fr/v2/D%C3%A9marrage-rapide-Installation-de-Git)__ pour installer git sur votre machine afin de récupérer git,

> *aperçu:*
```sh
.../~ git --version
git version 2.25.1
``` 
 
> * récupérer ensuite le projet sur le dépôt distant via la commande : 
```sh
.../~ git clone git@gitlab-etu.fil.univ-lille1.fr:douchet/l2s4-projet-2021.git
``` 
> pour cloner via *HTTPS* : 
```sh
.../~ git clone https://gitlab-etu.fil.univ-lille1.fr/douchet/l2s4-projet-2021.git
```
> pour  cloner via *SSH*  *( se référer au __lien : [accéder en SSH à un depôt git](https://www.youtube.com/watch?v=qixAZdj-I4I)__ pour lier son gitlab à sa machine via SSH)*
> * placer vous ensuite dans le répertoire *l2s4-projet-2021* via le terminal.

## Génération de la documentation

Vous avez la possibilité de générer la documentation du projet afin de prendre en main toutes les classes, paquetages et méthodes qui ont été utilisées ou construites pour sa mise en œuvre.

Depuis vote répertoire l2s4-projet-2021 :
* vérifier que vous disposez de la version 11 de java ou d'une version ultérieure en exécutant :
```sh
.../l2s4-projet-2021$ javac -version
```

*Voici un aperçu*
```sh
.../l2s4-projet-2021$ javac -version
javac 11.0.11
```

 **sinon** se référer au lien  __[oracle](https://www.oracle.com/java/technologies/javase-downloads.html)__    pour installer java sur votre système(version postérieure ou égale à 11)

* ensuite exécuter la commande suivante dans le terminal:
```sh
.../l2s4-projet-2021$ make doc
```
 
Vous pouvez consulter le contenu du sous-dossier */docs* dans le répertoire */project* et particulièrement le fichier *index.html* que vous pouvrez ouvrir dans un navigateur pour consulter une documentation détaillée de chaque paquetage du projet ainsi que les classes, méthodes et attributs utilisés. 



## Compilation des classes du projet
Pour compiler tous les fichiers __.java__ du projet, il suffit toujours depuis répertoire *l2s4-projet-2021* d'exécuter la commande :
```sh
..../l2s4-projet-2021$ make cls
```
Les fichiers de sources devraient donc être compilés. Vous pourrez vérifier le contenu du sous-répertoire *bin* où le contenu correspond aux packages du projet contenant eux-mêmes les fichiers *.class* .


## Exécution des différents jeux du projet
Pour exécuter les deux jeux mis en place, placez-vous dans le sous-répertoire */bin* dans le terminal :
 * lancer la commande : 

 ```sh
 .../l2s4-projet-2021/bin$ java game.WarMain player1 player2
 ```
 pour faire jouer le jeu de guerre (WarGame) entre *player1* et *player2*,
 
 * lancer la commande : 
  ```sh
 .../l2s4-projet-2021/bin$ java game.AgricoleMain player1 player2
 ```
 pour faire jouer le jeu agricole (AgricoleGame) entre *player1* et *player2*.
 
Pour chacune des commandes données ci-dessus, les arguments *player1* et *player2* peuvent être remplacées par de vrais noms et le jeu peut se jouer pour un grand nombre de joueurs passés en argument.


## Exécution des tests fournis

Des tests sont fournis dans le projet (sous-répertoire */tests* ) afin de tester le code écrit.

__*Un test est réussi et donc passé avec succès par le code qu'il évalue, quand toutes les assertions qu'il contient sont vérifiées.*__
Cela reviendrait à avoir de manière graphique après l'exécution d'un fichier de test **une barre verte**.

Pour pouvoir exécuter les fichiers de tests simplement, nous vous conseillons d'ouvrir le projet sous eclipse.
Voici un lien présentant des ressources permettant de prendre en main facilement le logiciel eclipse : __[prise en main eclipse](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)__

Une fois cela fait, placez-vous dans le sous-répertoire */tests*  et choisissez un fichier de test (ex : WarTest.java),
puis exécuter-le via le Runner (petit bouton vert dans la barre supérieure d'eclipse). Une barre verte en haut à gauche de votre fenêtre eclipse devrait apparaitre 
pour signifier que le test s'est bien déroulé.

__NB__ : Il se pourrait qu'eclipse vous suggère de configurer la librairie de test, si cela arrive il vous suffit de choisir Junit4 ou Junit5 pour pouvoir exécuter les tests.

Pour créer ses propres fichiers de tests, nous vous conseillons de suivre la structure établie pour nos fichiers de tests.


## Les archives

Le sous-répertoire **jar**  contient deux fichiers JAR exécutables :

 * le premier nommé guerre.jar exécute le jeu de guerre sur un plateau 10x10 et prends sur la ligne de commande le nom des joueurs (le nombre n'étant pas déterminé à 	l'avance)

	```sh
	.../l2s4-projet-2021/jar$ java -jar jar/guerre.jar Raymond Odette
	```
 * le second nommé agricole.jar  exécute le jeu agricole sur un plateau 10x10 et prends sur la ligne de commande le nom des joueurs (le nombre n'étant pas 		déterminé à l'avance)
 
	```sh
    	.../l2s4-projet-2021/jar$ java -jar jar/agricole.jar Vigneron Eleveur Maraicher
	```


Pour construire ces archives, vous pouvez exécuter les commandes(depuis le répertoire racine) : 

```sh
.../l2s4-projet-2021/make guerre.jar
```

pour construire l'archive pour le jeu de guerre 

ou 

```sh 
.../l2s4-projet-2021/make agricole.jar
```
pour construire l'archive pour le jeu agricole



# Bon à savoir : 

Le fichier Makefile fournis supporte :

    make clean (pour supprimer les fichiers .class)
    make doc (pour produire la javadoc)
    make guerre.jar 
    make agricole.jar
    make cls (pour produire les fichier .class)



#### Class BOARD.

Pour l'algorithme de génération du plateau afin de faciliter le choix aléatoire des 
tuiles "non-ocean" nous avions créé une "bibliothèque" de tuiles disponibles pour le jeu
dans un tableau qui nous sert de référence ;  à l'aide d'un ```nextInt``` on vient prendre un 
indice de ce tableau et on clone la tuile y siègeant dans notre plateau à l'aide de la 
méthode ```clone()```  de la classe *Object* préalablement implémentée dans la classe *Tile* du package *tile*.



# Livrables

## Livrable 1
 
### Semaine du 08/02
 
 Modélisation des personnages (fait ! )

## Livrable 2

### Semaine du 01/03
 
 Modélisation du plateau (fait ! )

## Livrable 3

### Semaine du 22/03
 
 Modélisation des actions (fait ! )

## Livrable 4

### Semaine du 12/04
 
 Modélisation complète (fait ! )

