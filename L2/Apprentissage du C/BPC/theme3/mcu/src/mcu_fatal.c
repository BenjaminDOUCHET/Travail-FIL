#include "mcu_fatal.h"
#include <stdlib.h>
#include <stdio.h>
/* Pas un int ! un size_t
int strlen(char s[]) {
int i = 0;
while (s[i] != '\0') {
i++;
}
return i;
}
*/

void fatal(int assert, const char message[], int status) {
int i = 0;
if (assert != 0) {
while (message[i] != '\0'){
putchar(message[i]);
i++;
}
exit(status);
}
}

