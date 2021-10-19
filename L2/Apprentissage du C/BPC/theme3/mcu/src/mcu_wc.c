#include <stdio.h>
#include "mcu_putint.h"

int wc_c()
{
    int i = 0;
    int c = 'A';
    while (c != EOF)
    {
        c = getchar();
        i++;
    }
    return i;
}

int
main (void)
{
   putdec(wc_c());
   return 0 ;
}