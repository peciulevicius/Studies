/*
 Sin and Cos int Sums
 */
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#define PI 3.14159265

int main() {
	int a, b, c, d, e;
	double x, ret, val, ret2;
	// take in ints

	scanf_s("%d %d %d %d", &a, &b, &d, &e);

	/*

	scanf_s is limited and safe way to take in inputs
	%d is placeholder/formatting for printing out an integer ( pretty much a placeholder )
	every %d becomes the int to print
	&a, &b etc in general the & is for taking in ints properly OPERATOR
	\n is the normal line break
	sin and cosine are included in math library <math.h>
	#define defines a static value which never changes through the program
	*/

	c = a + b + d + e;
	printf("The sum of %d %d %d %d = %d \n", a, b, d, e, c);

	printf("Input the angle \n");
	scanf_s("%lf", &x);
	val = PI / 180.0;
	ret = cos(x*val);
	printf("cosine value of angle %lf equals %lf \n", x, ret);

	ret2 = sin(x*val);

	printf("sin value of angle %lf equals %lf \n", x, ret2);

	// %lf for doubles!! same as %d for ints


	system("PAUSE");
	return 0;
}
