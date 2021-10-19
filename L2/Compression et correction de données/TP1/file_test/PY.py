# -*- coding: utf-8 -*-

from hash_functions import HashFunctions
from bloomfilter import BloomFilter
from test import random_word

def analyse_faux_pos():
    """
    test procedure to test the efficiency of bloom filter in function of 
    the number of hashfunction and the size of the filter.
    """
    
    s_word = set()
    while len(s_word)<2**10 :
        s_word.add(random_word())
    

    for i in range(1,9):
        for t in range(10,21):
            hashes = HashFunctions(i)
            bf = BloomFilter(t, hashes)
            for w in s_word :
                bf.add(w)
            teste = 0
            f_pos = 0
            for k in range(1,2**14+1) :
                r_word = random_word()
                if not(r_word in s_word) : 
                    teste +=1
                    if bf.contains(r_word) :
                        f_pos+=1
            print(t , i , teste , f_pos , f_pos/teste) # a vérifier le taux
        print("\n")
        



if __name__ == "__main__":
    analyse_faux_pos()