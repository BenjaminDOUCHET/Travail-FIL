# -*- coding: utf-8 -*-

from listiterator import List, NoSuchElementException
import time

def print_with_iterator (l):
    """
    Print elements of a list using an iterator.
    
    :param l: The list to be printed
    :type l: dict
    """
    iterator = List.ListIterator(l)
    fin = False
    res =''
    while not(fin):
        res+=str(iterator.current.value)+' '
        if iterator.hasNext() :
            iterator.next()
        else : 
           fin = True
    print(res)



def print_with_iterator_reverse (l):
    """
    Print elements of a list using an iterator in reverse order.
    
    :param l: The list to be printed
    :type l: dict
    """



    #première version du reverse (pré iterateur queue)
    iterator = List.ListIterator(l)
    while iterator.hasNext() :
        iterator.next()
    fin = False   
    res =''
    while not(fin):
        res+=str(iterator.current.value)+' '
        
        if iterator.hasPrevious() :
            iterator.previous()
        else : 
           fin = True
    print(res)
    
    






def print_with_iterator_reverse_bis (l):
    """
    Print elements of a list using an iterator in reverse order.
    
    :param l: The list to be printed
    :type l: dict
    """
    iterator = List.ListIterator(l,True)
    
    fin = False   
    res =''
    while not(fin):
        res+=str(iterator.current.value)+' '
        
        if iterator.hasPrevious() :
            iterator.previous()
        else : 
           fin = True
    print(res)

def ordered_insert (l, value):
    """
    Add *value* to list *l* such that *l* is kept ordered.
    
    :param l: An ordered list.
    :type l: List
    :param value: The value to be inserted.
    :type value: same as elements of *l*
    """
    iterator = List.ListIterator(l)
    fin = False  
    while not fin and value > iterator.current.value:
        if iterator.hasNext():
            iterator.next()
        else :
            fin = True
    iterator.add(value,False)


def get (l, i):
    """
    Get the i-th element of *l*. Raise Exception if *i* is not valid.
    With i=0, we get the head of the list

    :param l: A list.
    :type l: List
    :return: the i-th element    
    :rtype: Type of the elements of the list

    Throws NoSuchElementException if *i* is out of bounds.
    """
    if i < 0 :
        raise NoSuchElementException('not a valid index')
    iterator = List.ListIterator(l)
    j=0
    while j < i :
        if iterator.hasNext() :
            iterator.next()
        else :
            NoSuchElementException('not a valid index')
        j+=1
    return iterator.current.value




if __name__ == "__main__":
    l = List()
    for i in reversed(range(1,5)):
        l.cons(i)
        
    l.print();

    # test 0 : impression renversee
    l.print(reverse=True)

    # test 1 : impression avec iterateurs
    print ('--- test 1 ---')
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 2 : verification des exceptions
    print ('--- test 2 ---')
    try:
        it = l.get_listiterator()
        while True:
            it.next()
    except NoSuchElementException:
        print("Exception levee avec next")
    try:
        it = l.get_listiterator()
        while True:
            it.previous()
    except NoSuchElementException:
        print("Exception levee avec previous")
        

    # test 3 : insertion avant le 3eme element
    print ('--- test 3 ---')
    it = l.get_listiterator()
    print(it.next())
    print(it.next())
    it.add(23)
    assert(it.previous()==23)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 4 : insertion apres le dernier element
    print ('--- test 4 ---')
    it = l.get_listiterator ()
    while (it.hasNext()):
        it.next()
    it.add(45)
    assert(it.previous() == 45)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 5 : insertion avant le premier element
    print ('--- test 5 ---')
    it = l.get_listiterator ()
    it.add(0)
    assert(it.previous() == 0)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 6 : insertion avant le dernier element avec l'iterateur placé en fin
    print ('--- test 6 ---')
    it = l.get_listiterator (True)
    
    #it.previous()
    it.add(445)
    assert(it.previous() == 445)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
#
    # test 7 : affichage à l'envers avec l'itérateur placé en fin
    print ('--- test 7 ---')
    print_with_iterator_reverse_bis(l)
    
    # test 8 : ajout après le dernier élément
    print ('--- test 8 ---')
    it = l.get_listiterator (True)
    it.add(5)
    assert(it.previous() == 5)
    print_with_iterator(l)
    print_with_iterator_reverse(l)
#        
    # test 9 : inserer trié, à vous d'écrire ce test
    print ('--- test 9 ---')
    l2 = List()
    for i in reversed(range(1,9)):
        l2.cons(i)
    print_with_iterator(l2)
    ordered_insert (l2, 5)
    print_with_iterator(l2)


    # test 10 : suppression en tete
    print ('--- test 10 ---')
    l3 = List()
    
    for i in reversed(range(1,9)):
        l3.cons(i)
    
    it3 = l3.get_listiterator()
    print_with_iterator(l3)
    it3.remove()
    print_with_iterator(l3)


    # test 11 : suppression en queue
    print ('--- test 11 ---')
    it4 = l3.get_listiterator (True)
    print_with_iterator(l3)
    it4.remove()
    print_with_iterator(l3)


    # test 12 : (non-)efficacite de get
    print ('--- test 12 ---')
    print ('voir resultats dans res_get_ite.dat')
    mon_fich=open("res_get_ite.dat","w")
    for i in range (1,11):
        length = 100*i
        ll = List()
        for j in range(1,length):
            ll.cons(j)
        # test par get :
        top_start = time.process_time()
        for k in range(1,length) :
            get(l,k)
        top_end = time.process_time()
        res_get = top_end - top_start

        #test par itérateur :
        top_start = time.process_time()
        iterator = ll.get_listiterator ()
        k=0
        while iterator.hasNext() and k < length:
            res = iterator.current.value
            iterator.next()
            k+=1
        top_end = time.process_time()
        res_ite = top_end - top_start
        mon_fich.write("%s %s \n" %(res_get,res_ite))
        
    mon_fich.close()