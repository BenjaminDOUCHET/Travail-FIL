#include <stdio.h>
#include "put_numbers.h"

int main(){
    put_dec(42);putchar('\n');
    put_dec(-28);putchar('\n');
    put_dec(1<<31-1);putchar('\n');
    put_hex(42);putchar('\n');
    put_hex(-28);putchar('\n');
    put_hex(1<<31-1);putchar('\n');
    put_bin(42);putchar('\n');
    put_bin(-28);putchar('\n');
    put_bin(1<<31-1);putchar('\n');
}