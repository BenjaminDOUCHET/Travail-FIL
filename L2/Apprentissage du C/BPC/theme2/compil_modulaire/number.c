/* %cflags: -ansi -Wall */

#include <stdio.h>

int putchar(int c);


int putdec(int h){
    int q = h/10 ;
    int r = h%10 ;
    int res ;
    if(q>0)
        res = putdec(q);
    return(!putdec(q) && put_digit(r) != EOF ? 0 : -1 );
    
}

int put_digit(int h){
    return (h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1);
}

int put_hdigit(int h){
    int res ;
    if( h<= 9){
    res =(h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1) ;
    }
    else{
        res = (h<=15 && putchar('A'+h-10) != EOF ? 0 : -1);
    }
    return res ;

}


void print_ascii_table(){
    int compt = -1 ;
    while(compt <= 15){
        putchar('-');
        (compt >=0 ? put_hdigit(compt): putchar('-'));
        putchar(' ');
        compt++;
        }
    putchar('\n');
    int comptV = 0;
    while(comptV<=15){
        put_hdigit(comptV) ;
        putchar('-');
        compt = 0;
        while(compt <=15){
            putchar(' ');
            int temp = (16*comptV)+compt;
            temp = temp<32 ? '.' : temp ;
            putchar(' ');
            putchar(temp);
            compt++;
        }
        putchar('\n');
        comptV++;
    }
}

int putdecsimple(int h){
    int q = h/10 ;
    int r = h%10 ;
    int res =0 ;
    if(q>0)
        res = putdecsimple(q);
    return(!res && put_digit(r) != EOF ? 0 : -1 );
    
}


int putdec(int h){
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



 int putbin(int h){
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


int puthexsimple(int h){
     int q = h/16 ;
    int r = h%16 ;
    int res =0 ;
    if(q>0)
        res = puthexsimple(q);
    return(!res && put_hdigit(r) != EOF ? 0 : -1 );
    
}

int puthex(int h){
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





/**
 * Nous définissons maintenant la fonction "main()" : nous allons 
 * écrire le corps de cette fonction.
 * "main()" est la fonction qui sera exécutée au démarrage de 
 * notre programme.
 * Cette fonction ne prend pas de paramètre et retourne 0 si le
 * programme termine correctement (une autre valeur en cas d'erreur).
 **/

int
main()
{
  putchar('\n');
  put_digit(8);
  putchar('\n');
  put_hdigit(13);
  return 0;
}