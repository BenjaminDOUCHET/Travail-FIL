
#ifndef LIBGA_H
#define LIBGA_H

struct ga_s {
    int val; /*la valaur de la cellule */
    struct ga_s *next; /* le pointeur vers la cellule suivante*/
};

int ga_set(struct ga_s *ga, unsigned int index, int val);
int ga_get(struct ga_s *ga, unsigned int index, int *val);

int ga_new(struct ga_s *ga);
int ga_del(struct ga_s *ga);

#endif
