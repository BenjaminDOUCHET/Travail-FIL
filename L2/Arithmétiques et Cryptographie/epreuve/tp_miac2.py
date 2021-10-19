#Douchet Benjamin
#41901020
#SESI 12
#reception du sujet à 14h07



from materiel_41901020 import *


## Preliminaires ##

# question 1

#soit la clé (n,e) la clé publique et d la clé privée.
#on a d inverse modulaire de e modulo n
#
#donc la suite de relation suivantes :
#    1 soit p et q deux nombres premiers distincs
#    2 n = p * q
#    3 phi(n) = (p-1)*(q-1)
#    4 on determine e  tq : pgcd(phi(n),e) = 1
#    5 on trouve d tq : d congru e**-1 (modulo phi(n))


# question 2

#soit m le message , m est une suite de nombres apparatenant à Z/nZ  (Z les entiers relatifs)
#
#c = E(m) = m**e (mod n)
#
#m = D(c) = c**d (mod n)
#

#question 3
#
#on sait que pgcd(pgi(n),e)=1
#
#cela implique : phi(n)*x+e*y=1
#
#or phi(n) est le produit de deux nombre pairs donc phi(n) est pair
#
#de plus on a la relation : e*y congrue à 1(mod phi(n))
#
#donc e est impair.

# question 4

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
    return pow(m, pub[1], pub[0])


#>>> chiffrement_rsa(2,CLE_PUBLIQUE1)
#96801754469998947709115270520

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
    return pow(c, kpriv , kpub[0])

#>>> déchiffre_rsa( CHIFFRE1 , CLE_PRIVEE1 , CLE_PUBLIQUE1)
#4190102041901020 (soit 2 fois mon NIP)


### Profiter de la non inversibilité ###

# question 5

from tp1 import *
#
#>>> pgcd(CHIFFRE2,CLE_PUBLIQUE2[0])
#785615743081943

# donc c2 n'est pas inversible modulo n2

# question 6

# on reprends la formule : c2 = m2**e2 (mod n2)
#



# Question 7




### Multiplicativité du chiffrement ###


# question 8
from random import randint

def test_multi(cle) :
    """
    predicat verifiant 100 fois si E(m)*E(m') = E(m*m')
    avec m et m' entiers relatifs pris au hasard
    :param cle (tuple): un tuple de cle RSA Valide format (n,e)
    :C.U: None

    """
    # on recceuil les résulstats
    res = list() 
    for i in range(100) :
        m = randint(0 , cle[0]-1)
        m2 = randint(0 , cle[0]-1)
        res.append(chiffrement_rsa(m,cle) == (chiffrement_rsa(m,cle)*chiffrement_rsa(m2,cle))%cle[1])
        
    return all(res)
        

# question 9
#si E(m*m') congrue à E(m)*E(m') mod n
#
#et si m inversible mod n
#
#alors il existe m' tq m*m' = 1 mod n
#donc E(m*m') = E(1) mod n
#ainsi E(m)*E(m') = 1 mod n 
#
#alors on a E(m) inversible mod n et E(m)-1 = E(m') avec m' inverce modulaire de m



# Question 10

# si n-1 = -1 mod n
# alors E(-1) = (n-1)**e mod n =  n-1



# Question 11

on a vu en Question 10 que E(n-1) = n-1

par extension pour tout entier m on a n-m = -m (modn) dans Z/nZ



### danger de la multiplicativité ###

# Question 12

#on a c' = E(r) * c mod n
#or  on peut aussi l'écrire comme suit :
#    -> comme D(c') = m' et E(m') = c' 
#    
#    -> c' = E(D(c'))
#    
#    -> c = E(m)
#on obitent la relation suivante :
#    
#    E( D(c')) = E(r)*E(m) mod n
#    
#or par l'ex 4 on sait que dans ce cas on a l'égalité suivante :
#    D(c') = r * m

# question 13

# on peut réussir à calculer m en fonction de r et de D(c') ssi r et m verifient m*r = 1 mod(n)
# autrement dis si r est inverse modulaire de m

# question 14

# CLE_PUBLIQUE3

#>>> inverse_modulaire(41901020, CLE_PUBLIQUE3[0])
#380108693839919793860926298670
#
#donc mon nip est inversible 

#>>> (chiffrement_rsa(41901020,CLE_PUBLIQUE3)*CHIFFRE3)%CLE_PUBLIQUE3[0] == CLAIR_CHIFFRE3[1]
#True

#question 15

#donc d'après la relation trouvée en Q 13 on a m3 = m3'/Nip
#
#>>> CLAIR_CHIFFRE3[0]//41901020
#1020


if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)