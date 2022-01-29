#include <stdio.h>
#include <stdlib.h>

///is a collection of code that performs a specific tasks
int main() ///main is a function
{
    printf("Top\n");
    sayHi("Dziugas", 20);
    printf("Middle\n");
    sayHi("Mantas", 23);
    printf("Bottom\n");
    ///all functions get called from top to bottom in the main function
    return 0;
}

void sayHi(char name[], int age)
{
    printf("Hello %s, you are %d years old\n", name, age);
return main;
}
