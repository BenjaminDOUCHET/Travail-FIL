/* ------------------------------
   input.c
   Lecture de données
   ------------------------------------------------------------
*/

#include <stdio.h>
#include <stdlib.h>

#include "commun.h"

int main(void) {
    struct etudiant_s etu[NB_ETUS];
    int i;
    int j;
    int taille = sizeof(union bloc_u);
    union bloc_u etudiant[NB_ETUS];
    for (j=0 ; j<NB_ETUS ;j++){
    for (i = 0; i < taille; etudiant[j].data[i++] = (char)getchar());
    etu[j] = etudiant[j].etu;
    printf("num:%d\tnote:%f\n",etu[j].numero,etu[j].moyenne);
    }
    return 0;
}
