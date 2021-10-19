# -*- coding: utf-8 -*-

""":mod:`listiterator` module : list implementation with iterator interaction

Provides constructor, selectors and modifiers for mutable lists.
Lists of this module must be traversed via iterators. 

An iterator for lists allows the programmer to traverse the list in
either direction and adding elements to the list during iteration.  

An iterator has no current element; its cursor position always lies
between the element that would be returned by a call to :code:`previous` and
the element that would be returned by a call to `next`. 

An iterator for a list of length n has n+1 possible cursor positions,
as illustrated by the carets (^) below:

.. code::

                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
 cursor positions:  ^            ^            ^            ^                  ^

:author: `FIL - FST - Univ. Lille <http://portail.fil.univ-lille1.fr>`_

:date: 2021, february

"""

class EmptyList (Exception):
    """
    Exception for empty lists
    """
    def __init__ (self,msg):
        self.message = msg

class NoSuchElementException (Exception):
    """
    Exception for iterators not positionned
    """
    def __init__ (self,msg):
        self.message = msg

            
class List:
    '''
    Double-linked lists
    '''
    
    class Cell:
        '''
        Double-linked cells
        '''
        
        def __init__(self, value, next_cell, prev_cell):
            '''
            Creates a new cell with the specified values, and the links
            to the next and previous cells (if any).

            :param value: A value
            :type value: Any
            :param next_cell: The successor of this cell, if any or None otherwise
            :type next_cell: Cell
            :param prev_cell: The predecessor of this cell, if any or None otherwise
            :type prev_cell: Cell
            '''
            self.value = value
            self.next = next_cell
            self.prev = prev_cell

        def __print_without_iterator_forward (self):
            """
            Print all the list from the cell until the end
            """
            print(self.value, end=' ')
            if self.next != None:
                self.next.__print_without_iterator_forward ()
            else:
                print()

        def __print_without_iterator_reversed (self):
            """
            Print all the list from the cell back to the beginning of the list
            """
            print(self.value, end=' ')
            if self.prev != None:
                self.prev.__print_without_iterator_reversed ()
            else:
                print()
           

    def __init__ (self):
        """
        Creates a new empty list.
        """    
        self.head = None
        self.tail = None
    

    def is_empty (self):
        """
        Returns True if the list is empty, False otherwise.
        
        :rtype: boolean
        """
        return self.head == None and self.tail == None

    def cons (self, value):
        """
        Add the value :code:`value` at the begining of the list
        
        :param value: The value to be added.
        :type value: Any

        UC: not compatible with iterators
        """
        if self.head == None:
            self.head = self.tail = List.Cell(value, None, None)
        else:
            self.head = List.Cell(value, self.head, None)
            self.head.next.prev = self.head



    def print (self,reverse=False):
        """
        :param reverse: True if the the list *l* must be printed from the end to the beginning
        :type reverse: boolean
        """
        if self.is_empty():
            raise EmptyList("The list has no elements")
        if reverse:
            self.tail._Cell__print_without_iterator_reversed()
        else:
            self.head._Cell__print_without_iterator_forward()


    def get_listiterator (self, reverse=False):
        """
        Creates a new iterator for the list
        :return: An iterator at the beginning of the list
        :rtype: ListIterator
        """
        return List.ListIterator(self,reverse)


    class ListIterator:
        '''
        Iterator over double-linked lists
        '''
        
        def __init__(self, list , reverse=False):
            '''
            Builds a ListIterator on the provided list.
            The iterator is at the beginning of the list.

            :param list: The list to iterate on
            :type list:List
            '''
            self.list = list
            if not(reverse):
                self.current = list.head
            else :
                self.current = list.tail            
            
            
                
        def hasNext (self):
            """
            Returns :code:`True` if this list iterator has more elements when
            traversing the list in the forward direction. (In other words,
            returns :code:`True` if :code:`self.next()` would return an element rather than
            throwing an exception.)
            
            :rtype: boolean
            """
            return self.current.next != None


        def next (self):
            """
            Returns the next element in the list and advances the cursor
            position. This method may be called repeatedly to iterate through
            the list, or intermixed with calls to :code:`self.previous()` to go back and
            forth. (Note that alternating calls to next and previous will
            return the same element repeatedly.)

            Throws NoSuchElementException if there is no such element.

            :rtype: Type of the elements of the list
            """
            if self.hasNext() :
                self.current = self.current.next
                return self.current.value
            else :
                raise NoSuchElementException('there is no next item')


        def hasPrevious (self):
            """
            Returns :code:`True` if this list iterator has more elements when
            traversing the list in the reverse direction. (In other words,
            returns :code:`True` if :code:`self.previous()` would return an
            element rather than throwing an exception.)
            
            :rtype: boolean
            """
            return self.current.prev != None

        def previous (self):
            """
            Returns the previous element in the list and moves the cursor
            position backwards. This method may be called repeatedly to
            iterate through the list backwards, or intermixed with calls to
            :code:`self.next()` to go back and forth. (Note that alternating 
            calls to next and previous will return the same element repeatedly.)
            
            Throws NoSuchElementException if there is no such element.
            
            :rtype: Type of the elements of the list
            """
            if self.hasPrevious() :
                self.current = self.current.prev
                return self.current.value
            else :
                raise NoSuchElementException('there is no previous item')

        
        def add (self,value,before=True):
            """Inserts the specified element into the list. The element is
            inserted immediately before the element that would be returned by
            :code:`next()`, if any, and after the element that would be returned by
            :code:`previous()`, if any. (If the list contains no elements, the new
            element becomes the sole element on the list.) The new element is
            inserted before the implicit cursor: a subsequent call to :code:`next()`
            would be unaffected, and a subsequent call to :code:`previous()` would
            return the new element.
            add an option to insert after the current pointer 
            :param before: boolean True if insert nis wished before False if it is after
            :param value: The element
            :type value: Any
            """
            if self.current==None :
                self.list.cons(value)
            else :
                if self.hasPrevious():
                    
                    if before :
                        new_cell = List.Cell(value, self.current, self.current.prev)
                        self.current.prev.next = new_cell
                        self.current.prev = new_cell
                    else : 
                        if self.hasNext() :
                            new_cell = List.Cell(value, self.current.next , self.current)
                            self.current.next.prev = new_cell
                            self.current.next = new_cell
                        else :
                            new_cell = List.Cell(value, None , self.current)
                            self.list.tail = new_cell
                            self.current.next = new_cell
                            self.next()

                else :
                    new_cell = List.Cell(value,self.current,None )
                    self.list.head = new_cell
                    self.current.prev = new_cell

       


        def remove (self):
            """Removes from the list the last element that was returned by
            :code:`current`.
            and move the iterator to the element returned by next() if it exist ,
            by previous if not
            
            """
            
            if self.hasPrevious() : 
                if self.hasNext():
                    self.current.next.prev = self.current.prev.next
                    self.current.prev.next = self.current.next.prev
                    self.current = self.current.next
                else :
                    self.current.prev.next=None
                    self.list.tail = self.current.prev
                    self.current = self.current.prev
            elif self.hasNext() :
                self.current.next.prev = None
                self.list.head = self.current.next
                self.current = self.current.next
            else : 
                self.current = None