CC      = gcc
CFLAGS  = -ansi -Wall -Wextra
CFLAGS += -D_XOPEN_SOURCE=500
CFLAGS += -g

all: test

%.exe : %.o
	gcc -o $@ $<

clean:
	rm -f *.o nvar

.PHONY: all clean