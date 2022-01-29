/*
		Making a robot move using input keys
*/

#include <stdio.h>
#include <stdlib.h>

void goForward() {
	printf("Im going forward\n");
}
void goBackwards() {
	printf("Im going backwards\n");
}
void goLeft() {
	printf("Im going left\n");
}
void goRight() {
	printf("Im going right\n");
}

//These void functions have to be the same later on in the switch case

void main() {
	int input; //Input can be changed to for example choose.direction
	printf("Make a robot go Forwards - 1; Backwards - 2; Left - 3; Rigth - 4\n");
	scanf_s("%d", &input);

	switch (input) {
	case 1: goForward();
		break;
	case 2: goBackwards();
		break;
	case 3: goLeft();
		break;
	case 4: goRight();
		break;
	default: printf("You haven't chosen the correct Input\n");
	}
	system("PAUSE");
	return 0;

}
