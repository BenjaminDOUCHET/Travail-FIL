#Q1

def est_divisible(a,b):
    """
    prédicat nous indiqaunt si la var a est divisble par b
    a (int) nombre à diviser
    b (int) nombre diviseur
    CU : b!=0
    >>> est_divisible(-6,2)
    True
    >>> est_divisible(9,2)
    False
    >>> est_divisible(2,2)
    True
    """
    
    return a%b == 0

#Q2

def est_bissextile (annee):
    """
    prédicat nous indique si l'annee en entrée est bissextile
    annee ( int )
    c_u none
    >>> est_bissextile (100)
    False
    >>> est_bissextile (400)
    True
    >>> est_bissextile (2010)
    False
    >>> est_bissextile (2011)
    False
    >>> est_bissextile (2012)
    True
    """
    return est_divisible(annee,4) and not est_divisible(annee,100) or est_divisible(annee,400)

#Q3

def nbre_jour(m,a):
    """
    donne le nombre de jour du mois en m de l'anne en a
    m (int) mois à étudier
    a (int) annee a étudier
    cu m = entier positif <13
    >>> nbre_jour(2,2012)
    29
    >>> nbre_jour(2,2011)
    28
    >>> nbre_jour(1,2011)
    31
    >>> nbre_jour(4,2011)
    30
    """
    if m==1 or m==3 or m==5 or m==7 or m==8 or m==10 or m==12 :
        res = 31
    elif m==4 or m==6 or m==9 or m==11 :
        res = 30
    elif est_bissextile(a) and m==2 :
        res = 29
    else : res = 28
    return res

#Q4

def est_date_valide(j,m,a):
    """
    prédicat stipulant si une date est valide ou non
    j(int) jour à étudier
    m(int) mois à étudier
    a(int) annee à étudier
    c_u j et m entiers strictement positifs et a entier (pos ou neg)
    >>> est_date_valide(9,10,2019)
    True
    >>> est_date_valide(9,14,2019)
    False
    >>> est_date_valide(58,12,2019)
    False
    """
    return m <= 12 and nbre_jour(m,a) >= j

#Q5 (4+5+19+4+9+2+(5*20))%7 = 3  donc mercredi , la formule fonctionne pour aujourd'hui

#Q6
def corrige_mois (m , a):
    """
    fonction renvoyant la valeurs corrigee du mois selon algorithme de Delambre
    m (int) mois à determiner
    a (int) annee du mois à determiner
    cu mois compris entre 1 et 12 inclu
    >>> corrige_mois (2 , 2001)
    0
    >>> corrige_mois (2 , 2000)
    6
    >>> corrige_mois (1 , 2000)
    3
    >>> corrige_mois (1 , 2001)
    4
    >>> corrige_mois (12 , 2001)
    2
    """
    
    if m == 9 or m==12 :
        res = 2
    elif m==4 or m==7 or (est_bissextile (a) and m==1):
        res = 3
    elif m == 3 or m==11 or ( m==2 and not est_bissextile (a)) :
        res = 0
    elif m==6 :
        res = 1
    elif m==10 or ( m==1 and not est_bissextile (a)) :
        res = 4
    elif m == 5:
        res = 5
    else :
        res = 6
    return res 

#Q7

from math import floor

def num_jour( j , m , a ):
    """
    nous renvoie le numero du jour en fonction de la formule de Delambre
    j (int) numero du jour (supposé valide)
    m (int) numero du mois (supposé valide)
    a (int) numero de l'année ( supposé valide)
    C.U none
    >>> num_jour( 11 , 10 , 2019 )
    5
    >>> num_jour( 11 , 1 , -251 )
    6
    >>> num_jour( 10 , 1 , 2019 )
    4
    >>> num_jour( 9 , 1 , 2019 )
    3
    >>> num_jour( 8 , 1 , 2019 )
    2
    """
    cd = a%100
    ab = a//100
    k = floor(ab/4)
    q = floor(cd/4)
    M = corrige_mois(m , a)
    
    return ((k+q+cd+M+j+2+5*ab)%7)

#Q8

def nom_jour( j , m , a ):
    """
    fonction prenant une date valide (étant déjà passée par la fonction est_date_valide())
    j (int) jour de la date recherchée
    m (int) mois de la date recherchée
    a (int) année de la date recherchée
    C.U faire passer la date dans la fontion est_date_valide() en amont pour s'assurer de la validité de la date
    >>> nom_jour(11,10,2019)
    'vendredi'
    >>> nom_jour(25,12,0000)
    'lundi'
    """
    temp = num_jour( j , m , a )
    
    if temp== 0 :
        res = 'dimanche'
    elif temp == 1 :
        res = 'lundi'
    elif temp == 2 :
        res = 'mardi'
    elif temp == 3 :
        res = 'mercredi'
    elif temp == 4 :
        res = 'jeudi'
    elif temp == 5 :
        res = 'vendredi'
    else:
        res = 'samedi'
    return res

if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)


