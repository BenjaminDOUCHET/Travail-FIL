def maximum ( a, b ):
    """
    nous donne la valeur maximum entre les deux entrées
    a= (int ou float) val1 à comparer
    b= (int ou float) val2 à comparer
    c.u none
    >>> maximum( -2.0 , 4 )
    4
    >>> maximum( 8.0 , 4.0)
    8.0
    >>> maximum( 2 , 2)
    2
    """
    if a >= b : return a
    else : return b

def minimum ( a, b ):
    """
    nous donne la valeur minimum entre les deux entrées
    a= (int ou float) val1 à comparer
    b= (int ou float) val2 à comparer
    c.u none
    >>> minimum( -2.0 , 4 )
    -2.0
    >>> minimum( 8.0 , 4.0)
    4.0
    >>> minimum( 2 , 2)
    2
    """
    if a <= b : return a
    else : return b

def val_abs ( c ):
    """
    donne la valeur absolue de la val entrée
    c= (int ou float) val à mettre en val absolue
    C-U none
    >>> val_abs ( 2)
    2
    >>> val_abs ( -2.0)
    2.0
    >>> val_abs ( 4.0 )
    4.0
    >>> val_abs (-1)
    1
    """
    if c >= 0 : return (c)
    else : return (-1*c)

import random
def pile_ou_face():
    """
    nous donne une valeur pile ou face en sortie de façon aléatoire
    C.U none
    """
    d=random.randint(0,1)
    
    if d==0 : return ('face')
    else : return ('pile')
    
if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)

