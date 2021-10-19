CC      = gcc
CFLAGS  = -ansi -Wall -Wextra
CFLAGS += -D_XOPEN_SOURCE=500
CFLAGS += -g

all: test

%.exe : %.o
	gcc -o $@ $<

myStat: myStat.o 
	$(CC) $(CFLAGS) -o $@ $^

myStat.o: myStat.c
	$(CC) -c $(CFLAGS) $<



test: myStat
	./myStat cpTest



clean:
	rm -f *.o nvar

.PHONY: all clean


