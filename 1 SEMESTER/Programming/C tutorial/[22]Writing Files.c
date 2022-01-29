#include <stdio.h>
#include <stdlib.h>

int main(){

    FILE * fpointer = fopen("employees.txt", "a");
///FILE is datatype and we're creating a pointer to a physical file on a computer
///fpointer - file pointer (pointing memory address of employees.txt file)
///fopen - function to open a file
///First parameter (name of the file)
///Second parameter - mode:
///r -read
///w 4-write
///a -append(append info on the file)
///fclose - will remove the file from the memory and save it

///fprintf - allows to write info to a file
    fprintf(fpointer, "\nKelly, Customer Services ");


    fclose(fpointer);
    return 0;
}
