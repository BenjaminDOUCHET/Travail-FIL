#include <stdio.h>
#include "put_numbers.h"

/* %cflags: -ansi -Wall */

static int put_digit(int h){
    return (h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1);
}

int putdec(int h){
    int q = h/10 ;
    int r = h%10 ;
    int res ;
    if(q>0)
        res = putdec(q);
    return(!putdec(q) && put_digit(r) != EOF ? 0 : -1 );
    
}

static int put_hdigit(int h){
    int res ;
    if( h<= 9){
    res =(h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1) ;
    }
    else{
        res = (h<=15 && putchar('A'+h-10) != EOF ? 0 : -1);
    }
    return res ;

}



static int putdecsimple(int h){
    int q = h/10 ;
    int r = h%10 ;
    int res =0 ;
    if(q>0)
        res = putdecsimple(q);
    return(!res && put_digit(r) != EOF ? 0 : -1 );
    
}


int put_dec(int h){
    int res ;
    if(h<0){
        putchar('-');
        unsigned int temp = -1*h ;
        res = putdecsimple(temp);
    }
    else{
        res = putdecsimple(h);
    }
    
    return res ;
}



 int put_bin(int h){
    int i = sizeof(int)*8;
    int res = 0 ;
    if(h == 0){
       res = put_digit(0);
    }
    else{
    while(!(h>>i & 1))
        i--;
    i++;
    while(i--)
      res = put_digit(h>>i & 1);
    }
    return res ;
 }


static int puthexsimple(int h){
     int q = h/16 ;
    int r = h%16 ;
    int res =0 ;
    if(q>0)
        res = puthexsimple(q);
    return(!res && put_hdigit(r) != EOF ? 0 : -1 );
    
}

int put_hex(int h){
    int res ;
    if(h<0){
        putchar('-');
        res = puthexsimple(-1*h);
    }
    else{
        res = puthexsimple(h);
    }
    
    return res ;
}




