def mon_divmod(a, b):
    """La fonction divmod() « à la main »

    :param int a: l'entier relatif à diviser
    :param int b: l'entier non nul servant de diviseur
    :CU: b doit être non nul
    :return: si b>0, le quotient et le reste dans la division euclidienne
             de a par b.

             si b<0, le reste renvoyé vérifie -b<r<=0 et le quotient q est
             toujours tel que a = bq + r.
    :rtype: un tuple de deux entiers

    Avec ces définitions, il est toujours vrai que le reste est invariant si
    l'on ajoute à a un multiple (positif ou négatif) quelconque de b. Par
    contre le reste est du même signe que b, contrairement à la définition
    mathématique usuelle qui impose un reste toujours positif ou nul, quel que
    soit le signe (non nul) de b.

    L'avantage de la définition de Python pour b<0 est que le quotient est
    déterminé par la fraction a/b, indépendamment du signe de b, en lui
    appliquant la fonction « partie entière » (math.floor() en Python).

    La procédure mon_divmod n'utilise que des additions et soustractions et ne
    tient pas compte de la remarque précédente.

    >>> mon_divmod(33, 0)
    Traceback (most recent call last):
    AssertionError: Le diviseur doit être non-nul !
    >>> mon_divmod(33, 7)
    (4, 5)
    >>> mon_divmod(-33, 7)
    (-5, 2)
    >>> mon_divmod(33, -7)
    (-5, -2)
    >>> mon_divmod(-33,-7)
    (4, -5)
    >>> mon_divmod(13891638, 317981) == divmod(13891638, 317981)
    True
    >>> mon_divmod(13891638, -317981) == divmod(13891638, -317981)
    True
    >>> mon_divmod(-13891638, 317981) == divmod(-13891638, 317981)
    True
    >>> mon_divmod(-13891638, -317981) == divmod(-13891638, -317981)
    True
    """
    assert b != 0 , "Le diviseur doit être non-nul !"
    i = 0
    temp = 0
    signa= True
    signb= True
    absa = a
    absb = b
    res= tuple()
    
    
    
    
    
    if b < 0 :
        signb = False
        
    if a < 0 :
        signa = False
       
        
    if signa == signb :
        
        while (abs(a)-temp)>= abs(b) :
            temp += abs(b)
            i +=1
        if signa == False :
            res = ( i , -(abs(a)-temp) )
        else :
            res = ( i , (abs(a)-temp) )
    else :
        if signb == False :
                       
            while abs(a) > abs(temp) :
                temp += b
                i-= 1
            res = ( i , (abs(a)-abs(temp)))
        else :
            
            while abs(a) > abs(temp) :
                temp += b
                i-= 1
            res = ( i , -(abs(a)-abs(temp)))
       
       
    return res




if __name__ == "__main__":
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE |
                    doctest.ELLIPSIS,
                    verbose=True)
