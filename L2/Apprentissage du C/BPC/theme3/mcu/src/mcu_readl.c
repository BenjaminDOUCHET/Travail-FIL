#include "mcu_readl.h"
#include "mcu_fatal.h"
#include <stdio.h>

int readl(char line[]) {
int i = 0;
int fini = 0;
int c;

while (!fini) {
    fatal(i >= MAXLINE, "Trop long !", LINETOOLONG);
    c = getchar();
    if (c == '\0' || c == '\n') {
    fini = 1;
    c = '\0';
    }
    else if(c == EOF){
        c = '\0';
        fini = 1;
        line[i] ='\0' ;
        i = -1;
    }
    if(i>=0){
    line[i] = (char) c;
    i++;
    }
}
    return i;
    }