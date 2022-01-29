/*

== CMD PARAMETERS ==
PROGRAM THAT TAKES IN INTS IN CMD AND GIVES INSTANT RESULTS.
2018.09.26
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void drawLines() {
	for (int i = 0; i < 3; i++) {
		printf("////////////////// \n"); //loop for drawing some lines
	}
}

int main(int argc, char *argv[]) {
	// start program from CMD to make it work
	// programname.exe value1 value2 value3 etc. for each array value
	// argc = argument count | argv = 

	//a loop to make infinite arguments for the array and print them
	int number;
	int sumAll = 0;
	float val;
	char *ptr;
	double val2;
	//
	double valTest; // can be float and still work

	drawLines();

	for (int i = 1; i < argc; i++) {
		number = atoi(argv[i]); // convert the strings from argv array to int and print it out!
		printf("argv[%d] = %s \n", i, argv[i]);
		sumAll = sumAll + number;

	}
	printf("the sum of all equal = %d \n", sumAll); // sum of all the converted ints

	drawLines(); // simply draw lines to make it easier to read printed out results

	for (int i = 1; i < argc; i++) {
		val = atof(argv[i]); // simply takes in the string and converts it to float, nothing special here
		printf("string value equal %s, float value equal %f \n", argv[i], val);
	}
	drawLines(); 

	for (int i = 1; i < argc; i++) {
		val2 = strtod(argv[i], &ptr); //argv array holds all the strings we inputted already!!!!!!, so its all good
		printf(" the double value is %lf : \n  ", val2); //we let ptr store the string part at this point of the loop printing
		printf(" the string part is %s \n", ptr); // only needs to store the value in one cycle of the loop at the time to print out the needed result
	}											  // would need to create another array of strings to store the values, if we want to call for string parts later
												  // or simply call for argv array and convert its certain value at point of need

	drawLines();

	//
	// simply bonus testing of strtod function. Unrelated things above
	
	valTest = strtod(argv[1], &ptr); //Just takes in string, and seperates double(float) and string of it into diff vars.
	printf("double is %lf and the string part is | %s | \n", valTest, ptr); //example of calling for array values at some other time in the program
	
	return 0;

}
