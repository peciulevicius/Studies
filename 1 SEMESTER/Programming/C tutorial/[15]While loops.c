#include <stdio.h>
#include <stdlib.h>

///While loops is a structure which allows us to loop over and continuely execute a specific block of code until a certein condition is false
int main(){

    int index = -2;
    /*
    while(index <= 5){
        printf("%d\n", index);
        index++; /// index = index + 1;
    }
    */
    ///Theres a similar loop with do while
    do{
        printf("%d\n", index);
        index++; /// index = index + 1;
    }while(index <= 5);



    return 0;
}
