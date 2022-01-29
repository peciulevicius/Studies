// POINTERS!

#include <stdio.h>
#include <stdlib.h>

const int MAX = 3; // for the tutorials point example

// first part of lesson
void pointerBasics() {

	//	int myVar = 25, *ptrVar = &myVar; // can do it in same line like this
	//	int *ptrVar = &myVar; Different way to assign pointer 

	int myVar = 25;													// pointer operator here
	int *ptrVar; // only need * to declare it as a pointer variable. // * is a operator.Nothing else
	ptrVar = &myVar; // when assigning pointer value, dont need *with it, as its initialized already


	printf("Original value : %d \n", myVar);
	printf("pointer address : %p \n", &ptrVar);
	printf("pointer value : %p \n", ptrVar);
	printf("pointer int value : %d \n", *ptrVar); // pointer dereference operator

												  //printf("Address of  pointer %p \n" ,&ptrVar); // address
												  //printf("Value of  pointer %d \n", *ptrVar); // value in decimal



	/*

	Take note!!
	* - when applied to existing pointer, it becomes Indirection operator / dereference operator
	(looks same as pointer star)




	*/

}

/*
Pointer printing

printf("Address for ptr_one %p\n", &ptr_one);
printf("Non-Address for ptr_one %p\n", ptr_one);
printf("value for ptr_one %p\n\n", *ptr_one);

Pointer assignment!! ( have to send them the address with & )

int *ptrVar = &myVar;

*/

// second part of lesson

void pointerArrithmetic() {

//	int myVar = 25;
//	myVar++; // simply + 1 to a int number
//	ptrVar++; // moves up pointer to next variable ( mainly useful for arrays only )
			 // as memory is way too complicated in runtime, but in arrays its sequential so its NP.

//	*ptrVar = &myVar;

	int myArray[10];
	int i = 0;
	for (i = 0; i < 10; i++) {
		myArray[i] = i;
	}
	int *ptrVar = &myArray[1];
	printf("%d \n", *ptrVar);  // simple example of moving pointer value by 1 in array and pointing
	ptrVar++;				   // to the next value in the array, then printing it out
	printf("%d \n", *ptrVar);
	ptrVar++;
	printf("%d \n", *ptrVar);



}

void pointersTutorialsPoint() {

	 

		int  var[] = { 10, 100, 200 };
		int  i, *ptr;

		/* let us have array address in pointer */
		ptr = var; // automatically assigns itself to the first array value
				  // No need for any operators or anything, quick and easy assignment
				  //address of 1st element { ADDRESS } gets assigned

		for (i = 0; i < MAX; i++) {

			printf("Address of var[%d] = %x\n", i, ptr);
			printf("Value of var[%d] = %d\n", i, *ptr);

			/* move to the next location */
			ptr++;
		}


}

void pointersComparison() {

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

}

int main() {

//	pointerBasics();
//	pointerArrithmetic();
//	pointersTutorialsPoint();
	pointersComparison();
	system("pause");
}




