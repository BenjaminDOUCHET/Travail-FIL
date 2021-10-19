#include <stdlib.h>
#include <stdio.h>
#include "gfifo.h"

struct gfifo_s *gfifo_new()
{
    struct gfifo_s *gfifo = malloc(sizeof(struct gfifo_s));
    
    gfifo->head = NULL;
    gfifo->tail = NULL;
    
    return gfifo;
}

int gfifo_del(struct gfifo_s *f)
{
    struct gfifo_node_s *ite = f->head;
    struct gfifo_node_s *garbage = ite;

    if(f->head == NULL || f->tail== NULL ){
        free(f->head);
        free(f);
    }
    else{
    while (ite->next != NULL)
    {
        ite = ite->next;
        free(garbage->value);
        free(garbage);
        garbage = ite;
    }

    free(ite);
    free(f);
    }
}

int gfifo_size(struct gfifo_s *f){
    int i = 0;
    struct gfifo_node_s *pointeur = f;
    while(pointeur->next != NULL){
        pointeur = pointeur->next;
        i++;
    }
    return i ;
};

int gfifo_enqueue(struct gfifo_s *f, void *p){

    struct gfifo_node_s *newNode = malloc(sizeof(struct gfifo_node_s));
    newNode->value = p;


    if(f->head ==NULL || f->tail == NULL){
        f->head = newNode;
        f->tail = newNode;

    }
    else{
    f->tail->next = newNode;
    f->tail = newNode;
    }

    return newNode==NULL ? newNode :0;
}


int gfifo_dequeue(struct gfifo_s *f, void **p)
{
    
    if(f->head ==NULL || f->tail == NULL){
        return 0;
    }
    else{
    struct gfifo_node_s *temp = f->head;
    p = &f->head->value;
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

int gfifo_apply(struct gfifo_s *f, gfunc_t *fn)
{
    struct gfifo_node_s *temp;
    int cpt = 0;

    if(f->head ==NULL || f->tail == NULL){
        
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





int gfifo_is_empty(struct gfifo_s *f)
{
    int res = 0;
    if (f->head == NULL && f->tail== NULL)
    {
       
        res = 1;
    }
    return res;
}




