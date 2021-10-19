#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1: ZINE NADA
:auteur 2: DOUCHET BENJAMIN
:groupe: SESI 12
:date: vendredi 7 février 2020
:objet: Travail numéro 4 (chiffrement affine, chiffrement de Vigenère)
"""


from tp1 import pgcd, inverse_modulaire , pgcd_étendu
from tp2 import chiffre_lettre as chiffre_lettre_cesar
from alphabet import Alphabet, ALPHABETS


CRYPTOGRAMME1 = ("R6s'ç/Qpz8,/v3ëkù s6z'Q*rk;229ç3vku'Q6rkç'è:;3.3;GQ^v*"
                 ";^v3ë/vkv8Q7z6è'Q8v wkt'ë/Q!z8ûkv/Q*rk;229ç3vku'Q6rkx^"
                 "rAz/r/z9ëku3;'Q^v6r/zAz/2kxGëGç:è'Q'ëkê3è6vkë':0Q!v8;k"
                 ",'zEvRQtèkt9ë/ç3s vkè:ç1v7v8;kr Q?2Av6î+ù'ê'ë/Q?vkè:Q7"
                 "2!r8z-:'Q-::ë/z-:'Q';ku'Q6rkt9,7î6î1z'+kv/Q^vNî3;kè'Q+"
                 "ç3?ke9s'èku'Q+yD,3û vku'Q7z6è'Q8v wkt'ë/QAz8x/M';g:8Q+"
                 "î çk,9ëkvCù6z!r/z9ëku'Q6A'w0v/Q+y9;926v!;^z-:'*kj9ëk;^"
                 "rAr3èkv*;kë9;:ê7v8;kt9ë8:ku Q1ç:ë?Q+:.è3tkù9:^Q6AGû r/"
                 "z9ëkVk21r6vkêkw9z*Q!Q::kt:ç^2OQ-:3QG;:s6z/Q ë'QGû zAr6"
                 "v8t'Q'ë/ç'Q6rkê:;33^vkv/Q6AGë'ç1z'Q?A ëk,D,/37vR")

ALPHABET1 = Alphabet((" ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                      "abcdefghijklmnopqrstuvwxyz"
                      "àéèêëîùûç,;:.!?'0123456789+-^*/"))


def phi_euler(N):
    """Indicatrice d'Euler.

    Renvoie le nombre φ(N) de classes modulo N inversibles. En
    particulier, c'est 0 si N=0, 1 si N=1, et N-1 si N est un nombre premier
    (mais on n'utilisera pas cela).

    Pour ce calcul il s'agit de compter les entiers k qui sont premiers avec N
    (c'est-à-dire ayant un PGCD avec N égal à 1) et inférieurs strictement à
    N. On peut gagner un facteur 2 d'efficacité en remarquant que k est
    premier avec N si et seulement si N-k l'est, mais vous n'êtes pas obligé
    de tenir compte de cette remarque.

    :param int N: le modulo
    :return: φ(N), indicatrice d'Euler de N
    :rtype: int
    :CU: N est un entier positif ou nul

    >>> phi_euler(-3)
    Traceback (most recent call last):
    AssertionError: -3 doit être un entier positif !
    >>> phi_euler(4/2)
    Traceback (most recent call last):
    AssertionError: 2.0 doit être un entier positif !
    >>> [phi_euler(x) for x in range(11)]
    [0, 1, 1, 2, 2, 4, 2, 6, 4, 6, 4]
    >>> phi_euler(100)
    40
    >>> phi_euler(1000)
    400
    >>> phi_euler(1001)
    720
    """
    assert type(N) == int and N>= 0 , str(N)+ ' doit être un entier positif !'
    compt = 0
    
    for i in range(N) :
     if pgcd(i,N) == 1 :
         compt +=1
    return compt


def nb_de_cles_affines(alphabet):
    """Renvoie le nombre de clés affines pour un alphabet donné.

    :param Alphabet alphabet: un alphabet
    :return: le nombre de transformations inversibles :math:`x \\mapsto ax + b`
             modulo la longueur de l'alphabet
    :rtype: int

    >>> nb_de_cles_affines(ALPHABETS['CAPITAL_LATIN'])
    312
    >>> nb_de_cles_affines(ALPHABETS['DECIMAL_DIGITS'])
    40
    >>> monalphabet = Alphabet('MIAC2019TP4')  # caractères distincts !
    >>> nb_de_cles_affines(monalphabet)
    110
    """
    
    return phi_euler(len(alphabet))*len(alphabet)


    
def cle_affine_est_valide(cle, alphabet):
    """Prédicat disant si cle est valide comme clé affine pour alphabet.

    :param tuple cle: un couple (a, b)
    :param Alphabet alphabet: un alphabet
    :return: True si la clé est valide, False sinon
    :rtype: bool

    >>> cle_affine_est_valide((2, 7), ALPHABETS['CAPITAL_LATIN'])
    False
    >>> cle_affine_est_valide((13, 7), ALPHABETS['CAPITAL_LATIN'])
    False
    >>> cle_affine_est_valide((14, 7), ALPHABETS['CAPITAL_LATIN'])
    False
    >>> cle_affine_est_valide((15, 7), ALPHABETS['CAPITAL_LATIN'])
    True
    >>> cle_affine_est_valide((2, 7), ALPHABETS['DECIMAL_DIGITS'])
    False
    >>> cle_affine_est_valide((13, 7), ALPHABETS['DECIMAL_DIGITS'])
    True
    >>> cle_affine_est_valide((14, 7), ALPHABETS['DECIMAL_DIGITS'])
    False
    >>> cle_affine_est_valide((15, 7), ALPHABETS['DECIMAL_DIGITS'])
    False
    """
    
    return pgcd(cle[0] , len(alphabet)) == 1



def cle_affine_inverse(cle, alphabet):
    """Renvoie la clé affine inverse de la clé donnée, pour l'alphabet.

    :param tuple cle: un couple (a, b)
    :param Alphabet alphabet: un alphabet
    :return: le couple (A, B) tel que y=ax+b équivaut modulo N
             à x=Ay+B modulo N.

             A et B sont normalisés de sorte que 0<=A<N,
             0<=B<N, et N est le nombre de caractères de l'alphabet.
    :rtype: tuple
    :CU: cle doit être valide

    >>> cle_affine_inverse((28, 7), ALPHABETS['CAPITAL_LATIN'])
    Traceback (most recent call last):
    AssertionError: cle (28, 7) invalide ! (alphabet avec 26 caractères)
    >>> cle_affine_inverse((29, 7), ALPHABETS['CAPITAL_LATIN'])
    (9, 15)
    >>> cle_affine_inverse((2, 7), ALPHABETS['DECIMAL_DIGITS'])
    Traceback (most recent call last):
    AssertionError: cle (2, 7) invalide ! (alphabet avec 10 caractères)
    >>> cle_affine_inverse((103, 777), ALPHABETS['DECIMAL_DIGITS'])
    (7, 1)
    """
    D= pgcd(cle[0], len(alphabet))
    assert D == 1 , "cle "+ str(cle) +" invalide ! (alphabet avec "+ str(len(alphabet)) + " caractères)"
    
    u = inverse_modulaire(cle[0], len(alphabet))
    

    return ( u , u*-cle[1]%len(alphabet))


def chiffre_lettre_affine(lettre, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Fait le chiffrement affine de lettre par cle.

    :param str lettre: lettre à chiffrer
    :param tuple cle: clé de chiffrement, un couple (a, b)
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet.
              Valeur par défaut : alphabet des 26 lettres latines capitales.
    :return: lettre chiffrée par x -> ax + b modulo la longueur de alphabet
    :rtype: str
    :CU: lettre doit appartenir à alphabet et cle doit être valide

    >>> tuple(chiffre_lettre_affine(k, (11, 3)) for k in 'CESAR')
    ('Z', 'V', 'T', 'D', 'I')
    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> tuple(chiffre_lettre_affine(k, (17, 8), decimal) for k in '012')
    ('8', '5', '2')
    >>> tuple(chiffre_lettre_affine(k, (8, 8), decimal) for k in '012')
    Traceback (most recent call last):
    AssertionError: cle (8, 8) invalide ! (alphabet avec 10 caractères)
    >>> greek = ALPHABETS['LOWER_GREEK']
    >>> tuple(chiffre_lettre_affine(k, (11, 3), greek) for k in 'μιακ')
    ('ω', 'ρ', 'δ', 'γ')
    >>> tuple(chiffre_lettre_affine(k, (10, 3), greek) for k in 'μιακ')
    Traceback (most recent call last):
    AssertionError: cle (10, 3) invalide ! (alphabet avec 25 caractères)
    """
    D= pgcd(cle[0], len(alphabet))
    assert D == 1 , "cle "+ str(cle) +" invalide ! (alphabet avec "+ str(len(alphabet)) + " caractères)"
    
    rang = 0
    for i in range(len(alphabet)) :
        if lettre == alphabet[i] :
            rang = i
    return alphabet[(cle[0]*rang+cle[1])%len(alphabet)]




def chiffre_message_affine(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Fait le chiffrement affine de msg par cle.

    :param str msg: message à chiffrer
    :param tuple cle: clé de chiffrement (un couple)
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet
    :return: message chiffré
    :rtype: str
    :CU: les caractères de msg doivent appartenir à alphabet,
         la clé cle doit être valide.

    >>> chiffre_message_affine('CESAR', (11, 3))
    'ZVTDI'
    >>> chiffre_message_affine('CESAR', (12, 3))
    Traceback (most recent call last):
    AssertionError: cle (12, 3) invalide ! (alphabet avec 26 caractères)
    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> chiffre_message_affine('012', (17, 8), decimal)
    '852'
    >>> greek = ALPHABETS['LOWER_GREEK']
    >>> chiffre_message_affine('μιακ', (11, 3), greek)
    'ωρδγ'
    >>> chiffre_message_affine('μιακ', (10, 3), greek)
    Traceback (most recent call last):
    AssertionError: cle (10, 3) invalide ! (alphabet avec 25 caractères)
    """
    D= pgcd(cle[0], len(alphabet))
    assert D == 1 , "cle "+ str(cle) +" invalide ! (alphabet avec "+ str(len(alphabet)) + " caractères)"
    
    res=""
    for i in range(len(msg)):
        res+= chiffre_lettre_affine(msg[i], cle, alphabet)
        
    return res


def dechiffre_message_affine(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Fait le déchiffrement affine de msg sachant que cle
    est la clé de chiffrement.

    :param str msg: message à déchiffrer
    :param tuple cle: clé utilisée pour le chiffrement (un couple)
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet
    :return: message déchiffré
    :rtype: str
    :CU: les caractères de msg doivent appartenir à alphabet,
         la clé cle doit être valide.

    >>> dechiffre_message_affine('ZVTDI', (11, 3))
    'CESAR'
    >>> dechiffre_message_affine('ZVTDI', (12, 3))
    Traceback (most recent call last):
    AssertionError: cle (12, 3) invalide ! (alphabet avec 26 caractères)
    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> dechiffre_message_affine('852', (17, 8), decimal)
    '012'
    >>> greek = ALPHABETS['LOWER_GREEK']
    >>> dechiffre_message_affine('ωρδγ', (11, 3), greek)
    'μιακ'
    >>> dechiffre_message_affine('μιακ', (10, 3), greek)
    Traceback (most recent call last):
    AssertionError: cle (10, 3) invalide ! (alphabet avec 25 caractères)
    """
    D= pgcd(cle[0], len(alphabet))
    assert D == 1 , "cle "+ str(cle) +" invalide ! (alphabet avec "+ str(len(alphabet)) + " caractères)"
    res = ""
    rang = 0
    
    
    cle_=cle_affine_inverse(cle, alphabet)
    

   
    for i in range(len(msg)) :
        for k in range(len(alphabet)) :
            if msg[i] == alphabet[k] :
                rang = k
        res+= alphabet[(cle_[0]*rang+cle_[1])%len(alphabet)]
       
    return res


def chiffre_message_vigenere(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Chiffrement de Vigenère

    :param str msg: le message clair
    :param tuple cle: un tuple d'entiers
    :param Alphabet alphabet: un alphabet (paramètre optionnel)
    :return: le chiffré suivant la méthode de Vigenère
    :rtype: str
    :CU: le clair doit être composé de caractères de alphabet.

    >>> chiffre_message_vigenere('BRUTUS', (1, -2, 6))
    'CPAUSY'
    >>> chiffre_message_vigenere('Bonjour', (1, 2, 3), ALPHABETS['PRINTABLE_ASCII'])
    'Cqqkqxs'
    """
    compt = 0
    res =""
    
    for i in range(len(msg)):
        if compt == len(cle) :
            compt = 0
        res += chiffre_lettre_cesar(msg[i] , cle[compt] , alphabet)
        compt+=1
    return res


def dechiffre_message_vigenere(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Déchiffrement de Vigenère

    :param str msg: le message chiffré
    :param tuple cle: la clé de chiffrement
    :param Alphabet alphabet: un alphabet (paramètre optionnel)
    :return: le clair
    :rtype: str
    :CU: le chiffré doit être composé de caractères de alphabet

    >>> dechiffre_message_vigenere('CPAUSY', (1, -2, 6))
    'BRUTUS'
    >>> dechiffre_message_vigenere('Cqqkqxs', (1, 2, 3), ALPHABETS['PRINTABLE_ASCII'])
    'Bonjour'
    """
    compt = 0
    res =""
    
    for i in range(len(msg)):
        if compt == len(cle) :
            compt = 0
        res += chiffre_lettre_cesar(msg[i] , -cle[compt] , alphabet)
        compt+=1
    return res




def car_le_plus_frequent(msg, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Renvoie le caractère de alphabet le plus fréquemment rencontré dans msg

    Plus précisément, comme il peut y avoir plusieurs candidats avec le même
    nombre d'occurrences, on renvoie un tuple formé de ces candidats. L'ordre
    dans le tuple n'est pas imposé.

    La procédure n'exige pas que msg soit composé uniquement de caractères
    de alphabet. On compte uniquement les nombres d'occurrences des
    caractères provenant de alphabet.

    >>> car_le_plus_frequent('IMPERATOR IULIUS CAESAR DIVUS')
    ('I',)
    >>> mon_alphabet = ALPHABETS['PRINTABLE_ASCII']  # ne contient pas é !
    >>> out = car_le_plus_frequent('César a été assassiné au sénat en mars.', mon_alphabet)
    >>> type(out) == tuple
    True
    >>> sorted(out)
    [' ', 'a', 's']
    >>> sorted(car_le_plus_frequent('Julius a été assassiné aux ides de mars,'
    ...                             ' éééééé !.', ALPHABET1))
    [' ', 'é']
    """
    
    occurs = {}
    for lettre in msg :
        occurs[lettre] = msg.count(lettre)
    res = {lettre:occurrences for lettre, occurrences in occurs.items() if occurrences == max(occurs.values())}
    return tuple(res.keys())
                                
     
def decrypte_message_assez_long_avec_espaces(chiffre,taille_bloc,alphabet=ALPHABETS['CAPITAL_LATIN_SPACE']):
    """
    Décrypte un message chiffré par la méthode de Vigenère, l'alphabet
    utilisé contenant le caractère espace.

    La méthode consistera à extraire du chiffre autant de sous-chaînes que la
    taille des blocs, et à déterminer pour chacune quel est le caractère le
    plus fréquent, ce qui donnera la clé de César utilisée en supposant que le
    clair avait là le caractère espace.

    Il y a une difficulté technique si plusieurs caractères sont simultanément
    les plus fréquents dans l'une des sous-chaînes. On en utilisera alors un
    seul, le premier du tuple renvoyé par car_le_plus_frequent().

    Le doctest ci-dessous traitant ces cas est marqué « à ignorer », pour
    cette séance.

    :param str chiffre: une chaîne de caractères
    :param int taille_bloc: un entier positif, longueur des blocs de Vigenère
    :param Alphabet alphabet: un alphabet (paramètre optionnel)
    :return: un couple constitué de la clé et du message décrypté
    :rtype: list
    :CU: chiffre est constitué de caractères de l'alphabet,
         et ce dernier contient le caractère espace que l'on suppose
         être le plus fréquent dans les messages en clair.

    >>> decrypte_message_assez_long_avec_espaces('AAAABBBBCCCC', 2)  # doctest:+SKIP
    Attention, plusieurs candidats ('A', 'B', 'C') (indice dans bloc=0)
    Attention, plusieurs candidats ('A', 'B', 'C') (indice dans bloc=1)
    ((1, 1), '    AAAABBBB')
    >>> decrypte_message_assez_long_avec_espaces(CRYPTOGRAMME1, 2, ALPHABET1)
    ((17, 37), "Albert Einstein ... l'énergie d'un système.")
    """
    if len(chiffre)%taille_bloc != 0 :  # je m'assure que la longueur de chiffre est un multiple de taille_bloc
        chiffre += " " * (len(chiffre)%len(taille_bloc))
    
    tuplefreq = ()
    dicres = dict()
    
    for k in range(taille_bloc) : # je constitue un dico qui vas récupérer tout les nième caractères
        dicres[k] = None
        
    
    c=0
    while c < len(chiffre) :      # j'affecte ces caractères à leurs rang de bloc dans dicres
        
        i =0
        while i < taille_bloc :
            dicres[i] = str(dicres[i])+ chiffre[c+i]
            i +=1
        c+=taille_bloc
        
    
    for l in dicres.keys() :  # on calcule les caractère les plus freq dans chaque rang
        fmax = dicres[l].count(alphabet[0])
        listei = [0]
        for i in range(1, len(alphabet)):
            newf = dicres[l].count(alphabet[i])
            if newf > fmax:
                listei = [i]
                fmax = newf
            elif newf == fmax:
                listei.append(i)
        tuplefreq = tuplefreq + tuple(listei) # a posteriori je me dis que j'aurais pu utiliser car_le_plus_frequent mais j'ai mal au coeur à l'idée d'effacer ce travail
        
    return (tuplefreq , dechiffre_message_vigenere(chiffre, tuplefreq, alphabet))







if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
