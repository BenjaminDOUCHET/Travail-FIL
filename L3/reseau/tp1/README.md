TP1 COLLE - DOUCHET 

--Question 6

pour pouvoir envoyer un message à notre voisin manuellement nous avons besoin de :
- son id de socket
- son adresse Ip
- son port 

--Question 8 

de notre point de vue il semble préférbable d'un point de vue de la sécurité de laisser le système choisir les ports d'envoie mais de contraindre les ports de reception afin de gérer quel application à le droit de rentrer de quel façon sur notre système.

--Question 15

on peut observer le texte en brut dans le "pré décodage" de l'encart du bas. dans la partie décodée on peut voir que pour un envoi de 17 octet il y a 59 octects de transmis 
On retrouve aussi dans la lecture de ces octets toutes les informations transmises dans la trame (adrese Ip port etc.)

on observe aussi qu'il selectionne le chemin "le plus court" dans le sens où il vas envoyer depuis le port de reception.

- c)

comme nos données sont assez petites elles tiennent dans un trame à chaque envois donc pour cet exemple on  2 segments udp de transmis.

 - d )  on a 19octect de messag pour 61octets de        transmission 
        on a 17 octets de message pour 59 octets de transmission

        pour une trame on a donc 42 octets qui contiennent les informations des differents couches.

        ainsi pour un "paquet" udp le efficacité = taille message / taille message + 42

        donc ici : 19/61


TCP

--Q4 

on constate qu'on se fait refouler par le socket de destination ce qui est logique car il ne nous attends pas donc il nous rejette pour se protéger.

--Q5
ici nous avons pris S1 le client ( car il demande la connexion) et S2 le serveur( celui qui autorise l'accès a son reseau)

--Q6 on constate sur wireshark que la seconde demande de connexion n'apparait pas encore come si elle était "en attente" 

-- Q9 
on constate qu'il a créé un socket de meme port que le socket de destination .

-- Q11

on observe que contraiment à UDP ,  on a deux "segments" d'envoyés le premier avec le message et le second qui corresponds surement à l'acquittement  du message qui est ue trame vide. 

le push évite de placer le message dans le buffer et de forcer l'envoie .

le Seq correspond au nombre d'octet du corps de message

le ACK indique le nombre d'octet reçu que + l'incrémentation de sécurité.

-- Q12 
le champ RecQ est set à la valeur de 30

-- Q14 après avoir lu les messages en attente ,, le RecQ est passé à 0 

--Q15 on vois le flag [FIN , ACQ] on peut en deduire qu'il clot la liaison établi précdemment.

on a visé juste , qi on tente d'envoyer un autre message on recois un ecxeption "broken pipe"

--Q17 

il semble que la commande shutdown envoie premier message de fermeture+ ack , on lui renvoie en retour un ack pour acquitter la fermeture de reseau.

-- Q18
pour la totalité de la transmission et fermeture de lisaison on a 2 * 17 segments 

on vois par exemple que pour un message de 18 octet le message total est de 79 octets ce qui le rends moins "éfficace" que udp sur ce point de vue.


--- nous n'avons pas reussi à acceder à du materiel permettant de traiter la suite des questions.

