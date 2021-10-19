# COLLE MAXIME
# DOUCHET BENJAMIN

#Ex 2
# Q1
# dans le cas où le compteur démarre à 0 , le compteur doit finir a 0 ET ne jamais passer dans le négatif
# "(+1 (+1 )-1 (+1 )-1 )-1",  "(()())" => 1,2,1,2,1,0 donc ici valide car fini à 0 et n'est jamais passé en neg.
# "(+1 (+1 )-1  (+1 )-1" => 1,2,1,2,1 donc faux car la dernière valeurs n'est pas 0
# "(+1 (+1 )-1 )-1 )-1 (+1 " => 1,2,1,0,-1,0 faux car le compteur est passé en négatif.

#Q2
def bien_parenthesee(s) :
    """
    prédicat qui renvoie la valeur booléenne True si la chaîne s passée en paramètre
    est bien parenthésée, et la valeur booléenne False dans le cas contraire
    a (str) chaine de parenthèse
    C.U : la str en input doit etre une chaine de parenthèses
True
>>> bien_parenthesee("(()()")
False
>>> bien_parenthesee("(()))(")
False
    
    """
    temp = 0

    for c in s :
        if c == '(' and temp >= 0:
            temp = temp + 1
        elif c == ')' and temp >= 0:
            temp = temp - 1
    return temp == 0

#Q3

def nbre_facteurs(s) :
    """
    fonction nous renvoyant le nombre de facteur de parenthèse dans la str s
    s (str) chaine de parenthèse valide
    C.U insérer une str de parenthèse valide
>>> nbre_facteurs("()(()())")
2
>>> nbre_facteurs("(())()(()())")
3
    """
    ouv = 0
    ferm = 0
    temp = 0
    
    for c in s :
        if c == '(' :
            ouv = ouv +1
        else :
            ferm = ferm +1
        if ouv == ferm :
            temp = temp + 1
    return temp 
        
# Q4

def affiche_facteurs(s) :
    """
    fonction nous renvoyant les facteurs (str) de la str d'entrée
    s ( str ) chaine de parenthèse verifiée
    C.U none
>>> affiche_facteurs('(()())')
'(()())'
>>> affiche_facteurs('()(()())')
'()*(()())'
>>> affiche_facteurs('(())()(()())')
'(())*()*(()())'
    """
    ouv = 0
    ferm = 0
    temp = ""
    res =""
    
    for c in s :
        if c == '(' :
            ouv = ouv +1
        else :
            ferm = ferm +1
        temp = temp + c
        if ouv == ferm :
            res = res + temp
            ouv = 0
            ferm = 0
            temp = "*"
    return res 
        
        
        
        


if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)