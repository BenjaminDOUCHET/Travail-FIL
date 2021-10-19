Ceci est le répertoire de rendus de POO

Membre du bînome :
COLLE Maxime
DOUCHET Benjamin
étudiants L2 informatique Groupe 2A

##########

Présentation du TP et ses Objectifs :
Le but de ce TP est d’apprendre à écrire et à générerune documentation « javadoc », d’apprendre à coder une classe en s’appuyant sur des tests, de se familiariser avec la manière d’écrire des tests par l’étude de tests fournis.

##########

Comment générer et consulter la documentation :
La documentation « javadoc » d’un élément correspond au bloc de commentaire placé juste avant cet
élément et délimité par /** et */
La documentation peut être générée à l’aide de l’outil javadoc a partir de cette ligne de commande :
javadoc "fichier dont on veux la docs" -d docs
Pour consultez le contenu de ce dossier, ouvrez le fichier index.html qu’il contient dans un navigateur.

##########

Comment compiler les classes du projet :
Pour compiler les classes du projet vous povez utiliser la commande :
javac "fichier.java"

##########

Comment compiler et exécuter les tests :
commencer d'abord par le compiler :
javac -classpath test4poo.jar "fichierTest.java"
Puis pour exécuter les test dans une interface graphique claire, vous pouvez utiliser la commande :
java -jar test4poo.jar "fichierTest(sans extension.java)"

##########

pour executer le programme BikeStationMain.java qui sers de programme de "Test" de ce tp
qui vas executer les instructions du sujet Q14.

1/ se placer dans le dossier SRC ( cd SRC )
2/ si ce n'est pas fait , compiler les different fichiers SRC ( javac <nomdufichier> )
3/ pour executer => java BikeStatioMain n
Où n est un int qui correspond a la place du velo que l'on souhaite recherché dans la methodes main.
En cas d'abcenses de l'arguments, la méthode ira chercher l'indice par defaut : 1
