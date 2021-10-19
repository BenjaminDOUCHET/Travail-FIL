#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1: Benjamin DOUCHET
:auteur 2:
:groupe: SESI 12 
:date: lundi 6 avril 2020 
:objet: Travail numéro 11 (RSA et exponentiation rapide)
"""

from tp1 import *
from tp6_arithmetique import *


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
    # je vous propose une amélioration de l'algorithme de l'énoncé
    # l'idée c'est  de travailler en puissance de 2 donc en binaire
    # j'ai fais un peu de recherche , ça a l'air de fonctionner
    # donc j'utilise les opérateurs bitwises 
    
    res= 1
    while b>0:
        if b&1>0: #ici
            res = (res*a)%n
        b >>= 1 # et ici
        a = (a*a)%n    
    return res


def cle_privee(p,q,e):
    """
    :param p: (int) un nombre premier 
    :param q: (int) un nombre premier
    :param e: (int) un nombre premier avec phi(pq)
    :return: (int) l'inverse de e modulo phi(n)
    :CU: est_premier(p) and est_premier(q) and p != q and pgcd(e, (p-1)*(q-1)) == 1

    >>> cle_privee(13, 17, 5)
    77
    >>> cle_privee(31927417, 93836983, 77)
    894900834954101
    """
    n = p*q
    phi = (p-1)*(q-1)
    res = inverse_modulaire(e, phi)
    return res




def chiffrement_rsa(m,pub):
    """
    :param m: (int) le message à chiffrer.
    :param pub: (tuple) format (modulus , exposant) la clé publique.
    :return: (int) le message chiffré

    >>> chiffrement_rsa(10, (527, 7))
    175
    >>> chiffrement_rsa(10, (221, 5))
    108
    >>> chiffrement_rsa(10, (221, 77))
    147
    >>> chiffrement_rsa(10, (2995972486262911, 77))
    2569036101741044
    """
    assert m<= pub[0]-1 and m>= 0 , " message incorrect"
    return expo_mod_rapide(m, pub[1], pub[0])

def déchiffre_rsa( c , kpriv , kpub) :
    """
    :param c: (int) caractère à déchiffrer
    :param kpriv: (int) la clé privée
    :param kpub: (tuple) format (modulus , exposant) la clé publique.
    :return : (int) le numero déchiffré
>>> déchiffre_rsa( 175 , 343 , (527,7))
10
    """
    assert c<= kpub[0]-1 and c>= 0 , " message incorrect"
    return expo_mod_rapide(c, kpriv , kpub[0])
    
    
    
    

from sympy import ntheory
from random import randrange
from math import log

    
def genere_cles_RSA(t) :
    """
    : param t: (int) la taille en bit voulue de la clé
    :retrun : (tuple) les données pub / priv de la clé
    """
    
    # on trouve un nombre premier de la bonne taille 
    tsur2 = t // 2
    p = 2 * randrange(2**(tsur2 - 2), 2**(tsur2 - 1)) + 1
    while not(ntheory.primetest.isprime):
        p += 2
    
    #on en trouve un second différent 
    tsur2 = t // 2
    q = 2 * randrange(2**(tsur2 - 2), 2**(tsur2 - 1)) + 1
    while not(ntheory.primetest.isprime) or p == q:
        q += 2
    
    
    n = p * q
    phi = (p-1)*(q-1)
    
    #on cherche e
    e=2
    while pgcd(phi , e) != 1 :
        e+=1
    
    d = inverse_modulaire(e, phi)
    
    return (n,e,d,p,q)
  

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
