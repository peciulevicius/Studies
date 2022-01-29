/*
		PROGRAM THAT CALCULATES SIN AND COS
			VALUES FROM SOME ANGLES
				  2018-09-19
*/
#include <stdio.h>
#define _USE_MATH_DEFINES
#include <math.h>
#define HALF 180
#include <stdlib.h>

//math.h  must be after _USE_MATH_DEFINES to work!! and you can right click math.h and open the directory to see all available library functions there
//theres already a predefined PI value etc. ( called by M_PI)
//you can define anything you want as seen in example HALF to get a value of 180 to be used any time you want

float toRadians(int angle) { //could i have used a different name for int???
	return angle * M_PI / HALF;
}
// a function to prevent a repeating math stuff that we do down there

int main() {
	//variables
	int angle;
	float result; // using floats, TEST with double?
	printf("Input angle value:  \n");
	scanf_s("%d", &angle); 

	result = sin(toRadians(angle)); // using function and int value to put inside the function
	printf("sin value : %f \n", result); // %f is for printing floats
	result = cos(toRadians(angle));
	printf("cosine value : %f \n", result);

	system("pause");

	return 0;


}