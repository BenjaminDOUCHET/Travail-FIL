#include <stdio.h>
#define T (65+1)
extern int putchar(int c);
extern int  putdec(int c);

int main() 
{
    int ln=__LINE__;
    
    printf("%d\n",ln);
    
    int u=68;
    putchar(u);                 /* premier char */
    putchar(T);                 /* deuxième char */
    putchar('\n');
}
