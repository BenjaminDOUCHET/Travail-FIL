#include <stdio.h>
#include <stdlib.h>


void swap_ptr(int **pa,int **pb){
    int *temp;
    temp = *pa;
    *pa = *pb ;
    *pb = temp;

}



int
main() {
    
    int a, b;
    int *p = &a;
    int *q = &b;
    
    swap_ptr(&p, &q);
    
    if ((p == &b) && (q == &a)) {
        printf("OK ;)\n");
        exit(EXIT_SUCCESS);
    } else {
        printf("KO ;(\n");
        exit(EXIT_FAILURE);
    }
}
