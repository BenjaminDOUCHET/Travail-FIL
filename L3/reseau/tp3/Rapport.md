# TP3 Colle Maxime | Benjamin Douchet

# TCP et Serveur Chat



## Exercice 1

#### Q1
le traitement dd'une requete passe par les étrapes suivantes :

1- on met le seveur en ecoute 
2- on accepte l'arrivée d'un connexion 
2bis - on créer donc le socket temporaire pour la liaison avec le client
3- on prépare un flux de sortie vers le client
4- on envoie le message d'acceuil/aurevoir 
5- on ferme le socket temporaire 