.include "../truc.mk"

all: test

%.o: %.c
	gcc -c -Wall $<

%.exe : %.o
	gcc -o $@ $<

numbers-test: numbers-test.o put_numbers.o
	gcc -o $@ $^

main_file: main_file.o
	gcc -o main_file main_file.o

macro1: macro1.o
	gcc -o macro1 macro1.o

macro1.o: ./prepro/macro1.c
	gcc -c -Wall ./prepro/macro1.c

macrop: macrop.o
	gcc -o macrop macrop.o

macrop.o: ./prepro/macrop.c
	gcc -c -Wall ./prepro/macrop.c


compcond: compcond.o
	gcc -o compcond compcond.o

compcond.o: ./prepro/compcond.c
	gcc -c -Wall ./prepro/compcond.c -DNO_LOG

compchk: compchk.o
	gcc -o compchk compchk.o

compchk.o: ./prepro/compchk.c
	gcc -c -Wall ./prepro/compchk.c -DSIZE=3

	

test: #COMPLETER LES DEPENDANCES
	#COMPLETER LES COMMANDES
	@echo "Ceci ne fait rien pour le moment."

clean:
	rm -f *.o macro1 tmp macrop compcond compchk



.PHONY: all test clean


