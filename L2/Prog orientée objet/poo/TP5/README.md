Auteurs: COLLE Maxime, DOUCHET Benjamin

# TP5 : Paquetages, compilation, exécution, documentation, tests et archives

## Objectifs du TP:
Apprendre à utiliser des paquets, générer de la documentation,compiler et exécuter des tests unitaires, coder des tests unitaires, gérer des archives java.
La classe Date permet de manipuler différentes dates (elle permet de savoir combien de jours séparent deux dates).

## Paquetages :

##### Pour créer un paquetage :
Dans le dossier src, créez un dossier pour le paquetage factory.
Dans ce dossier créez un dossier date qui contiendra les classes du paquetage
factory.date.

Vérifier que dans l'entête du fichier les package (et si besoin import) sont bien présent.

En ce qui concerne les fichiers date, verifier qu'ils sont bien présent dans un dossier date et qu'ils possèdent tous en entête:
```java
package date;
```
Pour le fichier DateMain en particulier, il doit être présent :
```java
import date.Date;
import date.Month;
```

## Compiler les sources du projet:
Se placer dans le dossier src
Exemple pour les fichiers Date:
```sh
javac Date.java -d ../classes
javac date/DateMain.java -d ../classes
```
Il n'y a pas besoin de compiler le fichier Month.java parce que Month et Date sont dépendantes l'un de l'autre.
(de même pour Box.java et ConveyerBelt.java)

## Exécuter les tests:
Se placer dans le dossier racine tp5
Exécuter les commandes:
```sh
java -jar test4poo.jar DateTest
java -jar test4poo.jar RobotTest
java -jar test4poo.jar BoxTest
```

##### De plus, pour les fichiers Test vérifier que vos dossiers possèdent bien dans le corps de la classe le code suivant:
```java
public static junit.framework.Test suite() {
return new junit.framework.JUnit4TestAdapter(SomeClassTest.class);
}
```

## Générer et consulter la documentation:
La documentation générée dépend d’informations contenues dans le fichier source. Il s’agit de commentaires
compris entre les délimiteurs /** et */ et placés avant les éléments à commenter : classe, attributs, constructeurs,
méthodes.
Par exemple pour la méthode nbDays du fichier Mounth.java :
```java
/**
   * returns the number of days in the month
   * @param y the year in which there is the month we want to know the number of days
   * @return the number of days in the month
   */
```

Se placer dans le dossier racine tp5 puis se placer dans le dossier src et exécuter la commande :
```sh
javadoc date -d ../docs
```

## Compiler les tests:
Se placer dans le dossier racine tp5 et exécuter les commandes:
```sh
javac -classpath test4poo.jar test /DateTest.java
javac -classpath test4poo.jar test /RobotTest.java
javac -classpath test4poo.jar test /BoxTest.java
```

## Générer le fichier .jar:
Se placer dans le dossier classes et exécuter les commandes:
Dans le dossier tp5 vous trouvez le fichier manifest-date fourni
```sh
jar cvfm ../date.jar ../ manifest-date date
```

## Exécuter le fichier (jar) :
Se placer dans le fichier racine tp5
Exécuter les commandes:
```sh
jar tvfm date.jar
java -classpath date.jar date.DateMain
```