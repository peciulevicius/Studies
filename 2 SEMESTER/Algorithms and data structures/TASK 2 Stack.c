//PI18E
//DZIUGAS PECIULEVICIUS
//TASK 2 STACK

//HOW TO CREATE() AND DELETE() STACK


#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#define MAX 10 // Max size of a stack container
#define _CRT_SECURE_NO_WARNINGS

/*typedef struct {
	int items[MAX];
	int top;
}Stack;
//defying structure
*/

int stack[MAX], top = -1;
void push(int stack[], int item);
int pop(int stack[]);
int peek(int stack[]);
void display(int stack[]);
int isempty(int stack[]);
int isfull(int stack[]);

void push(int stack[], int item) {
	if (top == MAX - 1) {
		printf("\n STACK OVERFLOW \n");
	} else {
		top++;
		stack[top] = item;
	}
}

int pop(int stack[]) {
	int item;
	if (top == -1) {
		printf("\n STACK OVERFLOW \n");
		return -1;
	} else {
		item = stack[top];
		top--;
		return item;
	}
}

void display(int stack[]) {
	int item;
	if (top == -1) {
		printf("\n STACK OVERFLOW \n");
	} else {
		for (item = top; item >= 0; item--)
		printf("\n %d", stack[item]);
		printf("\n");
	}
}

int peek(int stack[]) {
	if (top == -1) {
		printf("\n STACK IS EMPTY \n");
		return -1;
	} else {
		return(stack[top]);
	}
}

int isempty(int stack[]) {
	if (top <= -1){
		printf("\n Stack is empty");
		return 1;
	} else{
		printf("\n Stack is not empty");
		return 0;
	}
}

int isfull(int stack[]) {
	if (top >= stack) {
		printf("\n Stack is not full");
		return 0;
	} else {
		printf("\n STACK IS FULL (OVERFLOW)");
		return 1;
	}
}

int main(int argc, char *argv[]) {

	int option, item;
	
	do {
		printf("\n \n *****MAIN MENU*****");
		printf("\n STACK OPERATIONS");
		printf("\n 1. PUSH");
		printf("\n 2. POP");
		printf("\n 3. PEEK");
		printf("\n 4. DISPLAY");
		printf("\n 5. IS EMPTY");
		printf("\n 6. IS FULL");
		printf("\n 7. EXIT");
		printf("\n Enter your option:");
		scanf_s("%d", &option);
		switch (option) {

		case 1: 
			printf("\n  Enter the number to be pushed to the stack:");
			scanf_s("%d", &item);
			push(stack, item);
			break;
		case 2: 
			item = pop(stack);
			if (item != -1)
			printf("\n The value deleted from stack is %d", item);
			break;
		case 3: 
			item = peek(stack);
			if (item != -1)
			printf("\n The value stored at top of stack is %d", item);
			break;
		case 4: 
			display(stack);
			break;
		case 5: isempty(stack);
			break;
		case 6: isfull(stack);
			break;
		case 7: exit(0);
			break;
		default:
			printf("\n\t Please Enter a Valid Choice(1-7)");
		}
	} while (1);
	return 0;
}