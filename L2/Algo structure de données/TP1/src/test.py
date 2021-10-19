# -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for experiences assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2018, january
"""

import sys
import experience
import marker
from functools import cmp_to_key
import sorting


def compare (m1,m2):
    '''
    Compares two markers

    :param m1: A marker 
    :type m1: Marker
    :param m2: Another marker
    :type m2: Marker
    :return: -1 if *m1 < m2*, 0 if *m1* = *m2* or 1 when *m1* > *m2*
    :rtype: int
    '''
    return m1.cmp(m2)

# STRATEGY 1
def negative_markers1(markers,positive):
    """
    Computes the list of negative markers from the list of markers and
    the list of positive markers.

    :param markers: The list of markers 
    :type markers: list of str
    :param positive: The list of positive markers
    :type positive: list of str
    :return: The list of negative markers
    :rtype: list of str
    """
    negative = []
    find = False
    for mark in markers :
        i=0
        trouve = False
        
        while not(trouve) and i<len(positive) :
            global cpt
            cpt+=1
            if compare(mark,positive[i]) == 0 :
                trouve = True
            i+=1
        if not(trouve) :
            negative.append(mark)
    return negative

# STRATEGY 2
def negative_markers2(markers,positive):
    negative = []
    sort_pos = sorting.merge_sort(positive,compare)
    
    for mark in markers :
        trouve = False
        a = 0
        b = len(sort_pos)-1
        
        while a <= b and not(trouve):
            global cpt
            cpt+=1
            m = (a + b) // 2
            if compare(sort_pos[m],mark) == 0:
                trouve = True
            elif compare(sort_pos[m],mark) == -1:
                a = m + 1
            else:
                b = m - 1
    
        if not(trouve):
            negative.append(mark)
        
    return negative



# STRATEGY 3
def negative_markers3(markers,positive):
    negative = []
    sort_pos = sorting.merge_sort(positive,compare)
    sort_mark = sorting.merge_sort(markers,compare)
    i=0
    j=0
    
    while i<len(sort_mark) and j<len(sort_pos) :
        global cpt
        cpt+=1
        temp = compare(sort_mark[i],sort_pos[j])   
        if temp == 0 : 
            i+=1
            j+=1
        elif temp == 1 :
            j+=1
        else :
            negative.append(sort_mark[i])
            i+=1
    
    



    return negative+sort_mark[i:]
        
if __name__ == "__main__":
    """
    if len(sys.argv) < 3:
        print("Usage: {} <p> <m>\n\n<p>: nombre de marqueurs positifs\n<m>: nombre de marqueurs".format(sys.argv[0]))
        sys.exit(1)
    p = int(sys.argv[1])
    m = int(sys.argv[2])

    assert (m > 0), "The number of markers must be greater than 0"
    assert (p <= m), "The number of positive markers must be less or equal to the number of markers"
    
    exp = experience.Experience(p,m)
    markers = exp.get_markers()
    positive = exp.get_positive_markers()
    
    print("Markers: {}".format(markers))
    print("Positive markers: {}".format(positive))
    
    # test stategy 1
    cpt = 0                     # D'après vous à quoi peut servir cette variable ? …
    print("Negative markers: {}".format(negative_markers1(markers,positive)))
    print("Nb. comparisons: {}".format(cpt))
    
    # test stategy 2
    cpt = 0
    print("Negative markers: {}".format(negative_markers2(markers,positive)))
    print("Nb. comparisons: {}".format(cpt))
    
   
    # test stategy 3
    cpt = 0
    print("Negative markers: {}".format(negative_markers3(markers,positive)))
    print("Nb. comparisons: {}".format(cpt))
    """

    m = int(sys.argv[1])
    
    for i in range(1,m+1):
        
        cpt1=0
        cpt2=0
        cpt3=0
        cpt=0
        # 
        # on init le pire des cas strat 1
        p=i
        exp = experience.Experience(p,i)
        markers = exp.get_markers()
        positive = exp.get_positive_markers()
        negative_markers1(markers,positive)
        cpt1 = cpt
        cpt=0
        negative_markers2(markers,positive)
        cpt2=cpt
        cpt=0
        
        negative_markers3(markers,positive)
        
        cpt3 = cpt
        print(i ," ",len(positive)," ",cpt1," ",cpt2," ",cpt3 )
    
