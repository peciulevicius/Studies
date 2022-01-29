/*
PROGRAM THAT CALCULATES SIN AND COSINE AND PRINTS IT IN A SINGLE LINE
DŽIUGAS PEČIULEVIČIUS
2018/09/26
*/

#include <stdio.h>
#define _USE_MATH_DEFINES					//defining math constants //AFTER THIS we can include <math.h> or <cmath> libraries
#include <math.h>							//library for basic mathematical operations
#define HALFHALF 180						//???
#include <stdlib.h>							//general purpose library

float toRadians(int angle) {				//???
	return angle * M_PI / HALFHALF;			//???
}

int main() {								//declaring main function
	int angle;								//declaring variables
	float resultSin;						//???
	float resultCos;						//???
	printf("Input angle value \n ");		//asking for input
	scanf_s("%d", &angle);					//scanf allows to accept input
	resultSin = sin(toRadians(angle));		//???
	resultCos = cos(toRadians(angle));		//???
	printf("Angle of %d Sin is equal %.2f and the cos is %.2f \n", angle, resultSin, resultCos); //printing a final statement
	system("PAUSE");						//making a system pause at its final point
	return 0;
}