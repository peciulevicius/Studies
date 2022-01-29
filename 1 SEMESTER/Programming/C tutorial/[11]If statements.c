#include <stdio.h>
#include <stdlib.h>

///If statements is a programming structures to make decisions
int max(int num1, int num2, int num3){
    int result;

    ///&& is a logical operator and allows us to put another condition in
    if(num1 >= num2 && num1 >= num3 ){
        result = num1;
    } else if(num2 >= num1 && num2 >= num3){
        result = num2;
    } else {
        result = num3;
    }


    return result;
}

int main(){

    ///*printf("%d", max(1, 2, 3)*///

    ///we can use || (or) instead of &&
    ///&& both conditions must be true
    ///|| only one condition must be true
    ///we can use nagation marks if(!(3 < 2)) - so the ! says the statement is not true
    if(3 < 2 || 2 > 5){
        printf("True");
    } else {
        printf("False");
    }

    return 0;
}
