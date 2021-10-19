
int put_test_line(int n)
{
    putchar('t');
    putchar('e');
    putchar('s');
    putchar('t');
    putchar(' ');
    putchar('#');
    putdec(n);
    putchar(':');

    return 0;
}
void newline(){
    putchar('\n');
}

/* %cflags: -ansi -Wall */

#include <stdio.h>

int putchar(int c);

int put_digit(int h){
    return (h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1);
}

int put_hdigit(int h){
    int res ;
    if( h<= 9){
    res =(h>=0 && h<=9 && putchar('0'+h) != EOF ? 0 : -1) ;
    }
    else{
        res = (h<=15 && putchar('A'+h-10) != EOF ? 0 : -1);
    }
    return res ;

}


void print_ascii_table(){
    int compt = -1 ;
    while(compt <= 15){
        putchar('-');
        (compt >=0 ? put_hdigit(compt): putchar('-'));
        putchar(' ');
        compt++;
        }
    putchar('\n');
    int comptV = 0;
    while(comptV<=15){
        put_hdigit(comptV) ;
        putchar('-');
        compt = 0;
        while(compt <=15){
            putchar(' ');
            int temp = (16*comptV)+compt;
            temp = temp<32 ? '.' : temp ;
            putchar(' ');
            putchar(temp);
            compt++;
        }
        putchar('\n');
        comptV++;
    }
}

int putdecsimple(int h){
    int q = h/10 ;
    int r = h%10 ;
    int res =0 ;
    if(q>0)
        res = putdecsimple(q);
    return(!res && put_digit(r) != EOF ? 0 : -1 );
    
}


int putdec(int h){
    int res ;
    if(h<0){
        putchar('-');
        res = putdecsimple(-1*h);
    }
    else{
        res = putdecsimple(h);
    }
    
    return res ;
}



 int putbin(int h){
    int i = sizeof(int)*8;
    int res = 0 ;
    if(h == 0){
       res = put_digit(0);
    }
    else{
    while(!(h>>i & 1))
        i--;
    i++;
    while(i--)
      res = put_digit(h>>i & 1);
    }
    return res ;
 }


int puthexsimple(int h){
     int q = h/16 ;
    int r = h%16 ;
    int res =0 ;
    if(q>0)
        res = puthex(q);
    return(!res && put_hdigit(r) != EOF ? 0 : -1 );
    
}

int puthex(int h){
    int res ;
    if(h<0){
        putchar('-');
        res = puthexsimple(-1*h);
    }
    else{
        res = puthexsimple(h);
    }
    
    return res ;
}








int main()
{

 
    int i=-2147483648;
    put_test_line(1); putdec(214); newline();
    put_test_line(2); putdec(-74); newline();
    put_test_line(3); putdec(1); newline();
    put_test_line(4); putdec(-1); newline();
    put_test_line(5); putdec(0); newline();
    put_test_line(6); putdec(2147483647); newline();
    put_test_line(7); putdec(-2147483648); newline();
    put_test_line(8); putdec(-(-2147483648)); newline();
    put_test_line(9); puthex(0); newline();
    put_test_line(10); puthex(10); newline();
    put_test_line(11); puthex(16); newline();
    put_test_line(12); puthex(2147483647); newline();
    put_test_line(13); puthex(-2147483648); newline();
    put_test_line(14); puthex(0xCAFEBABE); newline();
    put_test_line(15); puthex(-1); newline();
    put_test_line(16); putbin(0); newline();
    put_test_line(17); putbin(1); newline();
    put_test_line(18); putbin(-1); newline();
    put_test_line(19); putbin(2147483647); newline();
    put_test_line(20); putbin(-2147483648); newline();

    return 0;
}
