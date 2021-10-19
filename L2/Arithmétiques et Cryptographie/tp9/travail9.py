#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1: DOUCHET Benjamin
:auteur 2:
:groupe: SESI 12
:date: vendredi 27 mars 2020
:objet: Travail numéro 9 (Nombres premiers et témoins de Fermat)
"""

from matplotlib import pyplot as plt
from math import log
from random import randrange
from tp6_arithmetique import *
from tp1 import *


def expo_mod_rapide(a, b, n):
    """
    :param int a:
    :param int b: exposant
    :param int n: modulus
    :return: r dans {0, 1, ..., n-1} tel que a^b = r (mod n)
             calcul effectué par l'exponentiation rapide.
    :rtype: int
    :CU: b >= 0, n > 0
    :Exemples:

    >>> expo_mod_rapide(2, 10, 100)
    24
    >>> expo_mod_rapide(14, 3141, 17)
    12
    """
    return pow(a, b, n)


def est_temoin_non_primalite(a, n):
    '''
    :param int a, n:
    :return:
        - True si a est un témoin de non primalité de n
        - False sinon
    :rtype: bool
    :CU: n > 1

    Attention, bizarrement cette procédure ne considère comme témoin de non
    primalité que les "a<n" avec pgcd(a, n) == 1 (et la condition supplémentaire
    du texte).

    Pourtant si pgcd(a, n) > 1 avec a < n alors certainement on a prouvé que n
    n'était pas premier (on a trouvé un diviseur propre !). Néanmoins il faut
    renvoyer False dans ce cas. Il aurait mieux valu que la procédure
    s'appelât est_temoin_de_Fermat(a, n).

    Personnellement je préférerais une procédure qui ne calculerait pas
    pgcd(a, n) mais qui aurait comme *Condition d'Utilisation* que pgcd(a,n)==1.
    Cela la rendrait plus utile comme sous-routine générale.

    :Exemples:
    
    >>> n = 2**32 + 1
    >>> est_temoin_non_primalite(2, n)
    False
    >>> est_temoin_non_primalite(3, n)
    True

    '''
    res = False
    if pgcd(a,n) == 1 and not( expo_mod_rapide(a, n-1, n) == 1 ) :
        res = True
    return res 


# Exercice

# Trouvez l'entier inférieur à 10000 dont le nombre de témoins de non
# primalité est relativement le plus grand, i.e. telle que la fréquence de ce
# nombre de témoins nbre temoins/(n−2) est la plus grande. Même question avec
# la fréquence la plus petite mais non nulle.


def est_carmichael(n):
    '''Détermine si n est un nombre de Carmichael par le critère de Korselt

    On utilisera la procédure factorise() du module tp6_arithmetique et on
    lira attentivement l'énoncé du théorème de Korselt.

    :param int n:
    :return:
       - True si n est un nombre de Carmichael
       - False sinon
    :rtype: bool
    :CU: n > 0
    
    :Exemples:
    
    >>> any(est_carmichael(k) for k in range(1, 561))
    False
    >>> est_carmichael(561)
    True

    '''
    
    if est_premier2(n) or n==1 :
        return False
    facteurs = factorise(n)
  
    for i in range(len(facteurs)):
        if n%(facteurs[i][0]**2)==0 :
            return False 
    cond=[]        
    for i in range(len(facteurs)):
        cond.append((n-1)%(facteurs[i][0]-1)==0)
    return all(cond)







def est_carmichael_sans_korselt(n):
    '''
    Détermine si n est un nombre de Carmichael

    La méthode consistera à parcourir les a de 2 à n-1 (on s'occupera
    donc directement de n égal à 1, 2, 3 ou 4),
    à calculer pgcd(a, n) et pour ceux pour lequel ce pgcd vaut 1
    à évaluer a**(n-1) modulo n (bien sûr par exponentiation modulaire rapide)
    et à regarder si c'est 1 dans tous les cas ; si oui, et si n n'est pas premier,
    c'est-à-dire si au moins un "a" a été trouvé avec pgcd(a, n) > 1
    (le premier a est le plus petit diviseur de n, en fait), alors 
    n est un nombre de Carmichael.

    La méthode est donc naïve et lente, ne la testez pas avec des
    entiers trop grands.

    Réfléchir aussi à gagner un facteur 2 d'efficacité. Il faut réfléchir
    au cas de a==n-1 et s'il est important de le tester. (Optionnel).

    :param int n:
    :return:
       - True si n est un nombre de Carmichael
       - False sinon
    :rtype: bool
    :CU: n > 0
    
    :Exemples:
    
    >>> est_carmichael_sans_korselt(561)
    True
    >>> any(est_carmichael_sans_korselt(k) for k in range(1, 561))
    False
    '''
    
    if est_premier2(n) or n==1 :
        return False
    
    for i in range(1,n) :
        if est_temoin_non_primalite(i, n)==True and pgcd(i,n)==1 :
            return False
    return True

# Exercice :
#
# La décomposition en facteurs premiers des nombres de Carmichael comprend au
# moins trois facteurs premiers. Trouvez tous les nombres de Carmichael
# produits de trois nombres premiers inférieurs à 1000. Combien y en a-t-il ?
#


def est_compose(n, nbre_essais=20):
    '''
    :param int n:
    ;param int nbre_essais: nbre maximal de tentatives de trouver
                            un témoin de non primalité
    :return:
       - True si un témoin de non primalité a été trouvé
       - False sinon
    :rtype: bool
    :CU: n > 2

    '''
    res = False
    for i in range(nbre_essais):
        if est_temoin_non_primalite(randint(2,n-1),n) :
            res = True
    return res



# Exercice: Existe-t-il un nombre de Fermat Fn, avec 8≤n≤14 qui soit premier ?

# Exercice : Utilisez le prédicat est_compose pour trouver un nombre
# (probablement) premier ayant 30 chiffres.


if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
