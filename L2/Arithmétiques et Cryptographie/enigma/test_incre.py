from alphabet import ALPHABETS


ALPHABET = ALPHABETS['CAPITAL_LATIN']

def compteur():
    """
    """
    
    ref=str(ALPHABET)
    cle = [ ref[0],ref[0],ref[0]]
    res=[]
    while cle[0]+cle[1]+cle[2] != ref[len(ref)-1]+ref[len(ref)-1]+ref[len(ref)-1] :
        res.append(cle[0]+cle[1]+cle[2])
        cle[2] = ref[(ref.index(cle[2])+1)%len(ref)]
        if ref.index(cle[2]) == 0 :
            cle[1] = ref[(ref.index(cle[1])+1)%len(ref)]
            if ref.index(cle[1]) == 0 and ref.index(cle[2]) == 0:
                cle[0] = ref[(ref.index(cle[0])+1)%len(ref)]
                
    res.append('ZZZ')
    return res
            
            