CC      = gcc
CFLAGS  = -ansi -Wall -Wextra
CFLAGS += -D_XOPEN_SOURCE=500
CFLAGS += -g

all: test

%.exe : %.o
	gcc -o $@ $<

myCat: myCat.o 
	$(CC) $(CFLAGS) -o $@ $^

myCat.o: myCat.c
	$(CC) -c $(CFLAGS) $<

myCat-std.o : myCat-std.c
	$(CC) -c $(CFLAGS) $<

myCat-std : myCat-std.o
	$(CC) $(CFLAGS) -o $@ $^

test: myCat clean myCat-std
	bash script.sh

graph: 
	gnuplot run.gnu

clean:
	rm -f *.o ex2.dat ex3.dat

.PHONY: all clean


