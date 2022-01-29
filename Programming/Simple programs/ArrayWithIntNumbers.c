/*
		Create an array with integer numbers,
			Dziugas PEciulevicius
				2018-10-10
*/

#include <stdio.h>
#include <stdlib.h>

int main() {

	int myArray[10];
	int i = 0;
	int x = 1;

	for (i = 0; i < 4; i++) {

		myArray[i] = x;
		printf("%-4d", myArray[i]); // - sign alligns text to the left | the 4 before 4d, gives each output value a gap of 4 spaces | right alligment is default
		x += 2;

	}


	printf("\n");
	system("pause");

	return 0;
}