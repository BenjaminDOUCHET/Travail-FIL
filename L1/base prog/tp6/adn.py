# COLLE MAXIME
# DOUCHET BENJAMIN

#EX 1
#Q1

def estADN(a):
    """
    le prédicat verifie si la str en entrée corresponds à une séquence adn ou non
    a (str) chaine à analyser
    C.U none
>>> estADN("AGTCTGC")
True
>>> estADN("AGTCTUC")
False
>>> estADN("")
True
    """
    res = True
    for c in a :
        if c != "C" and c != "A" and c != "T" and c != "G":
            return False
        
    return res

#Q2

def transcrit(s) :
    """
    transcrire la chaine ADN en ARN
    s (str) chaine ADN a transcrire
    C.U NONE
>>> transcrit('ACGGTAGCTAGTTTCGACTGGAGGGGTA')
'ACGGUAGCUAGUUUCGACUGGAGGGGUA'
    """
    temp = ""

    for c in s :
        if c == 'T' :
            temp = temp + 'U'
        else :
            temp = temp + c
    return temp

#Q3

def baseComplementaire(s) :
    """
    nous donne la base complementaire de la str en entrée
    s  (str) chaine adn à modifier
    C.U : s et une base ADN ( verifer avec le prédicat estADN)
>>> baseComplementaire('ACGGTAGCTAGTTTCGACTGGAGGGGTA')
'TGCCATCGATCAAAGCTGACCTCCCCAT'
    """
    temp = ""

    for c in s :
        if c == "T" :
            temp = temp + "A"
        elif c == "A" :
            temp = temp + "T"
        elif c == "G" :
            temp = temp + "C"
        else :
            temp = temp + "G"
    
    return temp

#Q4

def sequenceComplementaireInversee(s):
    """
    renvoie la séquence ADN complementaire inversée
    s ( str ) séquence à traiter
    C.U : s et une base ADN ( verifer avec le prédicat est ADN)
>>> sequenceComplementaireInversee('ACTG')
'CAGT'
    """
    
    res = ""
    temp = baseComplementaire(s)
    
    for c in temp :
        res = c + res
    
    return res

# Q5
def nombreOccurrencesCodon(codon,adn) :
    """
    fonction donne le nombre de codon dans l'adn en variable
    codon (str) le codon à chercher
    adn (str) la chaine ADN dans laquelle rechercher le codon
    C.U :  adn  est un multiple de 3 caractères et adn est une base ADN ( verifer avec le prédicat est ADN)
>>> nombreOccurrencesCodon('ACG','GCUACGGAGCUUCGGAGCACGUAG')
2
>>> nombreOccurrencesCodon('UUC', 'AGUUCGACU')
0 
    """
    temp = 0
    for i in range(0, len(adn)-3 , 3) :
        if adn[i:i+3] == codon :
            temp = temp + 1
    return temp

# Q6

# début programme

adn = str(input("entrez une séquence ADN : "))
codon = str(input("entrez un codon : "))

if estADN(adn) :
    arn = transcrit(adn)
    print("Séquence complémentaire-inversée :" , sequenceComplementaireInversee(adn) , "\nSéquence ARN :" , arn , "\n Le codon" , codon , "apparait" , nombreOccurrencesCodon(codon,arn) , "fois dans la séquence ARN")
else :
    print("Séquence ADN erronée !")
 
 
if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose = True)
 
 
 