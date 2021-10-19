# ex1 - Q4 part A
def est_pair(x):
    """
    prédicat noussignal si le nombre en entrée est pair ou non
    x (int)
    CU none
    >>> est_pair(2)
    True
    >>> est_pair(3)
    False
    """
    return (x%2) == 0


# ex1 - Q4 part B
def yacoupe(a):
    """
    prédicat nous signale si l'année en input est une année de coupe du monde ou non
    a (int)
    CU none
    >>> yacoupe(2018)
    True
    >>> yacoupe(2019)
    False
    """
    return a > 1930 and est_pair(a)==True and (a%4) != 0

if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)