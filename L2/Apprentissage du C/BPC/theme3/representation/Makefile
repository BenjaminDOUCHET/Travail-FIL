CFLAGS=-ansi -Wall -pedantic
CC ?= cc

all: input output

input: input.o
	$(CC) $(LDFLAGS) -o $@ $^
	
output: output.o
	$(CC) $(LDFLAGS) -o $@ $^

input.o: input.c commun.h
	$(CC) -c $(CFLAGS) -o $@ $<
	
	
output.o: output.c commun.h
	$(CC) -c $(CFLAGS) -o $@ $<

exo8.o : exo8.c
	$(CC) -c $(CFLAGS) -o $@ $<

exo8 : exo8.o
	$(CC) $(LDFLAGS) -o $@ $^
test: input output
	./output > data.bin
	./input < data.bin
	hd ./data.bin

clean:
	rm -f *.o output input data.bin

.PHONY: all clean

mcu_test : 
	gcc $(CFLAGS) -c src/mcu_putint.c
	gcc $(CFLAGS) -c src/mcu_fatal.c
	gcc $(CFLAGS) -c src/mcu_readl.c
	gcc $(CFLAGS) -c src/mcu_test.c
	gcc $(CFLAGS) -o build/mcu_test src/mcu_putint.o src/mcu_fatal.o