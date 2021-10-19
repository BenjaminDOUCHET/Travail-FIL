#include<stdio.h>



float * search_dicho(float v, float *tab, int size){
    int m;
    
    float *deb = tab ;
    float *fin = &tab[size];
    if(*deb == *fin){
        return NULL;
    }
    m = size/2;
    if(tab[m]==v){
        return &tab[m];
    }
    else if(tab[m] > v ){
        return search_dicho(v, tab, m );
    }
    else{
        return search_dicho(v, &tab[m], size-m-1);
    }

}


int main(void)
{
float *res;
float t[] ={15,20,23,24,25,26,30,45,55,66,67,68,77};
float *tab = t;
float elem_n= 1;
int size=13;
float elem=20;
res = search_dicho(elem, tab, size);

printf("on a trouve l'element : %d\n",*res == elem);
res = search_dicho(elem_n, tab, size);
printf("on a trouve l'element : %d\n",*res == elem_n);
return 0;
} 

