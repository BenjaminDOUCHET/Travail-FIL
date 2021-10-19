#!/usr/bin/python3
# -*- coding: utf-8 -*-

"""
Raymond Calbuth (98765432)
"""

from arithmetique import pgcd, inverse_mod
from alphabet import ALPHABETS, Alphabet


##########################################
#  DIVERS
##########################################

def decoupage_digrammes(s):
    """
    Renvoie la liste de digrammes de `s`.
    Si `s` contient un nombre impairs de caractères, le dernier élément
    de la liste renvoyée est constitué du dernier caractère de `s` suivi
    du premier.

    :param s: (str) chaîne à découper
    :return: (list) liste de digrammes
    :CU: aucune
    :exemples:

    >>> decoupage_digrammes('abba')
    ['ab', 'ba']
    >>> decoupage_digrammes('bac')
    ['ba', 'cb']
    """
    n = len(s)
    if n % 2 != 0:
        s = s + s[0]
    return list(s[k:k+2] for k in range(0, n, 2))
    
def determinant(cle):
    """
    Renvoie le déterminant de la clé `cle`.
    :param cle: (tuple) une clé
    :return: (int) le déterminant de `cle`
    :CU: `cle` est un tuple de 4 entiers.
    :exemple:

    >>> determinant((0, 1, 3, 2))
    -3
    """
    a, b, c, d = cle
    return a*d - b*c
    
def occurrences_digrammes(texte):
    """
    Renvoie un dictionnaire dont les clés sont les différents digrammes
    de `texte` et les valeurs associées sont les occurrences de ces
    digrammes dans `texte`.

    :param texte: (str)
    :return: (dict) nbre d'occurrences des digrammes de texte 
    :CU: aucune
    :exemple:

    >>> occurrences_digrammes('tata yoyo') == {'ta':2, ' y':1, 'oy':1, 'ot':1}
    True
    """
    occ = dict()
    for digram in decoupage_digrammes(texte):
        if digram in occ:
            occ[digram] += 1
        else:
            occ[digram] = 1
    return occ

##########################################
#  Chiffrement/déchiffrement de Hill
##########################################

def hill_chiffre_digramme(digram, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Renvoie le chiffré par Hill du digramme `digram` par la clé `cle`.

    :param digram: (str) digramme à chiffrer
    :param cle: (tuble) clé de chiffrement
    :return: (str) digramme chiffré
    :CU: `digram` est de taille 2, ses caractères sont dans `alphabet`
         `cle` est un tuple de 4 entiers
    :exemples:

    >>> hill_chiffre_digramme('AB', (0,1,3,2))
    'BC'
    >>> hill_chiffre_digramme('AN', (0,1,3,2))
    'NA'
    """
    n = len(alphabet)
    x, y = tuple(alphabet.index(car) for car in digram)
    a, b, c, d = cle
    return alphabet[(a*x + b*y) % n] + alphabet[(c*x + d*y) % n]

def hill_chiffre_message(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Renvoie le chiffré du message `msg` par la clé `cle`.

    :param msg: (str) message à chiffrer
    :return: (str) message chiffré
    :CU: les caractères de `msg` sont dans `ALPHABET`
         `cle` est un tuple de 4 entiers
    :exemples:

    >>> hill_chiffre_message('ABCDE', (0,1,3,2))
    'BCDMAM'
    """
    return ''.join(hill_chiffre_digramme(digram, cle, alphabet)
                   for digram in decoupage_digrammes(msg))

def hill_cle_valide(cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    :param cle: (tuple) clé de chiffrement
    :return: (bool)
      - True si cle est une clé valide pour l'alphabet 
      - False sinon
    :CU: `cle` est un tuple de 4 entiers

    :exemples:

    >>> hill_cle_valide((0, 1, 3, 2))
    True
    >>> hill_cle_valide((0,1,3,2), alphabet=ALPHABETS['CAPITAL_LATIN_SPACE'])
    False
    """
    return pgcd(determinant(cle), len(alphabet)) == 1

def hill_cle_inverse(cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Renvoie l'inverse de la clé `cle` pour un alphabet de cardinal
   `TAILLE_ALPHABET`

    :param cle: (tuple) clé de chiffrement
    :return: (tuple) clé inverse
    :CU: `cle` est un tuple de 4 entiers, la clé est valide et n > 0

    :exemples:

    >>> hill_cle_inverse((0,1,3,2))
    (8, 9, 1, 0)
    """
    n = len(alphabet)
    k = inverse_mod(determinant(cle), n)
    a, b, c, d = cle
    return (k*d %n, -k*b % n, -k*c % n, k*a % n)

def hill_dechiffre_message(chiffre, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Renvoie le déchiffré du message `chiffre` par la clé `cle`.

    :param chiffre: (str) message à déchiffrer
    :param cle: (tuple) clé utilisée lors du chiffrement
    :return: (str) message déchiffré
    :CU: les caractères de `chiffre` sont dans `alphabet`
         `chiffre` a un nombre de caractères pair
         `cle` est un tuple de 4 entiers
         `cle` est valide
    :exemples:

    >>> hill_dechiffre_message('BCDMAM', (0,1,3,2))
    'ABCDEA'
    """
    return hill_chiffre_message(chiffre, hill_cle_inverse(cle, alphabet), alphabet)

##########################################
#  Cryptanalyse
##########################################

def hill_cle_supposee(clairs, chiffres, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Renvoie la clé (a,b,c,d) telle que le chiffrement des deux
    digrammes de `clairs` avec cette clé donne les deux
    digrammes de `chiffres`.
    
    :param clairs: (tuple) couple de digrammes
    :param chiffres: (tuple) couple de digrammes
    :return: (tuple) clé utilisée pour chiffrer `clairs` en `chiffres`
    :exemples:

    >>> hill_cle_supposee(('AB', 'BC'), ('BC', 'CH'))
    (0, 1, 3, 2)
    """
    n = len(alphabet)
    x1, y1, x2, y2 = tuple(alphabet.index(car) for digram in clairs for car in digram)
    x1p, y1p, x2p, y2p = tuple(alphabet.index(car) for digram in chiffres for car in digram)
    k = inverse_mod(determinant((x1, x2, y1, y2)), n)
    return (k*(x1p*y2 - x2p*y1) %n,
            k*(x2p*x1 - x1p*x2) %n,
            k*(y1p*y2 - y2p*y1) %n,
            k*(y2p*x1 - y1p*x2) %n)
    
if __name__ == '__main__':
    import doctest
    doctest.testmod()

    ###########
    # Énigme 1
    ###########
    # Pour cette énigme l'alphabet est
    alphabet1 = Alphabet('\t\n' + str(ALPHABETS['PRINTABLE_ASCII']))
    
    with open('texte.txt', 'r') as srcfile:
        TEXTE = srcfile.read()

    with open('enigme1.txt', 'r') as srcfile:
        ENIGME1 = srcfile.read()

    # Répondez ici à l'énigme 1
    # Calcul des occurrences de digrammes dans le texte non chiffré
    occ_digr = occurrences_digrammes(TEXTE)
    # Transformation en liste de couples (digr, occ)
    liste_occ = [(digr, occ_digr[digr]) for digr in occ_digr]
    # Tri de la liste par ordre décroissant du nbre d'occ
    liste_occ.sort(key=lambda x: x[1], reverse=True)
    digrammes_clairs_frequents = tuple(liste_occ[i][0] for i in range(2))
    print('Digrammes les plus fréquents dans le texte clair : {} '.format(digrammes_clairs_frequents))

    # Calcul des occurrences de digrammes dans l'ENIGME1
    occ_digr = occurrences_digrammes(ENIGME1)
    # Transformation en liste de couples (digr, occ)
    liste_occ = [(digr, occ_digr[digr]) for digr in occ_digr]
    # Tri de la liste par ordre décroissant du nbre d'occ
    liste_occ.sort(key=lambda x: x[1], reverse=True)
    digrammes_chiffres_frequents = tuple(liste_occ[i][0] for i in range(2))
    print('Digrammes les plus fréquents dans ENIGME1 : {} '.format(digrammes_chiffres_frequents))
    cle1 = hill_cle_supposee(digrammes_clairs_frequents, digrammes_chiffres_frequents, alphabet1)
    print('Clé probable pour l\'ENIGME1 : {}'.format(cle1))
    clair1 = hill_dechiffre_message(ENIGME1, cle1, alphabet1)
    print('Début de l\'ENIGME1 déchiffrée :\n{}'.format(clair1[:200]))

    ###########
    # Énigme 2
    ###########

    # Pour cette énigme l'alphabet est
    alphabet2 = ALPHABETS['PRINTABLE_ASCII']

    ENIGME2 = '''0v_h=8Caf0S:%J"pn4u;D!BSy&L||Dj28cd#?LyJFTx<'''
    print('Début supposé du clair correspondant à ENIGME2 : http')
    cle2 = hill_cle_supposee(('ht', 'tp'), (ENIGME2[0:2], ENIGME2[2:4]), alphabet2)
    print('Clé probable pour l\'ENIGME2 : {}'.format(cle2))
    clair2 = hill_dechiffre_message(ENIGME2, cle2, alphabet2)
    print('URL trouvée : {}'.format(clair2))

