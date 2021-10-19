#include<stdio.h>



long arrondi512(long nb){
    long res = nb/512;
    if(nb%512 !=0){
        res += 1;
    }
return res*512;
}