CFLAGS=-ansi -Wall -pedantic
CC ?= cc


all: test

%.exe : %.o
	gcc -o $@ $<

compteur.o : compteur.c
	$(CC) -c $(CFLAGS) $<

compteur : compteur.o
	$(CC) $(CFLAGS) -o $@ $^

mstrdup.o : mstrdup.c
	$(CC) -c $(CFLAGS) $<

mstrdup : mstrdup.o
	$(CC) $(CFLAGS) -o $@ $^

test: compteur mstrdup
	@echo "----------------------------"
	@echo "test compteur"
	./compteur
	
	@echo "----------------------------"
	@echo "test mstrdup"
	./mstrdup ca marche
