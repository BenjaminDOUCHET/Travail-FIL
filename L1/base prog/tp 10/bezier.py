#COLLE MAXIME
#DOUCHET BENJAMIN

from turtle import *


def linear(p0 , p1 , t ):
    """
    renvoie la coordonnée du point P(t) suivant l'équation paramétrique
    P(t)=P0+t(P1−P0)=(1−t)P0+tP1 avec  t∈[0,1]
    p0 ( tuple )  le tuple de coordonées de P0
    p1 ( tuple ) le tuple de coordonées de P1
    t ( int ou float ) t∈[0,1]
    C.U none
>>> linear((0,0), (2,1), 0.3)
(0.6, 0.3)
    """
   
    return (p0[0]*(1-t)+p1[0]*t , p0[1]*(1-t)+p1[1]*t)

def draw_linear( p0 , p1 , steps ) :
    """
    dessine une courbe de bézier d'ordre 1 de paramètre p0 p1 
    p0 p1 ( tuple ) coordonées des points de controle format ( x , y)
    steps ( int ) valeurs du pas de tracé
    C.U none
    """
    speed(0)
    
    for i in range(steps) :
        t = i / steps
        goto(linear(p0,p1,t))

def draw_quadratic(p0,p1,p2,steps):
    """
    dessine une courbe de bézier d'ordre 1 de paramètre p0 p1 p2
    p0 p1 p2 ( tuple ) coordonées des points de controle format ( x , y)
    steps ( int ) valeurs du pas de tracé
    C.U none
    """
    
    speed(0)
    
    for i in range(steps) :
        t = i / steps
        q0 = linear(p0,p1,t)
        q1 = linear(p1,p2,t)
        goto(linear(q0,q1,t))
    
# pour test : draw_quadratic((0,0),(-50,200),(200,200),100)

points_test=((0,0), (0,100), (100, 100), (300, 100), (400, 100), (400, 0))
operations_test=("MOVETO", "CURVE3", "CURVE3", "LINETO", "CURVE3", "CURVE3")



def draw_glyph( points , operations ) :
    """
    procedure dessinant le glyph en consigne
    points(tuple) suite de point de controle du glyphe
    operations(tuple) suite d'opération associées au point du tuple points
    C.U opération doit  être composé d'opération : "MOVETO" "LINETO" "CURVE3"
    """
    i=0
    speed(0)    
    while i < (len(points)-1) :
        if operations[i] == "MOVETO":
            penup()
            goto(points[i])
            pendown()
            i += 1
        if operations[i] == "LINETO" :
            goto(points[i])
            i+=1
        if operations[i] == "CURVE3" :
           draw_quadratic(points[i-1],points[i],points[i+1],100)
           i+=2
           
points = ((20, 16), (20, 22), (24, 26), (28, 31), (48, 49), (32, 57),
          (25, 67), (19, 77), (19, 92), (19, 114), (33, 129), (48, 144),
          (69, 144), (81, 144), (95, 139), (109, 134), (118, 134), (143, 134),
          (143, 122), (114, 122), (120, 108), (120, 95), (120, 72), (106, 58),
          (92, 44), (73, 44), (69, 44), (57, 46), (51, 44), (44, 38), (38, 31),
          (38, 27), (38, 20), (62, 19), (99, 17), (116, 16), (126, 8), (136, 0),
          (136, -14), (136, -36), (112, -52), (87, -67), (59, -67), (37, -67),
          (22, -58), (6, -49), (6, -37), (6, -28), (13, -19), (20, -11),
          (36, 1), (27, 5), (23, 8), (20, 11), (20, 16), (43, 0), (33, -11),
          (30, -16), (27, -21), (27, -26), (27, -37), (39, -44), (51, -50),
          (71, -50), (97, -50), (112, -41), (128, -33), (128, -19), (128, -10),
          (119, -6), (111, -3), (90, -3), (61, -3), (43, 0), (96, 82),
          (96, 87), (94, 95), (93, 102), (90, 112), (88, 121), (81, 128),
          (75, 134), (66, 134), (56, 134), (50, 127), (45, 119), (45, 106),
          (45, 78), (54, 65), (63, 52), (74, 52), (84, 52), (90, 60),
          (96, 68), (96, 82))
operations = ('MOVETO', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'LINETO',
              'LINETO', 'LINETO', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'LINETO', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'MOVETO', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'MOVETO', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3',
              'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3', 'CURVE3')
        

def draw_high_order(p,steps) :
    """
    dessine la courbe de bézier de rang n(longueur du tuple d'entrée -1)
    t (tuple) tuple de tuple format(x,y) correspondant aux point de controle
    steps ( int ) pas du dessin
    C.U none
    """
    Qtemp=()
    a=""
    
    for i in range(steps):
        t=i/steps
        Q=p
        while len(Q)>1:
            for j in range(len(Q)-1):
                Qtemp=Qtemp+(linear(Q[j],Q[j+1],t),)
            Q=Qtemp
            Qtemp=()
        goto(Q[0])
            
        
                
#aile avion

def testavion():
    """
    fonction de test pour le dessin de l'aile d'avion en utilisant la procédure draw_high_order
    """
    upper = ((-200, 0), (-188.5966, 24.4284), (-88.975, 36.5375), (108.809, 11.3309), (199.276, 0.9712), (200, 0.4620))
    lower = ((-200, 0), (-188.5966, -24.4284), (-88.975, -36.5375), (108.809, -11.3309), (199.276, -0.9712), (200, -0.4620))
        
    penup()
    goto(upper[0])
    pendown()
    draw_high_order(upper,75)
    penup()
    goto(lower[0])
    pendown()
    draw_high_order(lower,75)
        
        
                
if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)

            
        
        