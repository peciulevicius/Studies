/*
Array with odd and even (1-10) 
EVALDAS PAULAUSKAS
2018-10-17
*/

/*
assign variables to array int array[100] , random numbers from 1 to 10-17
then print initial array
then print even and odd array
*/

#include <stdio.h>

int main() {

	int array1[100];
	int even[100];
	int odd[100];
	int i = 0;

	for (int i = 0; i<100; i++) {
		array1[i] = rand() % 10;
		if (array1[i] % 2 != 0) {
			odd[i] = array1[i];
		}
		else {
			odd[i] = 11;
		}
		if (array1[i] % 2 == 0) {
			even[i] = array1[i];
		}
		else {
			even[i] = 11;
		}
		
	}
	printf("\n\n initial array \n\n");
	for (int i = 0; i < 100; i++) {
		printf("%-2d,", array1[i]);
	}

	printf("\n\n even array \n\n");
	for (int i = 0; i < 100; i++) {
		if (even[i] == 11) {		
			continue;
		}
		printf("%-2d,", even[i]);
	}

	printf("\n\n odd array \n\n");
	for (int i = 0; i < 100; i++) {
		if (odd[i] == 11) {
			continue;
		}
		printf("%-2d,", odd[i]);
	}

	printf("\n\n\n");
	system("pause");
	return;
}
