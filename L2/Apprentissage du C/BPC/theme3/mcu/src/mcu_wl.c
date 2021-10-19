#include <stdio.h>
#include "mcu_putint.h"
int wc_l()
{
    int i = 0;
    int c = 'A';
    while (c != EOF)
    {
        c = getchar();
        if (c == '\n')
            i++;
    }
    return i;
}

int
main (void)
{
    putdec(wc_l());
    return 0 ;
}

