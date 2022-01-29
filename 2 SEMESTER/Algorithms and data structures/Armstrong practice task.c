#include <stdio.h>

int main(){

	int a, b, c;
	int abc, a3b3c3;
	int count;

	count = 0;

	for (a = 0; a < 9; a++) {
		for (b = 0; b < 9; b++) {
			for (c = 0; c < 9; c++) {
				abc = a * 100 + b * 10 + c;
				a3b3c3 = a * a*a + b * b*b + c * c*c;
				if (abc == a3b3c3) {
					count = count + 1;
					printf("Armstrong number: %d \n", abc, count);
				}
			}
		}
	}

	system("PAUSE");
	return 0;
}
