
CFLAGS = -Wall -Werror -ansi -pedantic

%.o: %.c
	gcc $(CFLAGS) $<
