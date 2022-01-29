/*

		Program to calculate sin and cosine of X.
						2018/09/12

*/

#include <stdio.h>
#include <math.h>
#define PI 3.14159265
#include <stdlib.h>

int main() {

	double x, val;

	/*

	scanf_s is limited and safe way to take in inputs
	%d is placeholder/formatting for printing out an integer ( pretty much a placeholder )
	every %d becomes the int to print
	&a, &b etc in general the & is for taking in ints properly OPERATOR
	/n is the normal line break
	sin and cosine are included in math library <math.h>
	#define defines a static value which never changes throughout the program
	*/


	printf("Input the angle \n");
	scanf_s("%lf", &x);
	val = PI / 180.0;

	printf("cosine value of %lf equals %lf \n", x, cos(x*val));
	printf("sin value of %lf equals %lf \n", x, sin(x*val));

	// %lf for doubles!! same as %d for ints


	system("PAUSE");
	return 0;
}