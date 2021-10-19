include ../truc.mk

all: test


%.exe : %.o
	gcc -o $@ $<

numbers-test: numbers-test.o put_numbers.o
	gcc -o $@ $^

main_file: main_file.o
	gcc -o $@ $<

macro1: macro1.o
	gcc -o $@ $<


macrop: macrop.o
	gcc -o $@ $<




compcond: compcond.o
	gcc -o $@ $<

compcond.o: ./prepro/compcond.c
	gcc -c -Wall $< -DNO_LOG

compchk: compchk.o
	gcc -o $@ $<

compchk.o: ./prepro/compchk.c
	gcc -c -Wall $< -DSIZE=3

	

test: #COMPLETER LES DEPENDANCES
	#COMPLETER LES COMMANDES
	@echo "Ceci ne fait rien pour le moment."

clean:
	rm -f numbers-test .o put_numbers.o
    rm -f numbers-test



.PHONY: all test clean


