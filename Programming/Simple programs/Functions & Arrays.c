/*
FUNCTIONS AND ARRAYS
*/

/*
1. generate random array 
2. assign odd and even variables to seperate arrays called odd and even
3. print all of the arrays out
4. create a function for each of the steps
5. call the functions
*/

#include <stdio.h>
#include <stdlib.h>

void generateArray(int array[], int size) {

	int i = 0;
	for (i = 0; i < size; i++) {
		array[i] = rand() % 10;
	}
	/*
	in C, if you pass array into function, it automatically passes by reference and gets assigned
	properly! Like a pointer or so.
	*/
	}


void displayArray(int array[], int size) {

	int i = 0;
	for (i = 0; i < size; i++) {
		printf("%-2d", array[i]);
	}

}

void repeat() {

	int randomArray[100];
	int nr;
	printf("how many numbers you want to generate? \n");
	scanf_s("%d", &nr);

	generateArray(randomArray, nr);
	displayArray(randomArray, nr);

}

int main()
{
	repeat();
	repeat();
	repeat();



	system("pause");
	return 0;
}