Auteurs: COLLE Maxime, DOUCHET Benjamin

# TP7 : Pierre-Feuille-Ciseaux

## Objectifs du TP:
On s’intéresse au jeu Pierre Papier Ciseaux , qui nous permet par sa réalisation de comprendre plus en profondeur et d'appliquer le cours sur les interfaces. 

## Générer et consulter la documentation:
La documentation générée dépend d’informations contenues dans le fichier source. Il s’agit de commentaires
compris entre les délimiteurs /** et */ et placés avant les éléments à commenter : classe, attributs, constructeurs,
méthodes.

Se placer dans le dossier racine tp7 puis se placer dans le dossier src et exécuter la commande :
```sh
%/TP7/src: javadoc pfc -d ../docs
```
## Comment compiler l'ensemble des fichier :

se placer dans le dossier src et execuiter les commandes suivantes :

```sh
%/src> javac pfc/util/io/*.java -d ../classes
```
```sh
%/src> javac pfc/util/*.java -d ../classes
```
```sh
%/src> javac pfc/strategy/*.java -d ../classes
```
```sh
%/src>javac pfc/*.java -d ../classes
```
## Comment executer manuellement le GameMane :
se placer dans le dossier classe 
```sh
%classes> java pfc.GameMain 4
```


## Compiler et exécuter les tests :

##### Compiler :
Se placer dans le dossier racine tp7
Exécuter les commandes:
```sh
%/TP7 : javac -classpath test4poo.jar test/*.java
```
##### Exécuter :
Se placer dans le dossier racine tp7
Exécuter les commandes:
```sh
%/TP7 : java -jar test4poo.jar GameTest
```

## Comment exécuter la méthode main() de GameMain :
Après avoir effectuer la complilation,
Se placer dans le dossier TP7/classes et exécuter la commande
```sh
%TP7/classes java pfc.GameMain X # où X est une int >0 pour le nombre de manches à jouer#
```

## Comment créer le fichier pfc.jar:
Se placer dans le dossier classe et exécuter les commandes (Dans le dossier tp7 vous trouvez le fichier manifest-pfc fourni):
```sh
jar cvfm ../pfc.jar ../manifest-pfc pfc
```

## Comment exécuter le fichier pfc.jar :
Se placer dans le fichier racine tp7
Exécuter la commande:
```sh
java -jar pfc.jar X
```
où X est le nombre de manche à jouer | pour jouer côté joueur 
taper : PIERRE , FEUILLE ou CISEAUX (c'est rappelé dans le programme)