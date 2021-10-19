#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1: Zine nada
:auteur 2: Douchet Benjamin
:enseignant: Nicole Raulf 
:groupe: SESI 12
:date: vendredi 14 février 2020
:objet: Travail numéro 5 (chiffrement affine approfondi)
"""


from tp1 import pgcd, pgcd_étendu
from tp4 import dechiffre_message_affine , car_le_plus_frequent
from alphabet import Alphabet, ALPHABETS
from cryptogrammes_affine import CRYPTOGRAMMES


CRYPTO1 = ('AKxvGlzRMpZlvMpzvZlzKgMpXvplvEGzcvzKezltWIGMvzcvzKezG'
           'vKelMXMlWzaWpWGeKvSzvlzpIpSzQIççvzIpzezlGIèzlvpcepQvz'
           'BzKvzèvpZvGSzcEzOMKzBzQIEèvGzKvzxvEGGv')
alph1 = Alphabet(' ,abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZéèàç\'')
CLAIR1 = ("Albert Einstein est l'inventeur de la théorie de la "
          "relativité générale, et non, comme on a trop tendance "
          "à le penser, du fil à couper le beurre")


def congruence_est_inversible(a, N):
    """
    Prédicat disant si a est inversible modulo N

    >>> congruence_est_inversible(2, 10)
    False
    >>> congruence_est_inversible(3, 10)
    True
    >>> congruence_est_inversible(13, 26)
    False
    """
    return pgcd(a ,N ) == 1


def solve_for_affine_key(clair1, chiffre1, clair2, chiffre2, alphabet):
    """
    Sachant que deux lettres données d'un alphabet donné sont chiffrées
    en deux autres lettres données, déterminer une unique clé affine
    correspondant à ces données ; en cas de non-existence ou de
    plusieurs solutions renvoyer le tuple (False, None), sinon renvoyer
    le tuple (True, (a, b)) avec (a, b) l'unique solution, normalisée modulo
    la longueur N de l'alphabet.

    En équations il faut résoudre certaines équations y1 = a x1 + b modulo N
    et y2 = a x2 + b modulo N pour les inconnues a et b, sachant que x1, y1,
    x2, y2, N sont connus. Sans perte de généralité, on peut supposer que le
    nombre de caractères N de l'alphabet est au moins 2.

    Il faut que le a soit unique et il faut aussi qu'il soit inversible
    modulo N.

    :param str clair1, chiffre1, clair2, chiffre2: des lettres
    :param Alphabet alphabet: un alphabet
    :return: (True, (a, b)) ou (False, None)
    :rtype: tuple
    :CU: clair1, chiffre1, clair2, chiffre2 appartiennent à l'alphabet.

    >>> decimal = ALPHABETS['DECIMAL_DIGITS']
    >>> solve_for_affine_key('1', '0', '4', '1', decimal)
    (True, (7, 3))
    >>> solve_for_affine_key('1', '0', '6', '1', decimal)
    (False, None)
    >>> solve_for_affine_key('1', '0', '4', '2', decimal)
    (False, None)
    >>> hexadecimal = ALPHABETS['HEXADECIMAL_DIGITS']
    >>> solve_for_affine_key('1', 'A', 'E', '5', hexadecimal)
    (True, (7, 3))
    >>> solve_for_affine_key('1', '0', 'F', '1', hexadecimal)
    (False, None)
    >>> solve_for_affine_key('1', '0', '4', '2', hexadecimal)
    (False, None)
    """
    cle_a = []
    t_res=tuple()
    for a in range(len(alphabet)) :  # je recupère tous les rangs premier avec la longueur de alphabet
        if pgcd(a,len(alphabet)) == 1 :
            cle_a.append(a)
       
    for i in range(len(cle_a)) : #pour chaque rang valide je cherche les b possible
        for b in range(len(alphabet)):
            # on verifie si la combinaison trouvée fonctionne dans les deux cas
            if (cle_a[i]*alphabet.index(clair1) + b)%len(alphabet) == alphabet.index(chiffre1)and (cle_a[i]*alphabet.index(clair2) + b)%len(alphabet) == alphabet.index(chiffre2):
                
                if len(t_res) == 0 :  # le philtre pur avoir 1 seule solution
                    t_res=(cle_a[i],b)
                else :
                    return (False, None)
                
    if len(t_res) == 2 :
        return (True, t_res)

    else :
        return (False, None)



def decrypte_message_affine_par_debut_connu(
        msg_chiffre,
        debut,
        alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Connaissant les deux premières lettres du clair, décrypter le message.

    :param str msg_chiffre: un message chiffré affinement
    :param str debut: une chaîne de deux caractères, le début du clair
    :param Alphabet alphabet: un alphabet
    :return: le message déchiffré et la clé, ou None si pas de solution unique
    :rtype: tuple ou None

    >>> decrypte_message_affine_par_debut_connu('RSPEGXTSDEAHF', 'CR')
    ('CRYPTOGRAPHIE', (7, 3))
    >>> decrypte_message_affine_par_debut_connu('KXQOXNS', 'BN') is None
    True
    >>> decrypte_message_affine_par_debut_connu('KYQOXNS', 'BO') is None
    True
    >>> alpha = Alphabet('aeioucbtlrs!')
    >>> decrypte_message_affine_par_debut_connu('ioborceuatc!!s', 'ca', alpha)
    ('carabistouille', (7, 3))
    >>> decrypte_message_affine_par_debut_connu('iaborceuatc!!s', 'ca', alpha) is None
    True
    >>> decrypte_message_affine_par_debut_connu('ioborceuatc!!s', 'il', alpha) is None
    True
    """
    val = solve_for_affine_key(debut[0], msg_chiffre[0], debut[1], msg_chiffre[1], alphabet)
    if val == (False, None) :
        return None
    res  = dechiffre_message_affine (msg_chiffre,(val[1][0] , val[1][1]),alphabet)
    
    return ( res , val[1])
   
def decrypte_message_affine_par_fin_connue(
        msg_chiffre,
        fin,
        alphabet=ALPHABETS['CAPITAL_LATIN']):
    """Connaissant les deux dernières lettres du clair, décrypter le message.

    :param str msg_chiffre: un message chiffré affinement
    :param str fin: une chaîne de deux caractères, la fin du clair
    :param Alphabet alphabet: un alphabet
    :return: la clé et le  message déchiffré, ou None si pas de solution unique
    :rtype: tuple ou None

    >>> alpha = Alphabet('abcdr')
    >>> decrypte_message_affine_par_fin_connue('dabdcdrdabd', 'ra', alpha)
    ((2, 3), 'abracadabra')
    """
    val = solve_for_affine_key(fin[0], msg_chiffre[len(msg_chiffre)-2], fin[1], msg_chiffre[len(msg_chiffre)-1], alphabet)
    if val == (False, None) :
        return None
    res  = dechiffre_message_affine (msg_chiffre,(val[1][0] , val[1][1]),alphabet)
    
    return ( val[1] , res )


def decrypte_message_affine_par_mot_connu(
        msg_chiffre,
        mot,
        alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Attaque par parcours exhaustif de l'espace des clés.

    On s'arrête dès qu'une clé candidate donne un clair contenant le mot donné.
    Sinon on renvoie None.

    :param str msg_chiffre: un chiffré
    :param str mot: un mot du clair
    :param Alphabet alphabet: un alphabet
    :return: un tuple formé de la clé de chiffrement, et du message déchiffré
             ou None si aucune clé n'est trouvée
    :rtype: tuple

    >>> test = decrypte_message_affine_par_mot_connu(CRYPTO1, 'tendance', alph1)
    >>> test == ((19, 27), CLAIR1)
    True
    """
    temp =""
    cle_a = []
    t_res=tuple()
    for a in range(len(alphabet)) :  # je recupère tous les rangs premier avec la longueur de alphabet
        if pgcd(a,len(alphabet)) == 1 :
            cle_a.append(a)
       
    for i in range(len(cle_a)) : #pour chaque rang valide je cherche les b possible
        for b in range(len(alphabet)):
            # on crypte le mot avec la combinaison en cours :
            temp =""
            for j in range(len(mot)) :
                x = alphabet.index(mot[j])
                temp+= alphabet[(cle_a[i] * x+b)%len(alphabet)]
            # on regarde si le mocrytpé est dans le message crypté
            if temp in msg_chiffre :
                # le mot est  dans le message on peut donc decrypter
                return ((cle_a[i] , b) ,dechiffre_message_affine (msg_chiffre,(cle_a[i] , b),alphabet))
    
    return None
    


def decrypte_message_affine_par_frequences(msg_chiffre,alphabet=ALPHABETS['CAPITAL_LATIN']):
    """
    Attaque par analyse fréquentielle sur les deux caractères les plus fréquents, supposés être l'espace et la lettre 'e'.

    :param str msg_chiffre: un chiffré, le clair étant un message en français
    :param Alphabet alphabet: un alphabet contenant le caractère espace et la lettre 'e'
    :return: la clé de chiffrement et le message déchiffré
    :rtype: tuple avec la clé en premier et le message déchiffré en second
    :CU: msg_chiffre composé de caractères de alphabet,
         alphabet contient l'espace et 'e'

    >>> test = decrypte_message_affine_par_frequences(CRYPTO1, alph1)
    >>> test == ((19, 27), CLAIR1)
    True
    """
    memmin = 0
    memmax = 0
    cle= dict((("maxf" , "") , ("minf" , "")))
    #je cherche cherche les deux caractères les plus fréquents
    for k in range(len(alphabet)) : 
        compt = msg_chiffre.count(alphabet[k])
        if compt >= memmax :
            memmin= memmax
            memmax= compt
            cle["minf"] = cle["maxf"]
            cle["maxf"] = alphabet[k]
        elif compt< memmax and compt >= memmin :
            memmin = compt
            cle["minf"] = alphabet[k]
    list_cle = list(cle.values())
    
    res =solve_for_affine_key('e', list_cle[1], ' ', list_cle[0], alphabet)
   
  
    if res[0] == False :
        res1 = solve_for_affine_key('e', list_cle[1], ' ', list_cle[0], alphabet)
    
    if res[0] == False :
        return None
    
    return ( res[1] , dechiffre_message_affine(msg_chiffre, res[1], alphabet),)

# mettez ici les clés et les alphabets pour les 4 cryptogrammes de CRYPTOGRAMMES

# CRYPTOGRAMMES[0]

# CRYPTOGRAMMES[1]

# CRYPTOGRAMMES[2]

# CRYPTOGRAMMES[3]


if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
