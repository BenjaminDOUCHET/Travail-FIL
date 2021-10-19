---------------
Experimentateur
---------------


.. toctree::
   :maxdepth: 1

   experience.rst
   marker.rst
   
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
indiquerez :

Question 1.2.2
--------------

on peut compter le nombre de fois où on fais appel à 'compare'

Question 1.2.3
--------------

on peut dire qu'il y a un "pire des cas" qui serait celui où aucun des elements de markers 
ne figure dans positive. dans ce cas on a pas d'arrêt anticipé de la seconde boucle

Question 1.2.4
--------------
dans le pire des cas : 

c(m,p) = len(m)*len(p)-(len(m)-len(p))

Question 1.3.2
--------------

encore un fois le pire des cas serait des marqueurs tous "plus grand" que ceux de positive


le pire des cas serait le cas où tout le marqueurs de markers 
seraient plus grands que les marqueurs de positive.

auquel cas on connais la compléxité de la boucle de rercheche par dicotomie  : log2(n)
                                    d'une boucle for complete : n

donc on est sur 
c2(m,p) = len(m)*log2(len(p))

Question 1.4.2
--------------
on peut dire qu'il y a un "pire des cas" mais la difference sera faible.
en effet le pire des cas serait celui où les marqueurs de positive se trouvent à la fin 
de l'ensemble markers.

dans ce cas on ferais 

c3(m,p)=len(m) comparaisons 

dans le meilleurs des cas les markers de positive sont au debut de markers ,
dans ce cas on fera len(markers)-len(positive) comparaisons

Question 1.5.2
--------------

on peut voir que la dernière version est la plus perfomante car elle nécéssite un seul parcours de chaques listes.
on peut cependant noter que le tri des listes ncessaires à l'execution de la stratégie 3
a également un coût que nous n'avons pas mesurés au cours du tp.

aussi on sait qu'un tri fusion comme ici est O(nlog(n)).

si je reprends nos résultats : 

strat1 : c(m,p) = len(m)*len(p)-(len(m)-len(p))
start 2 : c2(m,p) = len(m)*log2(len(p))
strat 3 : c3(m,p)=len(m) comparaisons

en mettant à jour avec le coût des tris : 

strat1 : c(m,p) = len(m)*len(p)-(len(m)-len(p))
start2 : c2(m,p)= len(m)*log2(len(p)) + O(nlog(len(p))
start3 : c3(m,p)= len(m) comparaisons + O(nlog(len(m)) + O(nlog(len(p))


Question 1.5.6
--------------

.. image:: ../images/10-marqueurs.png
  :width: 400
  :alt: 10 maqueurs

.. image:: ../images/20-marqueurs.png
  :width: 400
  :alt: 20 maqueurs

.. image:: ../images/30-marqueurs.png
  :width: 400
  :alt: 30 maqueurs

.. image:: ../images/40-marqueurs.png
  :width: 400
  :alt: 10 maqueurs

.. image:: ../images/50-marqueurs.png
  :width: 400
  :alt: 50 maqueurs

.. image:: ../images/60-marqueurs.png
  :width: 400
  :alt: 60 maqueurs

.. image:: ../images/70-marqueurs.png
  :width: 400
  :alt: 70 maqueurs

.. image:: ../images/80-marqueurs.png
  :width: 400
  :alt: 80 maqueurs

.. image:: ../images/90-marqueurs.png
  :width: 400
  :alt: 90 maqueurs

.. image:: ../images/100-marqueurs.png
  :width: 400
  :alt: 100 maqueurs

  

