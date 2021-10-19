def est_rectangle(a,b,c,e):
    """
    predicat nous stipulant si un triangle est rectangle ou non
    a (int ou float) longueur du 1er côté
    b (int ou float) longueur du second côté
    c (int ou float) longueur du 3eme côté
    e (int ou float) la marge d'erreur autorisé
    CU a,b,c,e nombres positif et si possible mettre en c la plus grande valeurs (qui correspondrait à l'hypothénuse)
    >>> est_rectangle(3,4,5,0)
    True
    >>> est_rectangle(1,2,3,1)
    False
    """
    return (a**2+b**2-e) <= c**2 and (a**2+b**2+e) >= c**2

if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)