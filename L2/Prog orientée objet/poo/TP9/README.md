Auteurs: COLLE Maxime, DOUCHET Benjamin

# TP9 : Jeu de l'oie

## Objectifs du TP:
On s’intéresse au TD sur le jeu de l'oie.

## Comment compiler l'ensemble des fichiers :

Se placer dans le dossier src et execuiter la commande suivante :

```sh
%TP9/src$ javac goosegame/*.java goosegame/board/*.java goosegame/cell/*.java goosegame/util/*.java -d ../classes
```

## Compiler et exécuter les tests :

##### Compiler :
Se placer dans le dossier racine TP9
Exécuter les commandes:
```sh
%/TP9$ javac -classpath test4poo.jar test/goosegame/*.java test/goosegame/board/*.java test/goosegame/cell/*.java test/goosegame/util/*.java
```

##### Exécuter :
Se placer dans le dossier racine TP9
Exécuter les commandes:
```sh
%/TP9$ : java -jar test4poo.jar goosegame.GooseGameTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.util.noPlayerRegisterExceptionTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.CellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.DepartCellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.GooseCellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.RegularCellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.TrapCellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.WaitCellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.cell.WarpCellTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.board.BoardTest
```
```sh
%/TP9$ : java -jar test4poo.jar goosegame.board.ClassicalBoardTest
```

## Générer la documentation:
La documentation générée dépend d’informations contenues dans le fichier source. Il s’agit de commentaires
compris entre les délimiteurs /** et */ et placés avant les éléments à commenter : classe, attributs, constructeurs, méthodes.

Se placer dans le dossier racine TP9 puis se placer dans le dossier src et exécuter la commande :
```sh
%/TP9/src$ javadoc goosegame -d ../docs
```

## Comment exécuter la méthode main() de GooseGameMain :
Après avoir effectuer la complilation,
Se placer dans le dossier TP9/classes et exécuter la commande
```sh
%TP9/classes> java goosegame.GooseGameMain
```

## Comment créer le fichier rental.jar:
Se placer dans le dossier classes et exécuter les commandes (Dans le dossier tp9 vous trouvez le fichier manifest-goosegame fourni):
```sh
%TP9/classes$ jar cvfm ../goosegame.jar ../manifest-oie
```

## Comment exécuter le fichier rental.jar :
Se placer dans le fichier racine TP9
Exécuter la commande:
```sh
%TP9$ java -jar goosegame.jar
```