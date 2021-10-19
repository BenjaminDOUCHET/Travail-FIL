-----------------
tp-arbresbinaires
-----------------

~~~~~~~~~~
Etat du TP
~~~~~~~~~~

Décrivez ici l'état d'avancement du TP.

~~~~~~~~~~~~~~~~~~~~~~
Réponses aux questions
~~~~~~~~~~~~~~~~~~~~~~

Indiquez ici les réponses aux questions posées dans le TP. Vous
reprendrez le numéro de la section et le numéro de la question. Par
exemple pour répondre à la question 3 de la section 2.4 vous
indiquerez.


Question 5.2.1 et 5.2.2
-----------------------

traitées dans le fichier Test_arbre.c

Question 5.2.3
--------------

traitée dans le fichier Test_arbre.c



on constate que la recursion ici crée un nombre 
de calcul faramineux puisqu'il faut tou recalculer à chaque appel.


Ainsi un fois que nous avons codé de manière itérative :

traité dans le fichier Test_arbre.c

nous pouvons constater une amélioration notable du temps de calcul.


Question 5.3.1
--------------

ceci donnerai l'arbre suivant : 

.. image:: ../images/arbre_5_3_1.png
  :width: 80%
  :alt: arbre après insertion de  6, 4, 2, 7, 5 puis 1.


Question 5.3.2
--------------

traité dans le fichier Test_arbre.c

Question 5.3.3
--------------

il suffit de faire un parcours infixe , cela nous donnera tous les éléments 
dans l'ordre croissant.

Question 5.3.4
--------------

traité dans le fichier Test_arbre.c


Question 5.3.5
--------------

traité dans le fichier Test_arbre.c


Question 5.3.6
--------------

traité dans le fichier Test_arbre.c


Question 5.3.7
--------------

traité dans le fichier Test_arbre.c


sans surprise c'est le 3eme arbre le plus performant pour la recherche du 0.

en effet n comme on insère le 1 juste àprès avoir inséré le 7 qui est notre racine.
on a donc la brance de gauche de 7 qui est 1. Ainsi on prend une comparaison opur se 
rendre compte qu'on estplus petit que 7 et une autre pour se rendre comrte qu'on est 
plus petit que 1. et on a fini. 

C'est donc très rapide pour cette valeur mais pour d'autre ce sera plus long . donc il 
faudrait mener des tests pour voir le nombnre moyen de comaraisons. mais on se doute que 
pour un alphabet equiprobable il n'est pas adapté.

Question 5.3.7
--------------

les éléments min et max d'un arbre de recherche sont respectivement dans la feuille 
la plus " à gauche" et la feuille la plus "à droite "

Question 5.3.7
--------------

traitée dans le code :

traité dans le fichier Test_arbre.c

nous avons ajoutés une ligne dans le test pour tester ces deux fontions

Question 5.4.1
--------------


traité dans le fichier Test_arbre.c


Question 5.4.1
--------------


traité dans le fichier Test_arbre.c

