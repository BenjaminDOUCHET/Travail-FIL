#include<stdio.h>
#include<stdlib.h>

void counter(){

    static int cpt = 0;
    printf("compteur à :%d",cpt);

    cpt++;
}


int main(){

    int i;
    for(i=0;i<10;i++){
        counter();
        putchar('\n');
    }
    return 0;

}