# PROJET COO : Competition

## Rapide introduction sur le sujet du projet

#### description du projet

Le but de ce projet était de modéliser différentes compétitions qui mettent en oeuvre 
différents compétiteurs au travers de différents sorte de match.<br>

Dans un premier temps nous avons donc travaillé sur une sorte de match ainsi qu'une sorte de compétiteur.

#### Diagramme UML

*Le diagramme UML :*
[uml](./competition/UML.pdf)

## Rubrique "HowTo"

#### Comment compiler l'ensemble des fichiers :

Se placer dans le dossier **src** <br>Executer la commande suivante :
```sh
coo/competition/src$ make compil
```

###### Compiler :

#### Compiler et exécuter les tests :

###### Compiler :

Se placer dans le dossier racine projet<br>Exécuter les commandes:
```sh

```


###### Exécuter :

Se placer dans le dossier racine projet<br>Exécuter les commandes:
```sh

```

#### Générer la documentation:

La documentation générée dépend d’informations contenues dans le fichier source.<br>Il s’agit de commentaires compris entre les délimiteurs /** et */ et placés avant les éléments à commenter : classe, attributs, constructeurs, méthodes.<br>Se placer dans le dossier racine **competition** puis se placer dans le dossier **src** et exécuter la commande :
```sh
coo/competition/src$ make doc
```

#### Comment exécuter les méthode main() du projet :

*Après avoir effectuer la complilation* <br>Se placer dans le dossier **competition/classes** et exécuter les commandes :
```sh
coo/competition/classes$ make tournament
```
```sh
coo/competition/classes$ make league
```


#### Comment créer les fichiers jars:

Se placer dans le dossier **classes** <br>Exécuter les commandes (vous trouvez le fichier *manifest-projetcoo* fourni):
```sh
coo/competition/classes$ make jarLeague
```
```sh
coo/competition/classes$ make jarTournament
```

#### Comment exécuter les fichiers jars:

Se placer dans le fichier **competition** du projet<br>Exécuter la commande:<br>
```sh
coo/competition$ make runTournament
```
```sh
coo/competition$ make runLeague
```


## Présentation d’élements de code saillants

#### Eléments de conception nous jugeons intéressants/importants

Nous avons fait le choix de voir le programme comme une *table de répartition* utilisé par un gestionnaire de compétition.<br>De fait , quelques choix de conception s'en sont suivis.<br>Les Competiteur sont symbolisé par une classe qui porte l'information de leurs nombre de points tel *une fiche le représentant*.
