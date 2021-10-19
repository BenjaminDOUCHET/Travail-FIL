#!/usr/bin/python3
# -*- coding:utf-8 -*-

"""
:auteur 1: benjamin DOUCHET
:auteur 2:
:groupe: SESI 12
:date: mardi 20 mars 2020
:objet: Travail numéro 8 (machine Enigma)
"""
from sympy import factorial
from enigma.machine import EnigmaMachine
from cryptogrammes_enigma import CRYPTOGRAMMES
from alphabet import ALPHABETS


ALPHABET = ALPHABETS['CAPITAL_LATIN']


def nb_occurrences(txt):
    '''
    :param str txt: un texte
    :return: un dictionnaire dont les clés sont les lettres de ALPHABET
             et les valeurs associées le nombre d'occurrences de ces
             lettres dans txt.
    :rtype: dict
    :CU: txt ne doit contenir que des lettres de ALPHABET.
    
    >>> occ =  nb_occurrences('ALPHABET')
    >>> [occ[k] for k in 'ABC']
    [2, 1, 0]
    '''
    ref = str(ALPHABET)
    res = dict()
    for i in range(len(ref)) :
        res[ref[i]] = txt.count(ref[i])
    return res

def indice_coincidences(txt):
    """
    :param str txt: un texte
    :return: l'indice de coincidence du texte txt.
    :rtype: float
    :CU: len (txt) >= 2 et tous les caractères de txt sont dans ALPHABET
    :Exemple:
    
    >>> indice_coincidences('ALPHABET') == 2 / (8*7)
    True
    """
    deno = len(txt)*(len(txt)-1)
    num = 0
    occ = nb_occurrences(txt)
    for c in occ.keys() :
        if occ[c] !=0 :
            num += occ[c]*(occ[c]-1)
    return num / deno


# ici un test de fonction pour generer les permutation qui me servira dans la fonction suivante:
def compteur():
    """
    """
    
    ref=str(ALPHABET)
    cle = [ ref[0],ref[0],ref[0]]
    res=[]
    while cle[0]+cle[1]+cle[2] != ref[len(ref)-1]+ref[len(ref)-1]+ref[len(ref)-1] :
        res.append(cle[0]+cle[1]+cle[2])
        cle[2] = ref[(ref.index(cle[2])+1)%len(ref)]
        if ref.index(cle[2]) == 0 :
            cle[1] = ref[(ref.index(cle[1])+1)%len(ref)]
            if ref.index(cle[1]) == 0 and ref.index(cle[2]) == 0:
                cle[0] = ref[(ref.index(cle[0])+1)%len(ref)]
                
    res.append('ZZZ')
    return res



def decrypte_machine_enigma_sans_fiches(chiffre):
    '''Décrypte un message chiffre d'une machine enigma sans appariements

    :param str chiffre: texte à déchiffrer
    :return: configuration probable d'une machine Enigma sans fiches
             sur le tableau de connexions
    :rtype: tuple
    :CU: cette fonction ne convient que pour des machines Enigma n'utilisant
         que les trois rotors I II et III et le réflecteur B
    '''
    # initialisation des variables et references 
    resu = [0,"",""] # var temporaire qui vas acceuilir les txt "dechiffres" [0]=indice_coincidence [1]=cle  [2]= configuration poss_rotors 
    res=[] 
    poss_rotor = ['I II III' ,'I III II','II I III','II III I','III I II','III II I',] # combinaison des rotors ossibles
    
    
    ref= str(ALPHABET) # alphabet de reference pour les permutations
    cle = [ ref[0],ref[0],ref[0]] # cle de depart
    
    
    
    # on génère le réglage des rotors
    for poss in range(len(poss_rotor)) :
        print(poss_rotor[poss])
        machine = EnigmaMachine.from_key_sheet(reflector='B',rotors=poss_rotor[poss],plugboard_settings='')
        cle[0],cle[1],cle[2] = ref[0] , ref[0] ,ref[0]
        # on boucle pour tester toutes les permutations
        while cle[0]+cle[1]+cle[2] != ref[len(ref)-1]+ref[len(ref)-1]+ref[len(ref)-1] :
            
            machine.set_display(cle[0]+cle[1]+cle[2])
            temp = machine.process_text(chiffre)
            
            # ici le controle de l'indice de coincidence :
            if indice_coincidences(temp) > resu[0] :
                resu[0] = indice_coincidences(temp)
                resu[1] = cle[0]+cle[1]+cle[2]
                resu[2] = poss_rotor[poss]
            
            # maintenant on vas incrémenter la permutation :
            cle[2] = ref[(ref.index(cle[2])+1)%len(ref)]
            if ref.index(cle[2]) == 0 :
                cle[1] = ref[(ref.index(cle[1])+1)%len(ref)]
                if ref.index(cle[1]) == 0 and ref.index(cle[2]) == 0:
                    cle[0] = ref[(ref.index(cle[0])+1)%len(ref)]
        
        # on test la dernière combinaison 'ZZZ' qui n'a pas pu être testée dans la boucle :
        machine.set_display(ref[len(ref)-1]+ref[len(ref)-1]+ref[len(ref)-1])
        temp = machine.process_text(chiffre)
        if indice_coincidences(temp) > resu[0] :
                resu[0] = indice_coincidences(temp)
                resu[1] = cle[0]+cle[1]+cle[2]
                resu[2] = poss_rotor[poss]
    return tuple(resu)
    
    
res_c2 = (0.04949280054265717, 'GMA', 'I III II')  
ord_rotor= res_c2[2]
pos_rotors= res_c2[1]
appariements =""
    
def trouve_appariement(chiffre, rot, rotpos, appar):
    '''Détermine le nouvel appariement rendant maximal l'IC du dechiffré obtenu

    :param str chiffre: texte à déchiffrer
    :param str rot: placement des rotors
    :param str rotpos: réglage des rotors
    :param str appar: appariements déjà trouvés
    :return: l'appariement qui maximise l'indice de coincidence
    :rtype: str
    '''
    #j'initialise mes variables et references :
    dep = str(ALPHABET)
    machine = EnigmaMachine.from_key_sheet(reflector='B', rotors=rot , plugboard_settings= appar )
    machine.set_display(rotpos)
    ind_ref = indice_coincidences(machine.process_text(chiffre))
    ref =""
    paire=""
    # j'exclue des lettres à étudier les paires déjà trouvées :
    for c in dep :
        if c not in appar :
            ref+=c
    
    # je génère les paires de lettres
    for i in range(len(ref)) :
        for j in range(i+1,len(ref)) :
            
            test =appar +" "+ref[i]+ref[j]
            machine = EnigmaMachine.from_key_sheet(reflector='B', rotors=rot , plugboard_settings= test)
            machine.set_display(rotpos)
            temp = machine.process_text(chiffre)
            if indice_coincidences(temp) > ind_ref :
                ind_ref = indice_coincidences(temp)
                paire = ref[i]+ref[j]
    return paire
                
                
# jetrouve les apprariements suivants : 'NO CM AL DP EF IT'
    
    
#>>> machine = EnigmaMachine.from_key_sheet(
#    reflector='B',
#    rotors=ord_rotor,
#    plugboard_settings='NO CM AL DP EF IT'
#)
#>>> machine.set_display(pos_rotors)
#>>> texte = machine.process_text(CRYPTOGRAMMES[2])
#>>> print(texte)
#ILMESEMBLAITQUETOUTFUTBRUMEUXETNACREAUTOURDEMOIAVECDESPRESENCESMULTIPLESETINDISTINCTESPARMILES
#QUELLESCEPENDANTSEDESSINAITASSEZNETTEMENTLASEULEFIGUREDUNHOMMEJEUNEDONTLECOUTROPLONGSEMBLAITANNONCER
#DEJAPARLUIMEMELECARACTEREALAFOISLACHEETROUSPETEURDUPERSONNAGELERUBANDESONCHAPEAUETAITREMPLACEPARUNE
#FICELLETRESSEEILSEDISPUTAITENSUITEAVECUNINDIVIDUQUEJENEVOYAISPASPUISCOMMEPRISDEPEURILSEJETAITDANSLOMBRE
#DUNCOULOIRUNEAUTREPARTIEDUREVEMELEMONTREMARCHANTENPLEINSOLEILDEVANTLAGARESAINTLAZAREILESTAVECUNCOMPAGNON
#QUILUIDITTUDEVRAISFAIREAJOUTERUNBOUTONATONPARDESSUSLADESSUSJEMEVEILLAI
#



if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
