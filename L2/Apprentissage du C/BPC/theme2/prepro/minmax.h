#ifndef __MINMAX_H__
#define __MINMAX_H__
    #include "abs.h"
#endif


static inline int min(int x,int y) { return (x+y-abs(x-y))/2; }
static inline int max(int x,int y) { return (x+y+abs(x-y))/2; }
