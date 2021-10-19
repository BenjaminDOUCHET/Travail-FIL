#include<stdio.h>
#include<stdlib.h>

#include "lib/entropy.h"



  

int main(int argc, char **argv) {

  if (argc <= 1) {
    fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
    exit(1);
  }
  FILE *file = fopen(argv[1], "r");
  int counts[256];
  int i;
  struct file_stat res;
  for (i = 0; i < 256; i++) {
    counts[i] = 0;
  }
  count_occurrences(file, counts);
  res = entropy(counts);
  printf("Le fichier fait %d octets et a une entropie de %f bits par octet \n",res.size,res.entropy);
  
  float reduc = 100-(res.size*res.entropy*100)/(res.size*8) ; 
  
  printf(" Au mieux un codage optimal améliorerait le stockage de ce fichier de %f \% \n",reduc);
  
  fclose(file);
  exit(0);
}
