#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <ctype.h>

char * skip_spaces(char str[]){
    int i = 0 ;
    char *res;
    int trouve = 0 ;
    while(!trouve && (str[i]!='\0'&&str[i]!='\n'&&str[i]!=EOF)){
        if(str[i]!=' '){
            trouve = 1;
        }
        i++;
    }
    if(str[i]!='\0'){
        res = &str[i-1];
    }
    else{
        res = &str[i];
    }
    return res;
}

int
main(int argc, char *argv[])
{
    char * strip;
    int i; 
    assert(argc == 2);

    printf("argv  : %s\n", argv[1]);
    strip = skip_spaces(argv[1]);
    printf("strip : %s\n", strip);

    for (i=0 ; strip[i]; i++)
        strip[i] = toupper(strip[i]);

    printf("strip : %s\n", strip);
    printf("argv  : %s\n", argv[1]);
    
    exit(EXIT_SUCCESS);
}
