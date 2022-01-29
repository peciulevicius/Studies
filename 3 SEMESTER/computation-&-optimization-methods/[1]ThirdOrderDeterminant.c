//PROGRAM THAT CALCULATES A THIRD ORDER DETERMINANT
#include <stdio.h>
#define SIZE 3 //matrix size

int main() {
int A[SIZE][SIZE];
int a, b, c, d, e, f, g, h, i;
long determinant;
int row, col;

printf("Please enter elements for your 3x3 matrix: \n");

for (row = 0; row < SIZE; row++) {
for (col = 0; col < SIZE; col++){
scanf_s("%d", &A[row][col]);
}
}

a = A[0][0];	
b = A[0][1];
c = A[0][2];
d = A[1][0];
e = A[1][1];
f = A[1][2];
g = A[2][0];
h = A[2][1];
i = A[2][2];

determinant = (a*(e*i-f*h)) - (b*(d*i-f*g)) + (c*(d*h-e*g));

printf("The determinant of a 3x3 matrix is: %ld \n", determinant);
system("PAUSE");
return 0;
}