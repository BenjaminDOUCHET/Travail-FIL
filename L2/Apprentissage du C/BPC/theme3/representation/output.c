/* ------------------------------
   output.c
   Écriture de données
   ------------------------------------------------------------
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../mcu/src/mcu_uniq.h"
#include "commun.h"


int main(void) {
    int i;
    int j ;
    int taille = sizeof(union bloc_u);
    char nom[] = "moran";
    char prenom[] = "bob";
    union bloc_u etudiant[NB_ETUS];
    struct etudiant_s etu[NB_ETUS];
    for (i = 0; i < NB_ETUS; i++)
    {
        etu[i].moyenne =  rand()*20;
        etu[i].numero = i+1;
        strcpy(etu[i].nom, nom);
        strcpy(etu[i].prenom, prenom);
        etudiant[i].etu = etu[i];
    }

    
    for (j = 0; i < NB_ETUS; j++){
    for (i = 0; i < taille; putchar(etudiant[j].data[i++]));
       }
    return 0;
}
