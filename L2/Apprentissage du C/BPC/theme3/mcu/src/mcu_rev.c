#include <stdio.h>
#include "mcu_readl.h"

void rev(char tab[]) {

    int compt;
    int ite;
    char temp ;
    int i ;
    for(compt = 0 ; tab[compt] != '\0' && tab[compt] != '\n' ; compt++) ;

    ite = (compt) /2 ;

    for(i = 0 ; i <ite ; i++){
        temp = tab[i];
        tab[i] = tab[compt-1-i];
        tab[compt-1-i] = temp ;
    }
    
}


int main (void)
{
    char line[MAXLINE];
    int res = 0 ;
    while(res != EOF){
        res = readl(line) ;
        rev(line);
        printf("%s\n",line);
        
    }
    
    return 0 ;
}