#include <stdio.h>
#include <stdlib.h>
#include "libga.h"

int
ga_set(struct ga_s *ga, unsigned int index, int val)
{
    int i = 0 ;
    struct ga_s *pointeur = ga;
    while(i<index){
        pointeur = pointeur->next;
    }
    pointeur->val = val;
    return pointeur->val == val;
}

int
ga_get(struct ga_s *ga, unsigned int index, int *val)
{
    int i = 0 ;
    struct ga_s *pointeur = ga;
    while(i<index){
        pointeur = pointeur->next;
    }
    *val = pointeur->val;
    return *val == NULL ;
}

int 
ga_new(struct ga_s *ga)
{
    struct ga_s *newCell = malloc(sizeof(struct ga_s));
    struct ga_s *pointeur = ga;
    while(pointeur->next != NULL){
        pointeur = pointeur->next;
    }
    pointeur->next = newCell;
    return -1;
}

int
ga_del(struct ga_s *ga)
{
    struct ga_s *pointeur;
    while(ga != NULL){
        pointeur = ga;
        while(pointeur->next != NULL){
            pointeur = pointeur->next;
        }
        free(pointeur);
    }
    return -1;
}

