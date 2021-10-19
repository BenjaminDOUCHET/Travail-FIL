#include <stdio.h>
#include "mcu_putint.h"

/* %cflags: -ansi -Wall */

static int put_digit(int h){
    return (h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1);
}

void putdec(int h){
    int q = h/10 ;
    int r = h%10 ;
    
    if(q>0)
        putdec(q);
    put_digit(r);
    
}

