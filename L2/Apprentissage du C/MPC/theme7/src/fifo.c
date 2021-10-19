#include <stdlib.h>
#include <stdio.h>
#include "fifo.h"

struct ififo_s *ififo_new()
{
    struct ififo_s *ififo = malloc(sizeof(struct ififo_s));
    
    ififo->head = NULL;
    ififo->tail = NULL;
    
    return ififo;
}

int ififo_is_empty(struct ififo_s *f)
{
    
    int res = 0;
    if (f->head == NULL && f->tail== NULL)
    {
       
        res = 1;
    }
    return res;
}

int ififo_enqueue(struct ififo_s *f, int i)
{
    struct ififo_node_s *new_node = malloc(sizeof(struct ififo_node_s));
    new_node->value = i;
    new_node->next = NULL;
   
    if(ififo_is_empty(f)){
        f->head = new_node;
        f->tail = new_node;
    }
    else{
    
    f->tail->next = new_node;
    f->tail = new_node;
    }
    
    return new_node==NULL ? new_node :0;
}

int ififo_dequeue(struct ififo_s *f, int *i)
{
    if(ififo_is_empty(f)){
        return 0;
    }
    else{
    struct ififo_node_s *temp = f->head;
    *i = f->head->value;
    if(f->head->next == NULL){
        f->head = NULL ;
        f->tail = NULL ;
    }
    else{
    f->head = f->head->next;
    free(temp);
    return temp;
    }
    }
}

int ififo_head(const struct ififo_s *in)
{
    return in->head->value;
}

int ififo_apply(struct ififo_s *f, func_t *fn)
{
    struct ififo_node_s *temp;
    int cpt = 0;

    if(ififo_is_empty(f)){
        
        return 0;
    }
    else{
       
    temp = f->head;
    while (temp->next != NULL)
    {
        fn(temp->value);
        temp = temp->next;
        cpt++;
    }
    fn(temp->value);
    return cpt; /* renvoie le nombre d'élément sur lequel fn a été appliqué*/
    }
    
}

void ififo_del(struct ififo_s *f)
{
    struct ififo_node_s *ite = f->head;
    struct ififo_node_s *garbage = ite;

    if(f->head == NULL || f->tail== NULL ){
        free(f->head);
        free(f);
    }
    else{
    while (ite->next != NULL)
    {
        ite = ite->next;
        free(garbage);
        garbage = ite;
    }

    free(ite);
    free(f);
    }
}



void print_int(int i)
{
    printf("%d←", i);
}

void test_fifo_int()
{
    struct ififo_s *fifo;
    int i;

    fifo = ififo_new();

    ififo_enqueue(fifo, 12);   /* → 12 → */
    ififo_enqueue(fifo, 13);   /* → 13 → 12 → */

    ififo_apply(fifo, print_int); putchar('\n');

    ififo_enqueue(fifo, 14);   /* → 14 → 13 → 12 → */
    ififo_dequeue(fifo, &i);   /* 12 & → 14 → 13 → */

    printf("%d \n", i);
    ififo_apply(fifo, print_int); putchar('\n');

    ififo_dequeue(fifo, &i);   /* 13 & → 14 → */
    ififo_dequeue(fifo, &i);   /* 14 & → → */
    ififo_apply(fifo, print_int); putchar('\n');



    ififo_del(fifo);
}

int main(){

    test_fifo_int();


    return 0;
}