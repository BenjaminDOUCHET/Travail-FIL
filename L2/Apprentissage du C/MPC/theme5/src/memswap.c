#include <stdlib.h>             /* pour random() */
#include <string.h>             /* pour memcmp() */
#include <assert.h>             /* pour assert() */
#include <stdio.h>
#define SIZE    1021



void memswap(void *to, const void *from, unsigned int size){
    int i = 0 ;
    char temp;
    char *src = (char *)from;
    char *dest = (char *)to;
    for(i;i<size;i++){
        temp = *(dest+i);
        *(dest+i) = *(src+i);
        *(src+i) = temp;
    }
}

void test_memswap()
{
    
    char     tc_orig[SIZE], tc_dest[SIZE] ,tc_test_orig[SIZE],tc_test_dest[SIZE];
    long int ti_orig[SIZE], ti_dest[SIZE] , ti_test_orig[SIZE],ti_test_dest[SIZE];
    int i;
   


    /* initialisation */
    for(i=0 ; i<SIZE ; i++) {
        tc_orig[i] = random() % 256;
        tc_dest[i] = random() % 256;
        ti_orig[i] = random(); 
        ti_dest[i] = random();
    }

    /* copie */
    memcpy(tc_test_dest, tc_dest, SIZE);
    memcpy(tc_test_orig, tc_orig, SIZE);
    memcpy(ti_test_orig, ti_orig, SIZE * sizeof(long int));
    memcpy(ti_test_dest, ti_dest, SIZE * sizeof(long int));
       
    /* swap */ 
    memswap(tc_dest, tc_orig, SIZE);
    memswap(ti_orig, ti_dest, SIZE * sizeof(long int));

    /* vérification */
    assert(memcmp(tc_orig, tc_test_dest, SIZE) == 0); 
    assert(memcmp(tc_dest, tc_test_orig, SIZE) == 0);
    assert(memcmp(ti_orig, ti_test_dest, SIZE * sizeof(long int)) == 0);
    assert(memcmp(ti_dest, ti_test_orig, SIZE * sizeof(long int)) == 0);
    printf("All test passed \n");
}

int main()
{
    test_memswap();
    
    return 0;
}