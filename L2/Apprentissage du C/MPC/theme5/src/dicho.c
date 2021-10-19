#include<stdio.h>



float * search_dicho(float v, float *tab, float *end){
    int size = 0;
    int m ;
    float *deb = tab ;
    float *fin =end;
    while(deb+size != fin) {
        size++;
    }
    m = size/2;

    if(*deb == *fin){
        return deb;
    }
    
    if(tab[m]==v){
        return &tab[m];
    }
    else if(tab[m] > v ){
        return search_dicho(v, deb, deb+m );
    }
    else{
        return search_dicho(v, deb+m+1,end);
    }

}


int main(void)
{
float *res;
float t[] ={15,20,23,24,25,26,30,45,55,66,67,68,77};
float *tab = t;
float elem_n= 1;

float elem=20;
res = search_dicho(elem, tab, tab+13);

printf("on a trouve l'element : %d\n",*res == elem);
res = search_dicho(elem_n, t, t+13);
printf("on a trouve l'element : %d\n",*res == elem_n);
return 0;
} 

