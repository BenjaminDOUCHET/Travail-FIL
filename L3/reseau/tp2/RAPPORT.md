TP2 COLLE DOUCHET
-- Question 1

les étapes sont les suivante : 

-> creer le socket
-> l'abonner à l'adresse voulue
-> pour recevoir , se tenir à l'écoute en bouclant la commande de reception.
-> pour emettre meme manip qu'en simple après l'abonnement.


--Question 2 
il y a la I/O ecxeption , si l'envoie / reception echoue
la UnknowHost exception qu'on a laissé tel quel si l'hôte visé est inconnu.


--Question 3 

à priori pour avoir un client capable d'emettre et de recevoir à la fois il faut recréer une liaison duplexe.

Ainsi on peut créer des classe de multicast en reception et emission qui seront instanciée par un programme "Client"

----------

mis à part la prise en main difficile du tp de part les nombreuses lectures de  documentation , la partie qui m'a semblé la plus difficile a été de trouver comment lire le entrées de message pour le Client d'envoie. 

En effet nous avions vu le scanner pour lir les input console cependant ici ce n'était pas du tout adapté. 

Après quelques recherche j'ai fini par opter pour des Reader
notemment BufferedReaded et InputStreamReader. Après quelques echecs j'ai réussi à le mettre en place.