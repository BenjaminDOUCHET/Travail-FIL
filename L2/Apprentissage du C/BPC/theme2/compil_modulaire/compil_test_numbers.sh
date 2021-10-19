#!/bin/sh
gcc -c -Wall -ansi numbers-test.c
gcc -c -Wall -ansi put_numbers.c
gcc -o numbers-test numbers-test.o put_numbers.o