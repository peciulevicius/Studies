#include <stdio.h>
#include <stdlib.h>

///Return statement is a special line of code which will allow us to retun information to whenewher who called it
///We want to use this function above the main function
double cube(double num){
    double result = num * num * num;
    return result;
}
int main() {
    ///its a special line of code which will allow us to return information to a function or anything who called it
    //2^3 -> 2 * 2 * 2
    ///we used void return type before which doesnt return any info

    printf("Answer: %f", cube(3.0));
   ///^^^this calls the double cube function
    return 0;
}
