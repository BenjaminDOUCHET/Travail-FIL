 #!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1: Benjamin DOUCHET
:auteur 2:
:groupe: SESI 12 
:date: vendredi 10 avril 2020 
:objet: Travail numéro 12 (Test de primalité de Miller-Rabin )
"""

def EstTemoinDeMiller(x, n) :
    """
    :param x : (int) le nombre à évaluer
    :param n : (int) nombre non premier tq  0 < x < n
    :return : (bool) True si x est probablement premier ,  False Sinon
    """
    
    assert 0 < x and x < n
    
   
    if x%2 == 0:
        return False

    #toujours dans l'dée qu'on travaille en puissance de deux jevais jouer sur les bits
    k = 1
    m = (n - 1) >> 1
    while not m & 1:
        # tant que m est pair je divise par deux et j'incrémente k
        k += 1
        m >>= 1
        
        
    # ensuite je  calcule y 
    y = pow(x, m, n)
    
    
    
    if y == 1 or y == n - 1:
        return False
    
    
    for j in range(k - 1):
        y = (y * y) % n
        
        if y == 1:
            return True
        
        if y == n - 1:
            return False
    
    return True
 
 
from random import randint

def EstPremierProbable(n) :
    """
    """
    compt = 0
    capt = False 
        
    
    
    while compt<100 and  capt==False :
        x = randint(2 , n-2)
        capt = EstTemoinDeMiller(x, n)
    
    return capt
        
 
 
#incomplet pour le moment 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    
if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)