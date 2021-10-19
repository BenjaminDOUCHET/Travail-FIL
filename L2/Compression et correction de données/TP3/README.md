# binôme COLLE Maxime DOUCHET Benjamin


------------
Partie 1
------------


exercice1.1
-----------

en faisant varier la probabilité d'erreur on constate que la sortie deviens de plus en lpus difficilement lisible. 


exercice 1.2
-------------
 à partir de 0.025 de probablilité d'erreur il deviens difficie de tenter de comprendre la signification du poeme

exercice 1.3
-------------

à partir d'une probabilité d'erreur de 0.017 nous n'arrivons plus à décompresser
le moindre fichier (même un fichier avec des erreurs dedans)


exercice 1.4
-------------

on remarque que pour un .gif à partir 0.00015 de  probabilité d'erreur on a une chance d'avoir une erreur cririque qui fausse complètment la lecture du fichier.


------------
Partie 2
------------

exercice2.1
-----------

pour 3 entrées de bit A , B , C 

on a donc:
  --> out = A&B | A&C | B&C

exercice2.2
-----------

traité dans le code (repeat.c)

exercice2.3
-----------

traité dans le code (repeat.c)

exercice2.4
-----------

ras.

exercice2.5
-----------

```sh
douchet@DESKTOP-ECG5GFE:~/CDC/TP3$ echo "Bonjour tout le monde" | ./encode repeat3 | ./decode repeat3
Bonjour tout le monde
```

exercice2.6
-----------

```sh
douchet@DESKTOP-ECG5GFE:~/CDC/TP3$ cmp -l TP-Erreurs.zip archive.zip
douchet@DESKTOP-ECG5GFE:~/CDC/TP3$ 
```

jusqu'ici tout vas bien

exercice2.7
-----------

```sh
douchet@DESKTOP-ECG5GFE:~/CDC/TP3$ cat TP-Erreurs.zip | ./encode repeat3 |./cbssm 0.03 | ./decode repeat3 > archive.zip
```
exercice2.8
-----------

nous faisons les verification avec 7z

on se rends compte avec plusieurs test à 0.01 de probabilité d'erreur que déjà nous ne sommes plus sûr de récupérer l'archive complète. 
donc on peut lire l'archive à partir de ce stade mais pas à tout les coups 

pour le .gif 

à 0.005 on peut lire l'image mais pas à tous les coups non plus. cependant sur plusieur essaie il apparait qu'on puisse afficher l'image un peu déformée plus de fois que l'image très dégradée.


------------
Partie 3
------------

exercice 3.1
------------

dans le code linear_coding.c

exercice 3.2 
-------------

```sh
douchet@DESKTOP-ECG5GFE:~/CDC/TP3/tests$ ./test_linear_coding
ALL TESTS PASSED
Tests run: 1 (including 12 assertions)
```

exercice 3.3 
-------------

```sh
douchet@DESKTOP-ECG5GFE:~/CDC/TP3$ ./view_linear_coding
Generator matrix for parity coding [5, 4, 2]
1 0 0 0 1 
0 1 0 0 1 
0 0 1 0 1 
0 0 0 1 1 
Word
0 1 1 0 
Result of the coding
0 1 1 0 0 
--------------------------------------------------
Invalid generator matrix for repeat coding
```

exercice 3.4 
-------------