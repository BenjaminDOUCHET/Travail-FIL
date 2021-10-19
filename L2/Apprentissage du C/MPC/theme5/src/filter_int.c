#include <stdio.h>
#include <stdlib.h>



void filter_int(int *to, const int *from, unsigned int size,int (*f)(int)){

    int i = 0 ;
    int j = 0 ;
    
    
    for(i;i<size;i++){
        if((*f)(*(from+i))!=0){
            *(to+j) = *(from+i);
            j++;
        }  
    }
}

int filter(int a){
    return a%2 == 0;
}

int main()
{
    int i;
    int isrc[] = {1, 10, 15, 20, 27, 30, 39, 40, 45, 50, 53};
    int n = sizeof(isrc) / sizeof(isrc[0]);
    
    printf("\nl'array initiale est : ");
    for (i = 0; i < n; i++)
        printf("%d ", isrc[i]);

    printf("\n");

    int idest[n];
    for (i = 0; i < n; i++)
        idest[i] = 1;
    filter_int(idest, isrc, 11, filter);
    printf("\nl'array filtrée est : ");
    for (i = 0; i < n; i++)
        printf("%d ", idest[i]);

    printf("\n");

    return 0;
}