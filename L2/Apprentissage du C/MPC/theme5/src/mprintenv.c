#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "put_numbers.h"


void mprintenv_v1(){

int i = 0;
extern char **environ;
while ( environ[i] != 0 ){
    printf("%s",environ[i]);
    printf("\n");
    i++;
} 
 
}


void mprintenv_v2(char *c){
int i = 0;
int j;
extern char **environ;
while ( environ[i] != 0 ){
    if(strncmp(c,environ[i],4)==0){
        j=0;
        while(*(c+j) != '\0'){
            j++;
        }
    printf("%s",environ[i]+j+1);
    printf("\n");
    }
    i++;
} 
 
}



int main(int argc, char **argv) {
    
    int i;
    
    if (argc <= 1)
    {
        mprintenv_v1();
        exit(1);
    }

    putchar('\n');

    
    for(i = 0; i<argc ; i++){
        mprintenv_v2(argv[i]);
    }
    
    
    return 0;
}