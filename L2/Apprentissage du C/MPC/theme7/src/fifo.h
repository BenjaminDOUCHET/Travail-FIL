#ifndef FIFO_H
#define FIFO_H


/**
 * A structure to  define a cell of a simple linked array
 */
struct ififo_node_s{
    int value; /* the value in the cell */ 
    struct ififo_node_s *next; /*the next cell of the array*/
};

/**
 *A structure to represent a linked list (fifo)  
 */
struct ififo_s{
    struct ififo_node_s *head; /*a pointer to the head of the list */
    struct ififo_node_s *tail; /*a pointer to the tail of the list */
};

/* une file vide aura donc ses pointeur pointant vers null */

/**
 * Create an empty ififo
 * 
 * @return a ififo *
 */
struct ififo_s *ififo_new();


struct ififo_node_s *ififo_node_new();


int ififo_enqueue(struct ififo_s *f, int i);

int ififo_dequeue(struct ififo_s *, int *);

typedef void (func_t)(int);

#endif



