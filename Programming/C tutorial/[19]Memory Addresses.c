#include <stdio.h>
#include <stdlib.h>

int main(){

///C is taking all these variables in a physical memory and every variable has its own address
    int age = 30;
    double gpa = 3.4;
    char grade = 'A';

///So now we will access every variables address
///%p - pointer (we use %p to access memory address)
    printf("Age: %p\nGPA: %p\nGrade: %p", &age, &gpa, &grade);



    return 0;
}
