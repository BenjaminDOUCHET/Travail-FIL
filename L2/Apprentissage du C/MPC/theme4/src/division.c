#include <stdio.h>
#include "put_numbers.h"

void division(int a,int b , int *quot,int *reste){
    *quot = a/b ;
    *reste = a%b;
}

int main(){
    int a = 18 ;
    int b = 6 ; 
    int quot ;
    int reste ;
    division(a,b,&quot,&reste);
    putchar('\n');
    put_dec(a);
    putchar(' ');
    put_dec(b);
    putchar('\n');
    put_dec(quot);
    putchar(' ');
    put_dec(reste);
    putchar('\n');
    return 0;
}