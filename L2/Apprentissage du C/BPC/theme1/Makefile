all: test

numbers-test: numbers-test.o
	gcc -o numbers-test numbers-test.o

numbers-test.o: numbers-test.c
	gcc -c -Wall numbers-test.c

test: #COMPLETER LES DEPENDANCES
	#COMPLETER LES COMMANDES
	@echo "Ceci ne fait rien pour le moment."

clean:
	rm -f *.o numbers-test tmp

.PHONY: all test clean
