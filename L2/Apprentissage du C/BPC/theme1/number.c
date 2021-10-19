/* %cflags: -ansi -Wall */

#include <stdio.h>

int putchar(int c);

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

int putdec(int h){
    int q = h/10 ;
    int r = h%10 ;
    int res ;
    if(q>0)
        res = putdec(q);
    return(!putdec(q) && put_digit(r) != EOF ? 0 : -1 );
    
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