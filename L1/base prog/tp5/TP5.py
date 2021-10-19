# COLLE Maxime
# DOUCHET Benjamin

# TP5
#ex1

print('','\n','\n','\n','\n')

#ex2

def imprimer_vertical(s) :
    """
    imprime la chaine de caractère en verticale
    à la verticale
    param s (str)
    C,U none
>>> imprimer_vertical ('Test')
T
e
s
t
    """
    
    for c in s:
        print(c)
        
#ex3

def my_len(a) :
    """
    renvoie la longueur de la variable
    a variable (str)
    C.U none
>>> my_len('test')
4
>>> my_len('123456789')
9
    
    """
    b=0
    
    for c in a:
        b = b+1
    return b

#ex4
#Q1
def tirets(a) :
    """
    renvoie la chaine en entrée en inserant un tiret entre chaques caractères
    a variable (str)
    C.U none
>>> tirets('hello there')
'h-e-l-l-o- -t-h-e-r-e-'
>>> tirets('bonjour')
'b-o-n-j-o-u-r-'
    """
    temp= ''
    for c in a :
        temp= temp+(c+'-')
      
    return temp

#Q2
def tirets_v2(a) :
    """
    renvoie la chaine en entrée en inserant un tiret entre chaques caractères en sautant les espaces
    a variable (str) 
    C.U none
>>> tirets_v2('hello there')
'h-e-l-l-o- t-h-e-r-e-'
    """
    temp = ''
    for c in a :
        if c == ' ':
            temp = temp + c
        else :
            temp = temp+(c+'-')
            
    return temp

#Ex 5

def miroir(a):
    """
    revoie la chaine en entrée dans l'ordre inverse
    a (str) mots à inverser
    C.U none
>>> miroir('colle')
'elloc'
>>> miroir('kayak')
'kayak'
    """
    temp = ''
    for c in a :
        temp = c + temp
    return temp

#Ex 6
#Q1 
def est_palindromique(a) :
    """
    prédicat nous retournant si la chaine de caractère est palindromique ou non
    a (str)
    C.U none
>>> est_palindromique('kayak')
True
>>> est_palindromique('kaya')
False
    """
    
    temp = ''
    for c in a :
        temp = c + temp
    return a == temp

#Q2
def est_palindromique_v2(a):
    """
    prédicat nous retournant si la chaine de caractère est palindromique ou non
    a (str)
    C.U none
>>> est_palindromique('kayak')
True
>>> est_palindromique('kaya')
False
    """
    b = miroir(a)
    return b == a

#Ex 7

#Q1
def supprimerOccCarac(a , b):
    """
    fonction suprimmant les occurence de caracatères en b de la chaine a
    a (str) la chaine à étudier
    b (str) le caractère à suprimer
    C.U none
>>> supprimerOccCarac('timoleon' , 'o')
'timlen'
    """
    temp= ''
    
    for c in a :
        if c == b :
            temp = temp
        else :
            temp = temp + c
        
    return temp

#Q2

est_palindromique_v2(supprimerOccCarac('esope reste ici et se repose' , ' '))

#Ex8

def mettreEnMajuscule(a) :
    """
    modifie la casse de la chaine pour la mettre en majuscule
    a ( str ) chaine à mettre en majuscule
    C.U none
>>> mettreEnMajuscule('polom étro')
'POLOM éTRO'
    """
    
    temp =''
    
    for c in a :
        if ord(c) >= ord('a') and ord(c) <= ord('z') :
            c = chr(ord(c)-(ord('a')-ord('A')))
            temp = temp + c
        else :
            temp = temp + c
    return temp

#ex 9
def mettreEnMinuscule(a) :
    """
    modifie la casse de la chaine pour la mettre en minuscule
    a ( str ) chaine à mettre en minuscule
    C.U none
>>> mettreEnMinuscule('POLOM éTRO')
'polom étro'
>>> mettreEnMinuscule('aBC\u00c9,3 @!-XYz')
'abcÉ,3 @!-xyz'
    """
    temp =''
    
    for c in a :
        if ord(c) >= ord('A') and ord(c) <= ord('Z'):
            c = chr(ord(c)+(ord('a')-ord('A')))
            temp = temp + c
        else :
            temp = temp + c
    return temp

#ex 10
def transformerMinMaj(a) :
    """
    modifie la casse des minuscule en majuscule et vice-versa
    a (str) la chaine à transformfer
    C.U none
>>> transformerMinMaj('Pollo MéTRo')
'pOLLO métrO'
>>> transformerMinMaj('aBC\u00c9,3 @!-XYz')
'AbcÉ,3 @!-xyZ'
    """
    temp =''
    
    for c in a :
        if ord(c) >= ord('A') and ord(c) <= ord('Z'):
            c = chr(ord(c)+(ord('a')-ord('A')))
            temp = temp + c
        elif ord(c) >= ord('a') and ord(c) <= ord('z') :
            c = chr(ord(c)-(ord('a')-ord('A')))
            temp = temp + c
        else :
            temp = temp + c
    return temp

#ex 11

def comparerChaines( a , b ) :
    """
    compare les str en entrée et renvoie  0 si egales 1 si a>b et  2 si b<a
    a ( str ) chaine en entrée 1
    b ( str ) chaine en entrée 2
>>> comparerChaines('texte' , 'texte')
0
>>> comparerChaines('texto' , 'texte')
1
>>> comparerChaines('texte' , 'texto')
2
>>> comparerChaines('teeeeeeexte' , 'texto')
2
    """

    if a < b :
        res=2
    elif b<a :
        res = 1
    else :
        res = 0
    return res
#ex12
#Q1
def rechercherCaractereG(a,b):
    """
    donne l'indice de la première occurence de b dans a en partant de la gauche
    renvoie -1 si la lettre a chercher n'apparait pas
    a ( str ) chaine de caractere à analyser
    b ( str ) le caractère à rechercher
>>> rechercherCaractereG('voici une chaîne', 'i')
2
>>> rechercherCaractereG('voici une chaîne', 'x')
-1
    """
    temp = -1
    trouve = False
    
    for i in range(len(a)) :
        if a[i]== b and not trouve :
            temp = i
            trouve = True
    return temp
    
#Q2
def rechercherCaractereD(a,b):
    """
    donne l'indice de la première occurence de b dans a en partant de la droite
    renvoie -1 si la lettre a chercher n'apparait pas
    a ( str ) chaine de caractere à analyser
    b ( str ) le caractère à rechercher
>>> rechercherCaractereD('voici une chaîne', 'i')
4
>>> rechercherCaractereD('voici une chaîne', 'x')
-1   
    """
    temp = -1
    trouve = False
    
    for i in range(len(a)-1,-1,-1):
        if a[i]== b and not trouve :
            temp = i
            trouve = True
    return temp

#Q3
def rechercherCaractereG_V2(a,b):
    """
    donne l'indice de la première occurence de b dans a en partant de la gauche
    renvoie -1 si la lettre a chercher n'apparait pas
    a ( str ) chaine de caractere à analyser
    b ( str ) le caractère à rechercher
>>> rechercherCaractereG('voici une chaîne', 'i')
2
>>> rechercherCaractereG('voici une chaîne', 'x')
-1
    """
    temp = -1
    trouve = False
    a1=miroir(a)
    rechercherCaractereD(a1,b)
#ex13
    
    
def nbreOccurences(a,b):
    """
    compte le nombre d'occurence dans a de b
    a ( str ) chaine de caractere à analyser
    b ( str ) le caractère à rechercher
    """
    temp = 0
    
    for c in a :
        if c == b :
         temp = temp+1
    return temp
# ex14
#Q1
def plusFrequent(a):
    """
    renvoie le caractere le plus fréquent de la str
    a (str) en minuscule
    cu none
    
>>> plusFrequent('esope reste ici et se repose')
'e'
>>> plusFrequent("Il y a autant de 'e' que de 'a' dans cette phrase, pas plus")
'a'
>>> plusFrequent('')
''
    """
    maxocc = 0
    pf =""
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    
    for c in alphabet :
        nbocc = 0
        for cs in a :
            if cs == c :
                nbocc += 1
        if nbocc > maxocc :
            maxocc = nbocc
            pf = c
    return pf

#Q2

def plusFrequent_V2(a):
    """
    renvoie le caractere le plus fréquent de la str
    a (str) en minuscule
    cu none
    
>>> plusFrequent_V2('esope reste ici et se repose')
'e'
>>> plusFrequent_V2("Il y a autant de 'e' que de 'a' dans cette phrase, pas plus")
'a'
>>> plusFrequent_V2('')
''
    """
    maxocc = 0
    pf =""
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    
    for c in alphabet :
        nbocc = nbreOccurences(a,c)
        if nbocc > maxocc :
            maxocc = nbocc
            pf = c
    return pf

#Ex15
#Q1
def supprimerCarac(s,b):
    """
    fonction supprime le caractère d'indice b dans la chaine s
    s (str) chaine à traiter
    b ( int ) positif indice de l'occurence à supprimer
    C.U none
>>> supprimerCarac('Timoleon', 3)
'Timleon'
>>> supprimerCarac('Timoleon', -2)
'Timoleon'
>>> supprimerCarac('Timoleon', 10)
'Timoleon'
     """
    temp =""
    for i in range(len(s)):
        if i == b :
            temp = temp
        else :
            temp = temp + s[i]
        
    return temp

#Q2
def supprimerCarac_v2(s,b):
        
    """
    fonction supprime le caractère d'indice b dans la chaine s
    s (str) chaine à traiter
    b ( int ) indice de l'occurence à supprimer
    C.U none
>>> supprimerCarac_v2('Timoleon', 3)
'Timleon'
>>> supprimerCarac_v2('Timoleon', -1)
'Timoleo'
>>> supprimerCarac_v2('Timoleon', 10)
'Timoleon'
>>> supprimerCarac_v2('Timoleon', -8)
'imoleon'
     """   
    temp =""
    
    if b >= 0 :
        for i in range(len(s)):
            if i == b :
                temp = temp
            else :
                temp = temp + s[i]
    else :
        for i in range(len(s)-1, -1 , -1) :
            if i == (len(s)+b) :
                temp = temp
            else :
                temp =s[i] + temp
        
    return temp

#Ex 16
    
def insererCaractere ( a , b , c ):
    """
    insère le caratere en var(c)) à l'indice var(b) dans la chaine var(a 
    a ( str ) chaine à modifier
    b (int) indice où inserer
    c ( str) chaine à inserer
    C.U b entier positif
>>> insererCaractere('Timleon', 3, 'o')
'Timoleon'
>>> insererCaractere('Aucune modification', 20, '!')
'Aucune modification'
    """
    temp = ""
    
    for i in range(len(a)) :
        if i == b :
            temp = temp + c + a[i]
        else :
            temp = temp + a[i]
    return temp

#ex 17
#Q1

def remplacerCaractere ( a , b , c ):
    """
    renvoie la chaine en var(a) en remplaçant le caratère de l'indice
    désigné par b par la le caractère en c
    a(str) chaine à modifier
    b (int) positif indice de la lettre à modifier
    c (str) caractère de remplacement
>>> remplacerCaractere('Tim-leon', 3, 'o')
'Timoleon'
>>> remplacerCaractere('Ti-on', 2, 'mole')
'Timoleon'
>>> remplacerCaractere('Aucune modification', 20, ' réalisée')
'Aucune modification'
    """
    temp = ""
    for i in range( len(a)) :
        if i == b :
            temp = temp + c
        else :
            temp = temp + a[i]
    return temp

#Q2

def remplacerOccurrences(a ,b ,c ):
    """
    renvoie la chaine en var(a) en remplaçant les occurences du caratère de 
    b par la chaine en c
    a(str) chaine à modifier
    b (int) positif indice de la lettre à modifier
    c (str) caractère de remplacement
>>> remplacerOccurrences('@ 3 est le neveu de @ 1er.','@','Napoléon')
'Napoléon 3 est le neveu de Napoléon 1er.'
"""
    temp = ""
    for i in range( len(a)) :
        if a[i] == b :
            temp = temp + c
        else :
            temp = temp + a[i]
    return temp
        

if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)