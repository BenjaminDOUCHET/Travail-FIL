CFLAGS=-ansi -Wall -pedantic
CC ?= cc


all: test

%.exe : %.o
	gcc -o $@ $<

fifo: fifo.o
	$(CC) $(CFLAGS) -o $@ $^

fifo.o: fifo.c
	$(CC) -c $(CFLAGS) $<

test: fifo
	@echo "----------------------------"
	@echo "test fifo"
	./fifo
	
clean:
	rm -f *.o nvar



.PHONY: all clean


