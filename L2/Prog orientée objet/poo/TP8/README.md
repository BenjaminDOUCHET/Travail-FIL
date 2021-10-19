Auteurs: COLLE Maxime, DOUCHET Benjamin

# TP8 : Agence de location

## Objectifs du TP:
On s’intéresse au TD sur les agences de locations, nous permettant de manipuler les collections et les tables d hachages ainsi qu'une mise en oeuvre de l'heritage.

## Comment compiler l'ensemble des fichiers :

Se placer dans le dossier src et execuiter la commande suivante :

```sh
%TP8/src$ javac rental/*.java -d ../classes
```

## Compiler et exécuter les tests :

##### Compiler :
Se placer dans le dossier racine TP8
Exécuter les commandes:
```sh
%/TP8$ javac -classpath test4poo.jar test/rental/*.java
```

##### Exécuter :
Se placer dans le dossier racine TP8
Exécuter les commandes:
```sh
%/TP8$ : java -jar test4poo.jar rental.RentalAgencyTest
```
```sh
%/TP8$ : java -jar test4poo.jar rental.AndFilterTest
```
```sh
%/TP8$ : java -jar test4poo.jar rental.BrandFilterTest
```
```sh
%/TP8$ : java -jar test4poo.jar rental.ClientTest
```
```sh
%/TP8$ : java -jar test4poo.jar rental.MaxPriceFilterTest
```
```sh
%/TP8$ : java -jar test4poo.jar rental.SuspiciousRentalAgencyTest
```
```sh
%/TP8$ : java -jar test4poo.jar rental.VehicleTest
```

## Générer la documentation:
La documentation générée dépend d’informations contenues dans le fichier source. Il s’agit de commentaires
compris entre les délimiteurs /** et */ et placés avant les éléments à commenter : classe, attributs, constructeurs, méthodes.

Se placer dans le dossier racine TP8 puis se placer dans le dossier src et exécuter la commande :
```sh
%/TP8/src$ javadoc rental -d ../docs
```

## Comment exécuter la méthode main() de MainAgency :
Après avoir effectuer la complilation,
Se placer dans le dossier TP8/classes et exécuter la commande
```sh
%TP8/classes> java rental.MainAgency
```

## Comment créer le fichier rental.jar:
Se placer dans le dossier classes et exécuter les commandes (Dans le dossier tp8 vous trouvez le fichier manifest-agence fourni):
```sh
%TP8/classes$ jar cvfm ../rental.jar ../manifest-agence rental
```

## Comment exécuter le fichier rental.jar :
Se placer dans le fichier racine TP8
Exécuter la commande:
```sh
%TP8$ java -jar rental.jar
```