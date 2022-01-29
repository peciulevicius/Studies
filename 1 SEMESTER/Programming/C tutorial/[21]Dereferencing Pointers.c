#include <stdio.h>
#include <stdlib.h>


///by dereferencing a pointer we go to the physical value and grabbing some info from the address
int main(){


    int age = 30;
    int *pAge = &age;

    1.///printf("%p", pAge);
    ///We have a pointer printed abobe and we will dereference it below
    2.///printf("%d", *pAge);
    ///^^^This is dereferenced pointer which prints 30

    return 0;
}
