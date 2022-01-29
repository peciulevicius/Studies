/*
ARRAYS WITH RANDOM NUMBERS FROM 1 TO 10
Lukasz Jutkiewicz
2018-10-17
*/

#include <stdio.h>
#include <stdlib.h>

#define SIZE 100

int main() {

	int array1[SIZE];
	int even[SIZE];
	int odd[SIZE];
	int oddCounter = 0;
	int evenCounter = 0;
	int i = 0;

	for (int i = 0; i<SIZE; i++) {
		array1[i] = rand() % 10;
		if (array1[i] % 2 != 0) {
			odd[oddCounter] = array1[i];
			oddCounter += 1;
		}
		else {
			even[evenCounter] = array1[i];
			evenCounter += 1;
		}


	}
	printf("\n\n initial array \n\n");
	for (int i = 0; i < SIZE; i++) {
		printf("%-2d,", array1[i]);
	}

	printf("\n\n even array \n\n");
	for (int i = 0; i < evenCounter; i++) {
		printf("%-2d,", even[i]);
	}

	printf("\n\n odd array \n\n");
	for (int i = 0; i < oddCounter; i++) {
		printf("%-2d,", odd[i]);
	}

	printf("\n\n\n");
	system("pause");
	return;
}
