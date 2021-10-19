def est_perime (j1,m1,a1,j2,m2,a2):
    """
    le predicat nous indique si le prouit avec la date en input est périmé
    j1 (int) jour actuel
    m1 (int) mois actuel
    a1 (int) annee actuelle
    j2 (int) jour date premption
    m2 (int) mois date premption <13
    a2 (int) annee date premption
    C_U tout les entrée doivent être strictement positives et les dates doivent exister
    
    >>> est_perime(9,10,2019,1,11,2000)
    True
    >>> est_perime(9,10,2019,1,11,2020)
    False
    >>> est_perime(9,10,2019,15,11,2020)
    False
    """
    if a2 > a1 : res=False
    elif m2>m1 and a2==a1 : res= False
    elif j2>=j1 and m2==m1 and a2==a1 : res= False
    else : res = True
    
    return res

if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)