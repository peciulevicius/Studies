#include <stdio.h>
#include <stdlib.h>

///This game will allow a user to guess the secret number until they guess it right

int main(){

    int secretNumber = 5;
    int guess;
    int guessCount = 0;
    int guessLimit = 3;
    int outOfGuesses = 0;

    while(guess != secretNumber && outOfGuesses == 0){
        if(guessCount < guessLimit){
            printf("Enter a number: ");
            scanf("%d", &guess);
            guessCount++;
        } else {
            outOfGuesses = 1; ///0/1(true/false)


        }
    }
    if(outOfGuesses == 1){
        printf("Out of guesses");
    } else {
    printf("You Win!");
    }
    return 0;
}
