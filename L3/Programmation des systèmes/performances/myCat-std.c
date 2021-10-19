
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
extern FILE *stdout;


void myCatStd(char *file){
    int c;
    FILE *f = fopen(file,"r");
    assert(f !=NULL);
    
    
    while((c=fgetc(f)) != EOF){
        fputc(c,stdout);        
    }
    
}




int main(int argc, char *argv[]) {
   
    if (argc <= 1)
    {
        printf("usage : need 1 args the file path \n");
        exit(1);
    }
    myCatStd(argv[1]);

    return 0;
}