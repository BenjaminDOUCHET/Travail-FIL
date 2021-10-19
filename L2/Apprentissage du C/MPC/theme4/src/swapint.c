#include <stdio.h>
#include "put_numbers.h"

void swap_int(int *x,int*y){
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;
}


int main()
{
    int a ;
    int b ;
    scanf("%d" ,&a);
    scanf("%d" ,&b);
    putchar('\n');
    put_dec(a);
    putchar(' ');
    put_dec(b);
    swap_int(&a, &b);
    putchar('\n');
    put_dec(a);
    putchar(' ');
    put_dec(b);
    putchar('\n');
    return 0;
}