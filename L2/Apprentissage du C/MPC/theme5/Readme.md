_thème 5_ — Arithmétique des pointeurs
======================================

> [Université de Lille](https://www.univ-lille.fr/)  
> [Licence d'informatique, 2e année](https://portail.fil.univ-lille1.fr/ls4)  
> [Module de MPC — Maîtrise de la Programmation en C](https://portail.fil.univ-lille1.fr/ls4/mpc)  
> Équipe pédagogique de MPC, d'après un document CC BY-SA de Gilles
    Grimaud Philippe Marquet, 2018-2020.  
> mars 2021  
> [CC BY-SA](https://creativecommons.org/licenses/by-sa/4.0/)

Une version PDF pour impression est accessible sur [nextcloud.univ-lille.fr](https://nextcloud.univ-lille.fr/index.php/s/zrWxCeBefzewJWH)

Ce document est le support d'exercices de TD et TP.

Le thème 5 traite de l'arithmétique des pointeurs, de l'équivalence
tableaux/pointeurs, de la possible généricité des pointeurs `void *`,
et enfin des pointeurs de fonctions.

→ Adresses et arithmétique de pointeurs
---------------------------------------

### Adresses mémoires des types construits — _exercice de TD_ ###

Soit le programme `tab_duo_trio.c` suivant

```c
 #include <stdlib.h>
 #include <stdio.h>
 
 struct duo_s {
     int x;
     int y;
 };
 
 union trio_u {
     int n;
     char c;
     float x;
 };
 
 int
 main()
 {
     int tab[10];
     struct duo_s duo;
     union trio_u trio;
 
     printf("sizeof(int) : %lu\n", sizeof(int));
     printf("tab :\t%p\n", tab);
     printf("&duo :\t%p\n", &duo);
     printf("&trio :\t%p\n", &trio);
 
     exit(EXIT_SUCCESS);
 }
```

dont une exécution produit :

```console
% ./tab_duo_trio
sizeof(int) : 4
tab :   0x7ffeebe6a6d0
&duo :  0x7ffeebe6a6c8
&trio : 0x7ffeebe6a6c0
```

1. Quelle est l'adresse du champ `duo.x` ? `duo.y` ?

1. Quelle est l'adresse du champ `trio.n` ? `trio.c` ? `trio.x` ?

1. Quelle est l'adresse de l'élément `tab[5]` du tableau ?   
   De manière générale, quelle est l'adresse de l'élément `tab[i]` ? 

1. Soit la déclaration et initialisation :

    ```c
    int *ptr;
    ptr = tab;
    ```

    En utilisant uniquement la variable `ptr`, et l'arithmétique des
    pointeurs, proposez une boucle qui va écrire la valeur `0` dans
    toutes les cases du tableau. 

### Pointeurs et chaînes de caractères — _exercice de TD_ ###

1. Écrire une fonction `char *strend(char *str)` qui renvoie
   l'adresse du zéro terminal de la chaine `str`.

1. (Pourquoi le prototype de cette fonction ne peut-il être
   `char *strend(const char *str)` ?) 

1. En utilisant la fonction `strend()`, proposez une fonction qui
   renvoie le nombre de caractères d'une chaîne donnée - le caractère
   `'\0'` final non compris : 

    ```c
    int mstrlen(const char *str);
    ```

    _Pour information_. Cette fonction `mstrlen()` est similaire à la
    fonction `strlen()` fournie par la bibliothèque standard
    `string.h`.

1. La bibliothèque `string.h` fournie également les fonctions suivantes :

    ```c
    /* recopie le contenu de src dans dest 
       renvoie dest */
    char *strcpy(char *dest, const char *src); 
    
    /* recopie src à la fin de dest (concat) 
       renvoie dest */
    char *strcat(char *dest, const char *src);
    ```

    Proposez des fonctions `mstrcpy()` et `mstrcat()`, réécritures de
    ces fonctions. 

### Autour des variables d'environnement – _exercice de TP_ ###

La variable globale

```c
extern char **environ;
```

est un pointeur sur le premier élément d'un tableau.  
Chacun des éléments de ce tableau est une chaîne de caractères, donc
un pointeur `char *`.  
Une valeur `(char *) 0` indique la fin du tableau.

Chacune des chaînes est de la forme `"VAR=valeur"`, `VAR` correspondant
à une des variables d'environnement. Cette variable `environ` est par
exemple exploitée par la commande Unix `printenv` qui affiche
l'ensemble des variables d'environnement et leur valeur :

```console
% printenv | head
SHELL=/bin/bash
LANGUAGE=en_US:
PWD=/home/l2/duchmol
LOGNAME=duchmol
HOME=/home/l2/duchmol
LANG=en_US.UTF-8
TERM=xterm-256color
USER=duchmol
PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
SSH_TTY=/dev/pts/0
```

1. Proposez une fonction `nvar()` qui exploite cette variable
   `environ` et renvoie le nombre de variables d'environnement
   définies.

    Proposez un programme qui fait appel à cette fonction et affiche
    ce nombre de variables. 

    On pourra comparer le résultat avec celui fourni par la commande 

    ```console
    % printenv | wc -l
    ```

1. Proposez une commande `mprintenv` qui reproduit le comportement de
   `printenv`.

1. La commande `printenv` admet des paramètres qu'elle considère comme
   des noms de variables d'environnement donc elle affiche la valeur :
   
    ```console
    % printenv USER SHELL
    duchmol
    /bin/bash
    ```

    Proposez une nouvelle version de votre commande `mprintenv` pour
    inclure cette fonctionnalité.

### Nouvelle recherche dichotomique — _exercice de TP_ ###

1. Proposez une fonction récursive qui recherche par dichotomie une
   valeur `v` dans un tableau trié `tab` : 

    ```c
    float * search_interval(float v, const float *tab, const float *end);
    ```

    L'argument `end` pointe sur le dernier élément du tableau.

1. On pourra reprendre le programme principal utilisé pour la fonction
   `search_dicho()` du TP précédent, _thème 4_ pour valider cette
   nouvelle fonction de recherche.

→ Pointeurs génériques `void *`
-------------------------------

### Mise à zéro — _exercice de TD_ ###

1. Proposez une fonction "générique" qui prend l'adresse d'un entier de
   type non spécifié, ainsi que sa taille, et met cet entier à zéro :

   ```c
   void memzero((void *addr, unsigned int size);
   ```

   Exemples d'utilisations de la fonction :

   ```c
   int a;
   short int b;
   memzero(&a, sizeof(int));            /* équivalent à a = 0 */
   memzero(&b, sizeof(short int));      /* équivalent à b = 0 */
   ```

1. Cette fonction peut-elle être utilisée pour mettre à zéro
   l'ensemble des valeurs d'un tableau, par exemple :

   ```c
   #define MAX    128
   int t[MAX];
   ```

_Pour information._ La bibliothèque `string.h` propose une fonction
`memset()` qui est généralement utilisée pour mettre à zéro une zone
mémoire donnée. 

### Comparaison générique — _exercice de TD_ ###

L'objet de l'exercice est de proposer une fonction `mmemcmp()` qui
compare deux zones mémoire octet par octet. 

1. Donnez un prototype possible pour cette fonction. 

1. Donnez une définition de cette fonction.  
   La fonction renverra une valeur nulle si et seulement si les deux
   zones sont égales.

_Pour information._ La bibliothèque `string.h` propose une fonction
`memcmp()` qui réalise une telle comparaison.

### Copie générique — _exercice de TP_ ###

1. Proposez une fonction qui copie un objet d'adresse `from`, de type
   non spécifié, et de taille `size`, à l'adresse `to` :

   ```c
   void mmemcpy(void *to, const void *from, unsigned int size);
   ```
   
2. Testez votre proposition, par exemple avec le code suivant

   ```c
   #include <stdlib.h>             /* pour random() */
   #include <string.h>             /* pour memcmp() */
   #include <assert.h>             /* pour assert() */
   
   #define SIZE    1021
   
   void
   test_mmemcpy()
   {
       char     tc_orig[SIZE], tc_dest[SIZE];
       long int ti_orig[SIZE], ti_dest[SIZE];
       int i;
   
       /* initialisation */
       for(i=0 ; i<SIZE ; i++) {
           tc_orig[i] = random() % 256;
           tc_dest[i] = random() % 256;
           ti_orig[i] = random(); 
           ti_dest[i] = random();
       }
   
       /* copie */
       mmemcpy(tc_dest, tc_orig, SIZE);
       mmemcpy(ti_dest, ti_orig, SIZE * sizeof(long int));
   
       /* vérification */
       assert(memcmp(tc_orig, tc_dest, SIZE) == 0); 
       assert(memcmp(ti_orig, ti_dest, SIZE * sizeof(long int)) == 0);
   }
   ```

_Pour information._ La bibliothèque `string.h` propose une fonction
`memcpy()` qui réalise une telle copie.

### Échange générique — _exercice de TP_ ###

1. Proposez une fonction `memswap()` qui réalise un échange générique
   entre deux variables de même taille.  
   Dans un premier temps, on pourra supposer que les deux objets ne se
   recouvrent pas en mémoire. 

2. Testez votre proposition avec une fonction semblable à celle
   proposée pour l'exercice précédent.

→ Pointeurs de fonction
-----------------------

_à venir..._

<!-- eof --> 
