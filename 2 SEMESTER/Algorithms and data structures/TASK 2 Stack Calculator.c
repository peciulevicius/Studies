#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>

#define MAXLINE 100  /* maximum lenght of line */
#define MAXVAL  100  /* stack depth */
#define MAXOP   100  /* maximum size of operand */

/* STACK */
int    sp = 0;       /* actually position of the stack */
double val[MAXVAL] = { 0 };   /* stack value */

/* STACK FUNCTION */
void   push(double);
double pop(void);

int get_line(char s[], int);

int main() {

	char   line[MAXLINE];                  /* input line */
	char   operand[MAXOP], number[MAXOP]; /* operator and number in input */
	int    i = 0, j = 0, k = 0;            /* index */
	int    len = 0, tmp;                   /* lenght of line*/
	double op2;

	while ((len = get_line(line, MAXLINE)) != EOF) {

		tmp = len;
		while (tmp-- > 0) {
			if (!isalnum(line[i]) && !isspace(line[i]))
				operand[j++] = line[i];
			i++;
		}

		tmp = len;
		i = 0;
		while (tmp-- > 0) {
			if (isdigit(line[i]))
				number[k++] = line[i];
			else
				if (k > 0) {
					number[k] = '\0';
					push(atoi(number));
					k = 0;
				}

			i++;
		}

		for (i = j - 1; i >= 0; i--) {

			switch (operand[i]) {
			case '+':
				push(pop() + pop());
				break;
			case '-':
				op2 = pop();
				push(pop() - op2);
				break;
			case '*':
				push(pop() * pop());
				break;
			case '/':
				op2 = pop();
				if (op2 > 0.0)
					push(pop() / op2);
				else
					printf("Error!! Division 0\n");
				break;
			}
		}

		printf("%lf\n", pop());
		i = k = j = 0;
	}


	return 0;
}

void push(double num) {

	if (sp < MAXVAL)
		val[sp++] = num;
	else
		printf("STAKOVERFLOW\n");
}

double pop(void) {

	if (sp >= 0)
		return val[--sp];
	else {
		printf("STAKOVERFLOW\n");
		return 0.0;
	}
}

int get_line(char s[], int lim) {

	int c, i = 0;

	while (--lim > 0 && (c = getchar()) != EOF && c != '\n')
		s[i++] = c;

	if (c == '\n')
		s[i++] = c;

	s[i] = '\0';
	return i;
}