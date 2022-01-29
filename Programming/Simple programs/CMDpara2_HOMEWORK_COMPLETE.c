#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*

== CMD PARAMETERS ==
PROGRAM THAT TAKES IN INTS IN CMD AND GIVES INSTANT RESULTS.
2018.09.26
*/

int main(int argc, char *argv[]) {
	// start program from CMD to make it work
	// programname.exe value1 value2 value3 etc. for each array value
	// argc = argument count | argv = 

	//a loop to make infinite arguments for the array and print them
	int number;
	int sumAll = 0;

	for (int i = 1; i < argc; i++) {
		number = atoi(argv[i]);
		printf("argv[%d] = %s \n", i, argv[i]);
		sumAll = sumAll + number;

	}

	printf("the sum of all equal = %d ", sumAll);

	// read up on atoi function ( and how it works )

	return 0;

}

/*
Homework

Calculate the sum of all numbers specified by the user
print all numbers and the sum


requirements for the homework :

will have to convert string values to integer
use CMDparameters functions as the ground floor for the program

number = atoi(argv[i]);
*/