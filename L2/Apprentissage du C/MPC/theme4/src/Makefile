CFLAGS=-ansi -Wall -pedantic
CC ?= cc


all: test

%.exe : %.o
	gcc -o $@ $<

swapint: swapint.o put_numbers.o
	$(CC) $(CFLAGS) -o $@ $^

swapint.o: swapint.c
	$(CC) -c $(CFLAGS) $<

division: division.o put_numbers.o
	$(CC) $(CFLAGS) -o $@ $^

division.o: division.c
	$(CC) -c $(CFLAGS) $< 

put_numbers.o: put_numbers.c
	$(CC) -c $(CFLAGS) $<

skipspace: skipspace.o
	$(CC) $(CFLAGS) -o $@ $^

skipspace.o: skipspace.c
	$(CC) -c $(CFLAGS) $<

swapptr: swapptr.o
	$(CC) $(CFLAGS) -o $@ $^

swapptr.o: swapptr.c
	$(CC) -c $(CFLAGS) $<

dicho: dicho.o
	$(CC) $(CFLAGS) -o $@ $^

dicho.o: dicho.c
	$(CC) -c $(CFLAGS) $<


test: swapint division skipspace swapptr dicho
	@echo "----------------------------"
	@echo "test Swap int"
	@echo "merci de taper successivement deux nombres"
	./swapint
	@echo "----------------------------"
	@echo "                            "
	@echo "test division"
	./division
	@echo "----------------------------"
	@echo "                            "
	@echo "tests skipspace"
	./skipspace "FOO BAR"
	@echo "----------------------------"
	@echo "                            "
	./skipspace "       FOO BAR"
	@echo "----------------------------"
	@echo "                            "
	./skipspace "Foo Bar"
	@echo "----------------------------"
	@echo "                            "
	./skipspace "       Foo Bar"
	@echo "----------------------------"
	@echo "                            "
	@echo "test Swap ptr"
	@echo "----------------------------"
	@echo "                            "
	./swapptr

	@echo "test dichotmie"
	@echo "----------------------------"
	@echo "                            "
	./dicho
	

clean:
	rm -f *.o swapint division skipspace swapptr



.PHONY: all clean


