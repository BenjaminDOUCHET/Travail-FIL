#include <stddef.h>
#include "generator_matrices.h"

binary_matrix parity_generator(int n) {
  binary_matrix g = zero_matrix(n, n+1);
  int i;

  for (i = 0; i < n; i++) {
    set_matrix_value(g, i, i, 1);
    set_matrix_value(g, i, n, 1);
  }

  return g;
}

binary_matrix repeat3_generator(int n) {
  binary_matrix g = zero_matrix(n, 3*n);
  int i;

  for(i=0 ; i<n ;i++){
    set_matrix_value(g, i, i, 1);
    set_matrix_value(g, i, n+i, 1);
    set_matrix_value(g, i, (2*n)+i, 1);
  }

  return g;
}

binary_matrix parity2d_generator(int n) {
  int k =1 ;
  int i;
  binary_matrix g = zero_matrix(n+1, n+1);
  for (i = 0; i < n; i++) {
    set_matrix_value(g, i, i, 1);
    set_matrix_value(g, i, n, 1);
    set_matrix_value(g, n, i, 1);
  }
  if(n%2 == 0){
    k = 0;
  }
  set_matrix_value(g, n, n, k);
  return g;
}


binary_matrix hamming_generator() {
  binary_matrix g = zero_matrix(4, 7);
  int i;
  for(i=0 ; i<4;i++){
    set_matrix_value(g, i, i, 1);
  }
    set_matrix_value(g, 0, 4, 1);
    set_matrix_value(g, 0, 5, 1);
    set_matrix_value(g, 1, 5, 1);
    set_matrix_value(g, 1, 6, 1);
    set_matrix_value(g, 2, 4, 1);
    set_matrix_value(g, 2, 6, 1);
    set_matrix_value(g, 3, 4, 1);
    set_matrix_value(g, 3, 5, 1);
    set_matrix_value(g, 3, 6, 1);
  return g;
}

binary_matrix hammingp_generator() {
  binary_matrix g = zero_matrix(4, 8);
  int i;
  for(i=0 ; i<4;i++){
    set_matrix_value(g, i, i, 1);
  }
    set_matrix_value(g, 0, 4, 1);
    set_matrix_value(g, 0, 5, 1);
    set_matrix_value(g, 1, 5, 1);
    set_matrix_value(g, 1, 6, 1);
    set_matrix_value(g, 2, 4, 1);
    set_matrix_value(g, 2, 6, 1);
    set_matrix_value(g, 3, 4, 1);
    set_matrix_value(g, 3, 5, 1);
    set_matrix_value(g, 3, 6, 1);
    set_matrix_value(g, 0, 7, 1);
    set_matrix_value(g, 1, 7, 1);
    set_matrix_value(g, 2, 7, 1);
  
  return g;
  return NULL;
}  
