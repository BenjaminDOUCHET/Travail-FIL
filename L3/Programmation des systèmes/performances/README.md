#   Performances des entrées/sorties

## Colle Maxime & Douchet Benjamin

les manipulations qui suivent sont à réaliser dans l'emplacement racine du dossier "perfomance" 

## Présentation du tp et de ses objectifs

mettre en oeuvre des appels systèmes pour reprogrammer la commmande cat de unix. 

produire des mesures de temps sur ces appels et un graph pour les lires 

Analyser les résultats

## compilation est execution du programme seul : 

```sh
make myCat
```


## compilation et execution du test via le script founi :

```sh
make test
```

## création du graph de résultat :
```sh
$ gnuplot run.gnu
```


### remarque sur le tp :

#### avancement

Toutes les question on été traitées.

#### difficultées 

La difficulté majeure du tp a étrangement été la gestion du script shell, je nous trouve sous formé 
sur ce support et l'ajoute donc à la liste des chose à travailler de mon côté car j'ai perdu un temps fou 
sur des erreur de synthaxe toute bête ( un espace qui traine au mauvais endroit etc.)

#### analyse


On peut voir dans ce tp tout l'interet d'un buffer dans le rapport de consomation temps / espace.
notemment en regardant le croisement de la verion std avec la version des precedentes questions. où pour des tailles de buffer trop petite cela est plus gourmand que de passer pas la librairie standard.

cependant , même si augmenter la taille d'un buffer présente un intêret évident on peut voir qu'a un certain stade 
le gain engendré par l'augementation de la taille de buffer n'est plus significatif.

au final c'est une question de dosage entre la mémoire à allouer et la vitesse de lecture recherchée.



