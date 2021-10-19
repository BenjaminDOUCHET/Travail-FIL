#include <stdlib.h>             /* pour random() */
#include <string.h>             /* pour memcmp() */
#include <assert.h>             /* pour assert() */
#include <stdio.h>
#define SIZE    1021



void mmemcpy(void *to, const void *from, unsigned int size){
    int i = 0 ;
    char *src = (char *)from;
    char *dest = (char *)to;
    for(i;i<size;i++){
        *(dest+i) = *(src+i);
    }
}

void test_mmemcpy()
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

int main()
{
    test_mmemcpy();
    char csrc[] = "jaime coder en c c est le pied";
    char cdest[100];
    mmemcpy(cdest, csrc, strlen(csrc) + 1);
    printf("la str que j'ai copié est : %s", cdest);

    int isrc[] = {10, 20, 30, 40, 50};
    int n = sizeof(isrc) / sizeof(isrc[0]);
    int idest[n], i;
    mmemcpy(idest, isrc, sizeof(isrc));
    printf("\nl'array copiée est : ");
    for (i = 0; i < n; i++)
        printf("%d ", idest[i]);

    printf("\n");
    return 0;
}