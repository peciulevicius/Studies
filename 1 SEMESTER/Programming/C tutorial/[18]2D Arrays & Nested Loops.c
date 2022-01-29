#include <stdio.h>
#include <stdlib.h>

///2D Array is with elements inside which are arrays themselves
///Nested loops is loop inside of a loop
int main(){
/* 2D ARRAYS EXPLAINED BELOW*///
///Below we specify firstly that we have 3 elements in the array
///Secondly we specify that it will have two elements inside each
    int numArr[3][2] = {
                    {1, 2}, ///1 is at 0, 0 // 2 is at 0, 1
                    {3, 4}, ///3 is at 1, 0 // 4 is at 1, 1
                    {5, 6}  ///5 is at 2, 0 // 6 is at 2, 1
                    };
    printf("%d\n", numArr[2][1]); ///printing out 6
    printf("%d\n", numArr[1][1]); ///printing out 4
*/




///* NESTED LOOPS EXPLAINED BELOW*///
     int numArr[3][2] = {
                    {1, 2}, ///1 is at 0, 0 // 2 is at 0, 1
                    {3, 4}, ///3 is at 1, 0 // 4 is at 1, 1
                    {5, 6}  ///5 is at 2, 0 // 6 is at 2, 1
                    };
    int i, j;
    for(i = 0; i < 3; i++){ ///we execute this 3 times, that's many times as there are elements inside 2D array
        for(j = 0; j < 2; j++){ ///2 is for elements inside of the element number inside the arrays
            printf("%d,", numArr[i][j]);
        }
        printf("\n");
    }

    ///* More information about nested loops*///
   /*
    printf("%d", numArr[i][j]);
    we're going through the i loop one time,
    and then we go through the j loop two times.

    So the first time we go through the i for loop i = 0,
    and then we go through j loop 2 times.
    So it goes numArr [0][0], then [0][1]

    Then we go through the i loop again and it goes like this:
    numArr [1][0], then [1][1]

    And the last time it goes through the loop, it goes like this:
    numArr [2][0], then [2][1]
    */
    return 0;
}
