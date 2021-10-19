CC ?= cc
CFLAGS ?= -Wall -Werror -ansi -pedantic
LDFLAGS ?=

all: build/mcu_test build/mcu_wc build/mcu_wl build/mcu_rev

%.o: %.c
	$(CC) -c $(CFLAGS) -o $@ $<

build/mcu_test: src/mcu_putint.o src/mcu_fatal.o src/mcu_readl.o src/mcu_test.o
	$(CC) $(LDFLAGS) -o $@ $^

build/mcu_wc : src/mcu_wc.o src/mcu_putint.o 
	$(CC) $(LDFLAGS) -o $@ $^

build/mcu_wl : src/mcu_wl.o src/mcu_putint.o 
	$(CC) $(LDFLAGS) -o $@ $^

build/mcu_rev : src/mcu_rev.o src/mcu_readl.o src/mcu_fatal.o
	$(CC) $(LDFLAGS) -o $@ $^
clean:
	rm -f src/*.o build/*

.PHONY: all clean
