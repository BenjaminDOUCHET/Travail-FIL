# COLLE MAXIME
# DOUCHET BENJAMIN

#exercie 1
#Q3

def afficher_triangle(n) :
    """
    procédure renvoyant le triangle a 'n' hauteur
    n ( int ) le nombre de 'hauteurs' du triangle
    C.U none
>>> afficher_triangle(5)
O
OO
OOO
OOOO
OOOOO
    """
    h = 0
    temp =""
    
    while h < n :
        h = h+1
        temp = temp + "O"
        print(temp)
    
# Q4

def afficher_carre_diagonale(n) :
    """
    procédure qui affiche un carré de hauteur n avec une diagonale de
    caractères X
    n ( int ) hauteur du carré
    C.U none
>>> afficher_carre_diagonale(5)
XOOOO
OXOOO
OOXOO
OOOXO
OOOOX
    """
    
    h=0
    nb = 0
    temp = ""
    
    while h < n :
        while nb < n :
            if nb == h :
                temp = temp + "X"
            else :
                temp = temp + "O"
            nb = nb+1
        nb = 0
        h = h + 1
        print(temp)
        temp = ""
    
# Q5

def afficher_triangle(n) :
    """
    procédure qui affiche un triangle de hauteur n
    n (int) hauteur du triangle à afficher
    C.U none
>>> afficher_triangle(5)
     O    
    O O   
   O   O  
  O     O 
 OOOOOOOOO
    """

    h=0
    temp =""
    nb = 0
    
    while h < (n-1) :
                                
        while nb <= (2*n-1) :
            if nb == (n+h) or nb == (n-h) :
                temp = temp + "O"
            else :
                temp = temp +" "
            nb = nb+1
            
        nb = 0
        h = h + 1
        print(temp)
        temp = ""

    if h == (n-1) :
        temp =" "
        while nb <= (2*n-2) :
            temp = temp +"O"
            nb = nb +1
        print (temp)    
            
# Exercice 2

#Q1

def table (n) :
    """
    procédure affichant la table de multiplication de 'n'
    n ( int ) numero de la table à afficher
    C.U none
>>> table(5)
1  x  5  =  5
2  x  5  =  10
3  x  5  =  15
4  x  5  =  20
5  x  5  =  25
6  x  5  =  30
7  x  5  =  35
8  x  5  =  40
9  x  5  =  45
10  x  5  =  50
    """
    k = 1
    
    while k <= 10 :
        print ( k , " x ", n , " = " ,(k*n))
        k = k+1

#Q2

def tableAB( n , m ) :
    """
    procédure qui affiche toutes les tables de multiplication pour les naturels
    n et m
    n (int) premier entier à multiplier
    m (int) second entier à multiplier
    C.U none
>>> tableAB(3, 5)
1  x  3  =  3
2  x  3  =  6
3  x  3  =  9
4  x  3  =  12
5  x  3  =  15
6  x  3  =  18
7  x  3  =  21
8  x  3  =  24
9  x  3  =  27
10  x  3  =  30
1  x  4  =  4
2  x  4  =  8
3  x  4  =  12
4  x  4  =  16
5  x  4  =  20
6  x  4  =  24
7  x  4  =  28
8  x  4  =  32
9  x  4  =  36
10  x  4  =  40
1  x  5  =  5
2  x  5  =  10
3  x  5  =  15
4  x  5  =  20
5  x  5  =  25
6  x  5  =  30
7  x  5  =  35
8  x  5  =  40
9  x  5  =  45
10  x  5  =  50
    """
    
    while n <= m :
        table (n)
        n = n+1
    
# Exercice 6

#Q1

def est_premier(x) :
    """
    prédicat qui indique si un nombre est premier
    n (int) nombre naturel à évaluer
    C.U none
>>> est_premier(7)
True
>>> est_premier(70)
False
    """
    k = 2
    
    while k < (x/2) :
        if x%k == 0 :
            return False
        k += 1
    return True

#Q2

def nombre_diviseur(n) :
    """
    fonction qui donne le nombre de diviseurs de n
    n (int) naturel à évaluer
    C.U none
>>> nombre_diviseur(36)
9
    """
    res = 0
    k = 1
    
    while k <= n :
        if n%k == 0 :
            res = res +1
        k = k+1
    return res

# Q3

def facteur_premier(n) :
    """
    fonction nous donnant la décomposition en facteur premier de n
    n (int) naturel à évaluer
    C.U none
>>> facteur_premier(228)
' 2 2 3 19'
>>> facteur_premier(9)
' 3 3'
>>> facteur_premier(15)
' 3 5'
>>> facteur_premier(17)
' 17'
    """
    res = ""
    temp = n
    k=2
    
    while k <= temp :
        if est_premier(k) and (temp%k) == 0 :
            temp =  temp//k
            res = res + " " + str(k)
            k=2
        else :
            k = k+1
    return res


# Exercice 8
# Q1

from random import randint

def jeu() :
    """
    choisit aléatoirement un entier entre 1 et 100,
    puis demande à l'utilisateur (par une saisie input)
    de deviner ce nombre. Si le nombre est deviné,
    la procédure affiche gagné !. Si non, la procédure indique
    que le nombre est plus petit ou plus grand, et redemande
    un nouvel essai à l'utilisateur. Au bout de 8 essais,
    la procédure affiche perdu ! le nombre était.... Si
    l'utilisateur saisit 0, cela signifie qu'il abandonne
    le jeu, et il a perdu
    C.U none
    """
    
    essaie = 1
    nb = randint(1 ,100)
 
    
    while essaie <= 8 :
        mise = int(input(" j'ai choisi un nombre entre 1 et 100 , \n tentez de deviner quel nombre j'ai choisi \n tapez 0 pour abandonner \n :"))
        if mise == 0 :
            return " à la prochaine fois ! "
        if mise == nb :
            return "Gagné ! tu es un champion !"
        essaie = essaie +1
        print ("tentative" , essaie)
    return " perdu le nombre était : ", nb
    
#Q2 je ne connaissait pas la dicotomie en le programmant

def jeuinv() :
    """
    l'ordinateur tente de deviner le nombre entre 1 et 100 auquel
    vous pensez
    C.U none
    """
    inc = 0
    var = ""
    champ = 100
    
    print ( "choisis un nombre naturel entre 1 et 100" )
    while var != "!" :
        if inc == 100 :
            return "tu as triché !"
        if var == "+" :
            if champ %2 == 0 :
                champ = champ + champ // 2
                inc= inc+1
            else :
                champ = champ + 1
                inc = inc+1
        if var == "-" :
            if champ%2 == 0 :
                champ = champ // 2
                inc = inc+1
            else :
                champ = champ - 1
                inc = inc+1
        print(champ , " ?")
        var = str(input(" plus grand : + , plus petit : - , exact : ! " ))
    return "J'ai Gagné"

#Q2 avec dicotomie :

def jeu_inv_dico() :
    """
    seconde version en appliquant le cours sur la dicotomie
    """
    
    a= 0
    b= 100
    m = (a+b)//2 
    var =""
    
    while var != "!" :
        if (b-a)==1 and (var =="+" or var == "-") :
            return "tu as triché !"
        if m%2 == 0 :
            if var == "+" :
                a = m
                m = m + (b-m)//2
                           
            if var == "-" :
                b = m
                m = a+(m-a) // 2
        else :
            if var == "+" :
                a = m
                m += 1
                
            if var == "-" :
                b = m
                m -= 1
        

        print( m , " ?")
        var = str(input(" plus grand : + , plus petit : - , exact : ! " ))
    return "J'ai Gagné"
    
#Exercice 10 

def devlim(x) :
    """
    calcule exp(x) par dévelopement limté
    x(int) la puissance de l'exponentielle à calculer
    C.U None
    """
    
    xtemp = x
    ktemp = 1
    res = 1 + x
    dernfrac = 1
    while dernfrac > 1e-07 :
        xtemp= xtemp * x
        ktemp= ktemp * (ktemp +1)
        dernfrac = xtemp / ktemp
        res = res + dernfrac
        
        
    return res

# Exercice 12

def zero_dic( f , a , b ) :
    """
    f une fonction donnée tel que f(a) < 0 < f(b)
    trouve le x tel que f(x) = 0 avec une erreur de 1e-7
    f ( fonction ) fonction à étudier
    a ( int ou float ) borne inférieur de l'ensemble de départ
    b ( int ou float ) borne supérieur de l'ensemble de départ
    c.u la fonction doit être définie dans R
    """
    a1 = a
    b1 = b
    ens = (b - a)
    m = (a+b)/2
    
    while ens > 1e-07 :
        if f(m) > 0 :
            b1 = m
        if f(m) < 0 :
            a1 = m
        if f(m) == 0 :
            return m
        m = (a1+b1) / 2
    return m



    
def mot_plus_long( a ):
    """
    fonction qui donne le mot le plus grand dans la str d'input
    a ( str ) suite de mots à analyser
    C.U séparer les mots par un espace
>>> mot_plus_long('le matou silencieux prend son temps')
'silencieux'
    """
    res=""
    temp=""
    
    for i in range(len(a)):
        if a[i] == " ":
            if len(res) < len(temp) :
                res = temp
            temp = ""
        elif i == (len(a)-1):
            temp = temp + a[i]
            if len(res) < len(temp) :
                res = temp
            temp = ""

        else :
            temp = temp + a[i]

    return res
    
            














if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)