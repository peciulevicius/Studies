#include <stdio.h>
#include <string.h>
#define _CRT_SECURE_NO_WARNINGS

struct{
    char author [50];
    char name [30];
    char year [10];
    int pages;
	double price;
}book1 = { "Author1", "Name1", "Year1", 529, 39.99},        //529 is a page number and 39.99 is the price of this book
book2 = { "Author2", "Name2", "Year2", 468, 46.99},
book3 = { "Author3", "Name3", "Year3", 864, 49.99};

/*
We have just defined a structure above
*/

void main()
{
	/*
	SOMETHING IS NOT WORKING IN THIS BLOCK OF GREEN TEXT, BUT THE PROGRAM WORKS CORRECTLY WITHOUT IT, SO IS IT STILL NEEDED?
	
	book1.pages = 529;
	book1.price = 39.99;
	strcpy(book1.author, "Author1");
	strcpy(book1.name, "Name1");
	strcpy(book1.year, "Year1");
	
	book2.pages = 529;
	book2.price = 39.99;
	strcpy(book2.author, "Author2");
	strcpy(book2.name, "Name2");
	strcpy(book2.year, "Year2");

	book3.pages = 529;
	book3.price = 39.99;
	strcpy(book3.author, "Author3");
	strcpy(book3.name, "Name3");
	strcpy(book3.year, "Year3");
	*/
	
	printf("%s\t", book1.author);
    printf("%s\t", book1.name);
    printf("%s\t", book1.year);
    printf("%d\t", book1.pages);
    printf("%fl\n", book1.price);

    printf("%s\t", book2.author);
    printf("%s\t", book2.name);
    printf("%s\t", book2.year);
    printf("%d\t", book2.pages);
    printf("%fl\n", book2.price);
    
    printf("%s\t", book3.author);
    printf("%s\t", book3.name);
    printf("%s\t", book3.year);
    printf("%d\t", book3.pages);
    printf("%fl\n", book3.price);
    
    /*
    OR WE COULD DO IT IN ONE LINE
    printf("Author1 %s, Name1 %s, Year1 %s, pages %d, price %fl", book1.author, book1.Year, book1.pages, book1.price};
    printf("Author2 %s, Name2 %s, Year2 %s, pages %d, price %fl", book2.author, book2.Year, book2.pages, book2.price};
    printf("Author3 %s, Name3 %s, Year3 %s, pages %d, price %fl", book3.author, book3.Year, book3.pages, book3.price};
    */



   system("PAUSE");
   return 0;
}