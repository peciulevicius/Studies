#include <stdio.h>
#include <stdlib.h>

///Structs is a data structure where we can store groups of data types in a single data structure
struct Student{
    char name[50];
    char major[50];
    int age;
    double gpa;
};

int main(){

    struct Student student1;
    student1.age = 22;
    student1.gpa = 3.2;
    strcpy(student1.name, "Jim");
    strcpy(student1.major, "Business");
    ///we cannot use strings in structures so we use string coppies


    struct Student student2;
    student2.age = 20;
    student2.gpa = 2.5;
    strcpy(student2.name, "Pam");
    strcpy(student2.major, "Art");

    printf("Student1 GPA: %f\n", student1.gpa);
    printf("Student1 name: %s\n", student1.name);

    printf("Student2 GPA: %f\n", student2.gpa);
    printf("Student2 age: %d\n", student2.age);
    printf("Student2 major: %s\n", student2.major);

    return 0;
}
