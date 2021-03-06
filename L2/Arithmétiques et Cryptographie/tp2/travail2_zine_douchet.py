#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur(s): ZINE nada - DOUCHET Benjamin
:date: vendredi 24 janvier 2020
:objet: Chiffrement/déchiffrement de messages par la méthode de César

"""


from alphabet import ALPHABETS


def chiffre_lettre(lettre, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Fait le chiffrement de César de ``lettre`` par ``cle``.

    :param str lettre: lettre à chiffrer
    :param int cle: clé de chiffrement (décalage)
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet.
              Valeur par défaut : alphabet des 26 lettres latines capitales.
    :return: lettre chiffrée
    :rtype: str
    :CU: lettre doit appartenir à alphabet

    >>> tuple(chiffre_lettre(k, 3) for k in 'CESAR')
    ('F', 'H', 'V', 'D', 'U')
    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> tuple(chiffre_lettre(k, 8, decimal) for k in '012')
    ('8', '9', '0')
    >>> greek = ALPHABETS['LOWER_GREEK']
    >>> tuple(chiffre_lettre(k, 7, greek) for k in 'μιακ')
    ('σ', 'π', 'θ', 'ρ')
    """
    basecode = list(alphabet)
    indice = basecode.index(lettre)+cle
    
    if indice >= len(alphabet) :
        indice = indice%len(alphabet)
    
    return basecode[indice]

def chiffre_message(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Fait le chiffrement de César de ``msg`` par ``cle``.

    :param str msg: message à chiffrer
    :param int cle: clé de chiffrement (décalage)
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet.
              Valeur par défaut : alphabet des 26 lettres latines capitales.
    :return: message chiffré
    :rtype: str
    :CU: les caractères de ``msg`` doivent appartenir à ``alphabet``.

    >>> chiffre_message('CESAR', 3)
    'FHVDU'
    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> chiffre_message('012', 8, decimal)
    '890'
    >>> greek = ALPHABETS['LOWER_GREEK']
    >>> chiffre_message('μιακ', 7, greek)
    'σπθρ'
    """
    res=""
    for char in msg :
        if char == " " :
            res+= " "
        else:
            res += chiffre_lettre(char, cle, alphabet)
    return res

def dechiffre_message(msg, cle, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Fait le déchiffrement de ``msg``, connaissant la clé ``cle``.

    :param str msg: message à déchiffrer
    :param int cle: clé de chiffrement (décalage)
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet.
              Valeur par défaut : alphabet des 26 lettres latines capitales.
    :return: message déchiffré
    :rtype: str
    :CU: les caractères de ``msg`` doivent appartenir à ``alphabet``

    >>> dechiffre_message('FHVDU', 3)
    'CESAR'
    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> dechiffre_message('890', 8, decimal)
    '012'
    >>> greek = ALPHABETS['LOWER_GREEK']
    >>> dechiffre_message('σπθρ', 7, greek)
    'μιακ'
    """
    res=""
    for char in msg :
        if char == " " :
            res+= " "
        else:
            res += chiffre_lettre(char, -cle, alphabet)
    return res

def decrypte_message(msg, car_freq, alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Tente de décrypter ``msg`` chiffré par la méthode César

    Mais le décalage est a priori inconnu.

    :param str msg: message à décrypter
    :param str car_freq: caractère supposé le plus fréquent dans le clair
    :param Alphabet alphabet: paramètre optionnel définissant l'alphabet.
              Valeur par défaut : alphabet des 26 lettres latines capitales.
    :return: liste de message(s) décrypté(s) possible(s) (on l'espère)
    :rtype: list
    :CU: les caractères de ``msg`` ainsi que ``car_freq`` doivent appartenir
         à ``alphabet``

    >>> decrypte_message('OQYQEEMSQBAEEQPQTGUFRAUEXMXQFFDQQ', 'E')
    ['CEMESSAGEPOSSEDEHUITFOISLALETTREE']
    >>> set(decrypte_message('JLTLZZHNLHHBAHUAKLHXBLKLLHPUZPMHP'\
                             'ALZHAALUAPVUHJHJHYWPLNLBE', 'E')) ==\
        {'CEMESSAGEAAUTANTDEAQUEDEEAINSIFAITESATTENTIONACACARPIEGEUX',\
         'GIQIWWEKIEEYXERXHIEUYIHIIEMRWMJEMXIWEXXIRXMSREGEGEVTMIKIYB'}
    True
    """
    res =[]
    msgcode=list(msg)
    alpha=list(alphabet)
    mem = 0
    freqcode = tuple()
    cle = tuple()
    # on determine le caractère le plus fequent dans le message codé
    for c in alpha :
        compteur = msgcode.count(c)
        if compteur == mem :
            freqcode += (c,)
            mem = compteur
        if compteur > mem :
            freqcode = tuple(c)
            mem = compteur
    
    
    # on determine les clé de cryptage possibles en faisant la difference de rang entre car_freq et les frequences mesurées plus haut
    
    for k in range(len(freqcode)):
        cle += ((alpha.index(freqcode[k])-alpha.index(car_freq)),)
    
    # on applique la ou les cles trouvées      
    
    
    for i in range(len(cle)) :
        res.append(dechiffre_message(msg,cle[i],alphabet))
    return res
    
if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)

# Pour chaque triplet msg, clé, alphabet qui suit, procédez au chiffrement
# puis déchiffrement.

# - msg='OUI', clé=10, alphabet = CAPITAL_LATIN
# - msg='Le grec propose son astuce bien attique.', clé=47, alphabet = PRINTABLE ASCII
# - msg='ουκελαβονπολιναλλαγαρελπιςεφηκακα', clé=14, alphabet = LOWER GREEK

# Ajoutez votre code ici, et en commentaires les résultats

chiffre_message('OUI',10,alphabet=ALPHABETS['CAPITAL_LATIN'])
#'YES'
dechiffre_message('YES',10,alphabet)
#'OUI'

ASCII = ALPHABETS['PRINTABLE_ASCII']
chiffre_message('Le grec propose son astuce bien attique.',46,ASCII)
#'z4 6A42 ?A>?>B4 B>= 0BCD24 184= 0CC8@D4\\'
dechiffre_message('z4 6A42 ?A>?>B4 B>= 0BCD24 184= 0CC8@D4\\',46,ASCII)
# 'Le grec propose son astuce bien attique.'

greek = ALPHABETS['LOWER_GREEK']
chiffre_message('ουκελαβονπολιναλλαγαρελπιςεφηκακα',14,greek)
# 'δκψσωοπδβεδωχβοωωοροζσωεχησλυψοψο'
dechiffre_message('δκψσωοπδβεδωχβοωωοροζσωεχησλυψοψο', 14 ,greek)
# 'ουκελαβονπολιναλλαγαρελπιςεφηκακα'