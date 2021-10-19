CFLAGS=-ansi -Wall -pedantic
CC ?= cc


all: test

%.exe : %.o
	gcc -o $@ $<

nvar: nvar.o put_numbers.o
	$(CC) $(CFLAGS) -o $@ $^

nvar.o: nvar.c
	$(CC) -c $(CFLAGS) $<

put_numbers.o: put_numbers.c
	$(CC) -c $(CFLAGS) $<

mprintenv: mprintenv.o 
	$(CC) $(CFLAGS) -o $@ $<

mprintenv.o: mprintenv.c
	$(CC) -c $(CFLAGS) $<

dicho: dicho.o
	$(CC) $(CFLAGS) -o $@ $^

dicho.o: dicho.c
	$(CC) -c $(CFLAGS) $<

mmemcpy: mmemcpy.o
	$(CC) $(CFLAGS) -o $@ $^

mmemcpy.o: mmemcpy.c
	$(CC) -c $(CFLAGS) $<

memswap: memswap.o
	$(CC) $(CFLAGS) -o $@ $^

memswap.o: memswap.c
	$(CC) -c $(CFLAGS) $<

filter_int: filter_int.o
	$(CC) $(CFLAGS) -o $@ $^

filter_int.o: filter_int.c
	$(CC) -c $(CFLAGS) $<

test: nvar mmemcpy dicho mprintenv memswap filter_int
	@echo "----------------------------"
	@echo "test nvar"
	./nvar
	printenv | wc -l
	@echo "----------------------------"
	@echo "test mprintenv"
	./mprintenv | head
	./mprintenv HOME SHELL
	@echo "----------------------------"
	@echo "test dichotmie"
	@echo "                            "
	./dicho
	@echo "----------------------------"
	@echo "test mmemcpy"
	@echo "                            "
	./mmemcpy
	
	@echo "test mswap"
	@echo "                            "
	./memswap
	
	@echo "----------------------------"
	@echo "test filter_int"
	@echo "                            "
	./filter_int
clean:
	rm -f *.o nvar



.PHONY: all clean


