#include <stdio.h>
#include "put_numbers.h"




int nvar(){


int i = 0;
extern char **environ;
while ( environ[i] != 0 ){
    i++;
}
return i ;
}

int main(){

int i = nvar() ; 
put_dec(i);
putchar('\n');
return 0;
}
