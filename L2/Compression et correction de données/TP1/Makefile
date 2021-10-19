TP=entropy
CC=gcc
CFLAGS=-Wall -g -I lib/
SRC=$(wildcard *.c) $(wildcard lib/*.c)
OBJ=$(SRC:.c=.o)
LDFLAGS=-lm
ARCHIVE_FILES=$(wildcard lib/*.c lib/*.h tests/*.h tests/*.c *.c) tests/Makefile Makefile AUTHORS
MAIN=entropy

$(MAIN): $(MAIN).o $(OBJ)
	$(CC) $(CFLAGS) -o $@ $^ $(LDFLAGS)
%.o: %.c %.h
	$(CC) $(CFLAGS) -c $<
lib/%.o: lib/%.c lib/%.h
	$(CC) $(CFLAGS) -c $< -o $@
clean:
	rm -f $(OBJ) $(MAIN)
cleanall: clean
	rm -rf doc/
doc: $(SRC)
	doxygen .doxyfile
archive: tp-$(TP).zip
tp-$(TP).zip: $(ARCHIVE_FILES)
	zip $@ $(ARCHIVE_FILES)
.PHONY: clean archive
