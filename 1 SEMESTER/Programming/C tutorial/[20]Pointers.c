#include <stdio.h>
#include <stdlib.h>


///Pointer is basically is a type of data that we can use inside of our programs
///Pointer - data type
///Pointer - is a Memory address (physical address inside of our computer memory where we store value)
int main(){

///integer variable is storing integer value of 30
    int age = 30;
    int * pAge = &age;
    double gpa = 3.4;
    double * pGpa = &gpa;
    char grade = 'A';
    char * pGrade = &grade;
///We can store pointers inside a pointer variable
///When we create pointer variable, we need to a physical memory address


    printf("Age's memory address: %p\n", &age);
    return 0;
}
