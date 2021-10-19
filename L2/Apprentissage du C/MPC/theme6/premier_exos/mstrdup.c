#include<stdio.h>
#include<stdlib.h>


char *mstrdup(const char *str){
    int i=0;
    char *newDest = malloc(sizeof(str));
    while(*(str+i)!='\0'){
        *(newDest+i) = *(str+i);
        i++;

    }
    *(newDest+i)='\0';
    return newDest;
}


int main(int argc, char **argv){
    char* copy;
    int i;
    if (argc <= 1) {
    fprintf(stderr, "Usage: %s <a String to copy>", argv[0]);
    exit(1);
  }
    

    for(i=0;i<argc;i++){
    copy = mstrdup(argv[i]);
    printf("%s",copy);
    putchar('\n');
    free(copy);
    }



    return 0;
}
