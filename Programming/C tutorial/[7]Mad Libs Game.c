#include <stdio.h>
#include <stdlib.h>


///a game where there are random words and then we just put random words into a story
int main()
{
    char color[20];
    char pluralNoun[20];
    char celebrityFirstName[20];
    char celebrityLastName[20];

    printf("Enter a color: ");
    scanf("%s", color);
    printf("Enter a plural noun: ");
    scanf("%s", pluralNoun);
    printf("Enter a celebrity: ");
    scanf("%s%s", celebrityFirstName, celebrityLastName);

    printf("Roses are %s\n", color);
    printf("%s are blue\n", pluralNoun);
    printf("I love %s %s\n", celebrityFirstName, celebrityLastName);
    ///needs updation so it can either grab one or both names, because it only works if two names are entered

    return 0;
}
