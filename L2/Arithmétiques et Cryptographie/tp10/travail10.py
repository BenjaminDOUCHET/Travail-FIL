#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1:
:auteur 2:
:groupe: SESI 12 
:date: 3 avril 2020
:objet: Travail numéro 10 (cryptanalyse de Vigenère par Babbage-Kasiski)
"""

from collections import defaultdict

from alphabet import Alphabet, ALPHABETS

from tp4 import dechiffre_message_vigenere

from tp10_cryptogrammes import CRYPTOGRAMMES, ALPHABET1, ALPHABET2


def les_deux_cars_les_plus_frequents(
        msg,
        alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Renvoie les deux caractères de alphabet les plus fréquents dans msg,
    sous la forme d'un chaîne de caractères.

    On fait l'hypothèse a priori que ce n'est pas ambigu. Et msg peut contenir
    des caractères non présents dans alphabet, on les ignore.

    :param str msg: une chaîne de caractères
    :param Alphabet alphabet: un alphabet
    :return: une chaîne de deux caractères
    :rtype: str

    >>> set(les_deux_cars_les_plus_frequents('VENI VIDI VICI')) == {'V', 'I'}
    True

    """
    seek = 0
    maxi1 = [0 , '']
    maxi2 = [0 , '']
    ref = str(alphabet)
    
    for i in range(len(ref)) :
        seek = msg.count(ref[i])
        if seek > maxi1[0] :
            maxi2[0] = maxi1[0]
            maxi2[1] = maxi1[1]
            maxi1[0] = seek
            maxi1[1] =ref[i]
            
        elif seek > maxi2[0] :
            maxi2[0] = seek
            maxi2[1] = ref[i]
    return maxi1[1]+maxi2[1] 


def decrypte_vigenere_taille_connue(
        msg_chiffre,
        taille_bloc,
        lettres_max,
        alphabet=ALPHABETS['CAPITAL_LATIN_SPACE']):
    """Décrypte un message chiffré par la méthode de Vigenère, par analyse de
    fréquences, la longueur des blocs étant connue. Les deux caractères a
    priori les plus fréquents dans le clair sont un paramètre obligatoire,
    sous forme de lettres_max mais on ne fait pas d'hypothèse sur
    lequel des deux est le plus fréquent.

    La procédure utilisera chiffres_max = les_deux_cars_les_plus_frequents()
    sur des extraits de msg_chiffre et en déduira la clé de Vigenère. On ne
    fait pas d'hypothèse a priori si chiffres_max[0] correspond à
    lettres_max[0] ou lettres_max[1], on le détermine par la différence des
    indices (on supposera que cette différence d'indice n'est jamais la moitié
    de la longueur de l'alphabet). Attention de travailler modulo la longueur
    de l'alphabet pour cette comparaison de différences d'indices !

    :param str msg_chiffre: une chaîne de caractères
    :param int taille_bloc: un entier positif, longueur des blocs de Vigenère
    :param str lettres_max: les deux caractères les plus fréquents du clair
    :param Alphabet alphabet: un alphabet (paramètre optionnel)
    :return: le tuple constitué de la clé de Vigenère et du message déchiffré
    :rtype: tuple
    :CU: msg_chiffre est constitué de caractères de l'alphabet,
         et ce dernier contient les caractères de lettres_max.

    >>> decrypte_vigenere_taille_connue(CRYPTOGRAMMES[1], 2, 'e ', ALPHABET1)
    ((17, 37), "Albert Einstein ... l'énergie d'un système.")

    """
    ref=str(alphabet)
    chiffre_max=les_deux_cars_les_plus_frequents(msg_chiffre,alphabet=ALPHABETS['CAPITAL_LATIN'])
    print(chiffre_max)
    cle =[(ref.index(chiffre_max[0])-ref.index(lettres_max[1]))%len(alphabet) , (ref.index(chiffre_max[1])-ref.index(lettres_max[0]))%len(alphabet)]
    dechiffre = dechiffre_message_vigenere(msg_chiffre, tuple(cle), alphabet)
    return (tuple(cle),dechiffre)
    
    
    
    
    
    
    

def trigrammes_et_positions(msg):
    """Renvoie un dictionnaire donnant les trigrammes dans msg et
    leurs positions

    :param str msg: une chaîne de caractères
    :return: un dictionnaire, avec pour clés les trigrammes et pour valeurs
             les listes des positions du trigramme dans msg
    :rtype: defaultdict

    Si le message a moins de trois caractères le dict renvoyé sera vide.

    Méthode: on initialise un dictionnaire vide par D = defaultdict(list).
    Cette classe permet de manipuler sans précaution des clés dont on ne sait
    pas si elles existent encore dans le dictionnaire. Ici leurs valeurs par
    défaut sera la liste vide. Ainsi par exemple D['ABC'].append(7) ne lève
    pas une exception même si la clé 'ABC' n'existe pas encore dans le
    dictionnaire D: dans ce cas 'ABC' est ajouté comme clé au dictionnaire
    avec valeur la liste [7].

    >>> trigrammes_et_positions('AA')
    defaultdict(<class 'list'>, {})
    >>> {'AAB': [0]} == trigrammes_et_positions('AAB')
    True
    >>> {'AAA': [0, 1]} == trigrammes_et_positions('AAAA')
    True
    >>> test = {'OLE': [0, 3, 6, 9], 'LEO': [1, 4, 7, 10], 'EOL': [2, 5, 8]}
    >>> test == trigrammes_et_positions('OLEOLEOLEOLEO')
    True

    """
    pass


def distances_entre_trigrammes(msg):
    """Renvoie la liste ordonnée des distances entre les trigrammes de msg

    :param str msg: une chaîne de caractères
    :return: la liste ordonnée des écarts entre répétitions du même trigramme
    :rtype: list(int)

    Méthode: on initialise un set E vide (E = set()); puis on utilise le
    dictionnaire D renvoyé par trigrammes_et_positions(msg): on parcourt
    les clés key de D et on ajoute à E tous les écarts (positifs, nuls, ou
    négatifs) entre les entiers stockés dans D[key]. Finalement on renvoie la
    liste ordonnée des éléments du set E, élaguée des éléments négatifs ou nuls.

    >>> distances_entre_trigrammes('ABRACADABRA')
    [7]
    >>> distances_entre_trigrammes('OLEOLEOLEOLEO')
    [3, 6, 9]
    >>> distances_entre_trigrammes(CRYPTOGRAMMES[0])
    [6, 9, 12, 18, 21, ..., 696, 708, 738]

    """
    pass


if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
