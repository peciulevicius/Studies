#include <stdio.h>
#include <stdlib.h>


///making a user input information and then display the values for the user

int main()
{
/*
    int age;
    printf("Enter your age: ");

    ///scanf allows input for a user
    scanf("%d", &age);
    printf("You are %d years old \n", age);


    double gpa;
    printf("Enter your gpa: ");

    ///scanf allows input for a user
    ///lf tells scanf that we are looking for a double value, not int
    scanf("%lf", &gpa);
    printf("Your gpa is %f\n", gpa);


    char grade;
    printf("Enter your grade: ");
    scanf("%c", &grade);
    printf("Your grade is %c\n", grade);
*/
///*2*///
/*
    ///we specify how many characters we will want to use in []
    int name[20];
    printf("Enter your name: ");
    scanf("%s", name);
    printf("Your name is %s\n", name);
*/
///*3*///

    ///fgets will grab the whole line of text
    int name[20];
    printf("Enter your name: ");
    fgets(name, 20, stdin); ///stdin- standard input
    printf("Your name is %s\n", name);



    return 0;
}
