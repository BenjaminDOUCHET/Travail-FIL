Auteurs: COLLE Maxime, DOUCHET Benjamin

# TP6 : Manipulation d'images

## Objectifs du TP:
On s’intéresse à la représentation et la manipulation d’images. Ces images seront constituées de pixels caractérisés
par une couleur représentant un niveau de gris.

##### Pour un apercu du travail à réaliser :
Exécuter la commande :
```sh
java -jar image.jar
java -jar image.jar /images/storm.pgm 5 16
```

## Générer et consulter la documentation:
La documentation générée dépend d’informations contenues dans le fichier source. Il s’agit de commentaires
compris entre les délimiteurs /** et */ et placés avant les éléments à commenter : classe, attributs, constructeurs,
méthodes.

Se placer dans le dossier racine tp6 puis se placer dans le dossier src et exécuter la commande :
```sh
javadoc image -d ../docs
```

## Comment compiler la classe ImageMain :
Se placer dans le dossier src et exécuter la commande :
```sh
javac Image/*.java -d ../classes
```

## Compiler et exécuter les tests :

##### Compiler :
Se placer dans le dossier racine tp6
Exécuter les commandes:
```sh
javac -classpath test4poo.jar test/*.java
```
##### Exécuter :
Se placer dans le dossier racine tp6
Exécuter les commandes:
```sh
java -jar test4poo.jar ImageTest
```

## Comment exécuter la méthode main() de MainImage :
Après avoir effectuer la complilation,
Se placer dans le dossier src/image et exécuter la commande
```sh
java ImageMain java /images/fruit.pgm 15 16
```

## Comment créer le fichier image.jar:
Se placer dans le dossier classe et exécuter les commandes (Dans le dossier tp6 vous trouvez le fichier manifest-image fourni):
```sh
jar cvfm ../image.jar ../manifest-image image images
```

## Comment exécuter le fichier image.jar :
Se placer dans le fichier racine tp6
Exécuter la commande: (ici on a  pris l'image fruit)
```sh
java -jar image.jar /images/fruit.pgm 15 16
```
