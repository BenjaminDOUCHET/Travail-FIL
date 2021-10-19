# COLLE MAXIME
# DOUCHET BENJAMIN

#TP7

from turtle import *
speed(0)
# compréhension

# 2) on ne peux pas dire , celà dépends de l'orientation de la "tortue" dans le cas initial elle avance
# 3) si on relance forward(100) elle prolonge le trait
# 4) le curseur recule
# 5) l'angle est exprimé en degrès
# 6) le curseur se rends aux coordonnées en paramètre en déssinant un trait

#>>> forward(100)
#>>> right(90)
#>>> penup()
#>>> forward(20)
#>>> pendown()
#>>> right(90)
#>>> pencolor('green')
#>>> forward(100)


#déssiner avec des carrés

#Q1

def carre(l) :
    """
    dessine un carré dont la longueur des côtés est passée en paramètre, ce
    carré étant dessiné depuis l'état courant de la tortue
    l (int ou float ) longueur du côté du carré
    C.U none
    """
    pencolor('black')
    
    for i in range (4) :
        forward(l)
        left(90)
 
#Q2 
def carre10(l):
    """
    dessine 10 carrés séparé de 5 pixels les un des autres
    l (int ou float) longueur du côté des carrés
    C.U none
    """
    for i in range (10) :
        carre(l)
        penup()
        forward(l+5)
        pendown()
        
#Q3
def carre10x10() :
    """
    dessine un carre composé de 100 carrés de coté 50 espacés de 5
    C.U none
    """
    l=50
    
    for i in range (10) :
        
        carre10(l)
        penup()
        goto(0,(l+5)*(i+1))
        pendown()
        
#Q4

def carreemboite() :
    """
    dessine la figure constituée de cinquante carrés emboîtés
    ayant tous un sommet commun (en bas à gauche) et dont les longueurs des
    côtés varient de 10 en 10
    C.U none
    """
    l=5
    
    for i in range(50):
        carre(l)
        l=l+10
        
#Q5
def carre_tournant(n) :
    """
    dessine la figure de n carrés autour du point de départ
    n(int) nombre de carrés souhaités
    C.U none
    """
    
    l = 100
    
    for i in range(n) :
        carre(l)
        right(360/n)

# dessiner des polygones réguliers

#Q1

# cette angle est 360/n n étant le nombre de côtés

#Q2

def polygone_reg_convexe(n,l) :
    """
    dessine le polygone convexe régulier à n cotés de longueur l
    n(int) nombre de côté du polygone régulier
    l(int ou float) longueur du côté
    C.U none
    """

    pencolor('black')
    
    for i in range (n) :
        forward(l)
        left(360/n)


# Q3
    #speed(0)
    #polygone_reg_convexe(4,100)
    #clearscreen()
    #speed(0)
    #carre(100)
    #penup()
    #goto(200,0)
    #pendown()
    #polygone_reg_convexe(5,85)
    #penup()
    #goto(20 , -200)
    #pendown()
    #polygone_reg_convexe(6,65)
    #penup()
    #goto(220 , -200)
    #pendown()
    #polygone_reg_convexe(7,55)

def polygone_etoile(n,l,k):
    """
    dessine un polygone régulier étoilé à n côtés de longueur l, et k le pas entre les sommets.
    """
    for i in range(n):
        right(360/n*k)
        forward(l)


# il n'est pas possible de dessiner hexagone étoilé d'un coup.
# il faut imbriquer deux triangles



def test():
    """
    procedure de controle du TP
    """
    l=50
    print(carre(l))
    input("suite")
    clearscreen()
    speed(0)
    print(carre10(l))
    input("suite")
    clearscreen()
    speed(0)
    print(carre10x10())
    input("suite")
    clearscreen()
    speed(0)
    print(carreemboite())
    n=int(input("suite, donnez le nombre de carré dans carré tounant : "))
    clearscreen()
    speed(0)
    carre_tournant(n)
    n=int(input("donnez le nombre de côté du polygone convexe"))
    l = int(input("donnez la longueur du côté du polygone convexe"))
    clearscreen()
    speed(0)
    polygone_reg_convexe(n,l)
    input("suite")
    clearscreen()
    speed(0)
    polygone_reg_convexe(4,100)
    input("suite")
    clearscreen()
    speed(0)
    carre(100)
    penup()
    goto(200,0)
    pendown()
    polygone_reg_convexe(5,85)
    penup()
    goto(20 , -200)
    pendown()
    polygone_reg_convexe(6,65)
    penup()
    goto(220 , -200)
    pendown()
    polygone_reg_convexe(7,55)
    input("suite")
    clearscreen()
    speed(0)
    polygone_etoile(10,200,3)
    input("suite")
    clearscreen()
    speed(0)
    polygone_etoile(5,150,2)
    penup()
    goto(200,-50)
    pendown()
    polygone_etoile(7,150,4)
    penup()
    goto(0,-250)
    pendown()    
    polygone_etoile(8,150,5)    
    penup()
    goto(200,-250)
    pendown()
    polygone_etoile(9,150,5)
    



if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)