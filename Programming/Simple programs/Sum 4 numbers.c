/*
	SUM OF 4 NUMBERS TYPED INTO CMD USING PRINTF/SCANF
 */

#include <stdio.h>
#include <stdlib.h>													//for system("PAUSE");

int main()															//entering main function
{
	int a, b, c, d, e;												//entering variables
	printf("Enter four numbers:\n");								//making a "request" text
	scanf_s("%d %d %d %d", &a, &b, &c, &d);							//scanf allows to accept input
	e = a + b + c + d;
	printf("The sum of %d + %d + %d + %d = %d\n", a, b, c, d, e);	//making a final statement

	system("PAUSE");
	return 0;
}

