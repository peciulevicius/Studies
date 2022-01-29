/*
		Pointer Comparisons
			2018-11-07
 */

#define _CRT_SECURE_
//it will switch off all secure warnings for use of non-secure functions
#include <stdio.h>
#include <stdlib.h>

const int MAX = 3;

int main() {

	int  var[] = { 10, 100, 200 };
	int  i, *ptr;

	/* let us have address of the first element in pointer */
	ptr = var;
	i = 0;

	while (ptr <= &var[MAX - 1]) {

		printf("Address of var[%d] = %x\n", i, ptr);
		printf("Value of var[%d] = %d\n", i, *ptr);

		/* point to the previous location */
		ptr++;
		i++;
	}
	system("PAUSE");
	return 0;
}
