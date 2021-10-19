#ifndef _MCU_UNIQ_H_
#define _MCU_UNIQ_H_

#include "mcu_macros.h"

/* Lit une ligne sur l'entrée standard - via getchar() ou fgets().
   Lit au plus MAXLINE-1 caractères.
   Les caractères lus sont renvoyés dans le paramètre line,
     y compris un '\0' final.
   Le tableau line est assez grand pour contenir MAXLINE caractères.
   Renvoie
   - le nombre de caractères lus
   - EOF si la fin de fichier est atteinte
   Termine sur une erreur fatale, en utilisant fatal(), si la ligne
     contient plus de MAXLINE caractères. 
 */
extern int comparer(char chaine1[] ,char chaine2[]);
extern int copier(char chaine1[] ,char chaine2[]);
#endif