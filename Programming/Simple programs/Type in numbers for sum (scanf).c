////Program that let's you type in numbers for sum with scanf
#include <stdio.h>
#include <stdlib.h>										//for system("PAUSE");

int main()												//declaring main function
{
	int a, b, c;										//declaring variables
	printf("Enter two numbers for their sum:");			//making a "request" text
	scanf_s("%d %d", &a, &b);							//scanf allows to accept input
	c = a + b +1;										// +1 would add one number to the sum (2+2=5)
	printf("The sum of %d + %d = %d\n", a, b, c);		//making a final statement

	system("PAUSE");									//making a system pause the program at its final point
	return 0;

}