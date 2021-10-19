# -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for quicksort assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january
"""

import sorting
import generate
import copy
from element import Element

global cpt

def cmp(a,b):
    """
    A comparison function

    :param a: First element    
    :param b: Second element
    :return: 0 if a == b, 1 if a > b, -1 if a < b
    :rtype: int

    >>> from element import Element
    >>> cpt = 0
    >>> cmp(Element(10),Element(5))
    1
    >>> cmp(Element(5),Element(5))
    0
    >>> cmp(Element(5),Element(10))
    -1
    """
    global cpt
    cpt = cpt + 1
    return Element.cmp(a,b)

if __name__ == "__main__":
    tot1 = 0
    tot2= 0
    tot3 = 0
    tot4 = 0
    cpt = 0
    import doctest
    from random import randint
    doctest.testmod()
    for i in range(1,101):
        for j in range(1,101):
            # merge sort
            cpt = 0 #raz cpt
            t = generate.increasing_array(i)
            tt = sorting.merge_sort(t,cmp)
        
            if generate.is_sorted (tt):
                cpt1 = cpt
            else:
                raise Exception("Array has not been correctly sorted by merge sort")
            
            # random quick        
            cpt = 0 #raz cpt
            t2 = copy.deepcopy(t)
            t3 = copy.deepcopy(t)
            from sorting import random_pivot
            from sorting import naive_pivot
            from sorting import opti_pivot
            sorting.quicksort(t2,cmp,random_pivot)
            if generate.is_sorted (t2):
                cpt2 = cpt 
            else:
                raise Exception("Array has not been correctly sorted by quicksort")
            
            # naive quick
            cpt = 0 #raz cpt
            sorting.quicksort(t3,cmp,naive_pivot)
            if generate.is_sorted (t3):
                cpt3 = cpt 
            else:
                raise Exception("Array has not been correctly sorted by quicksort")
            
            # opti quick
            cpt = 0 #raz cpt
            sorting.quicksort(t3,cmp,opti_pivot)
            if generate.is_sorted (t3):
                cpt4 = cpt 
            else:
                raise Exception("Array has not been correctly sorted by quicksort")
            tot1 += cpt1
            tot2 += cpt2
            tot3 += cpt3
            tot4 += cpt4
        print(tot1/100 ,tot2/100 ,tot3/100 ,tot4/100 )
