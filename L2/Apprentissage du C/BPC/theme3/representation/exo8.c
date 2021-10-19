#include<stdio.h>

union test_u {
    unsigned int val;
    unsigned char data[sizeof(int)];
    };
    
    int main() {
        union test_u test;
        int i;

        test.val = 0x41424344;
        for (i = 0; i < sizeof(int); i++)
        {
            putchar(test.data[i]);
        }
        return 0;
    }

    //on obtient les codes :   44 43 42 41  qui sont donc inversé par rapport à test.val mais c'est logique 
    // car entre temps on a appliqué le "little endian" donc on a inversé les lettres.