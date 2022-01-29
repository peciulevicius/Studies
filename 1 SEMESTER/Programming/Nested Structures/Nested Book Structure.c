#include <stdio.h>
#define MAX 4

struct chapter {
	char chapter_name[15];
	int chapter_page;
	char best_character[15];
};

struct book {
	char title[15];
	char author[20];
	int pages;
	float price;
}book[MAX];

void main() {
	int randInd;
	char *v[MAX] = { "Star wars", "Harry Potter", "Lord of the rings", "Hamlet" };
	char *a[MAX] = { "Me", "You", "Some guy", "Girl" };
	int p[10] = { 22, 57, 185, 77, 666, 124, 68, 32, 44, 785 };
	
	for (int i = 0; i < MAX; i++) {
		randInd = rand() % MAX;
		strcpy(book[i].title, v[randInd]);
		strcpy(book[i].author, a[randInd]);
		book[i].pages = p[randInd];
	};
	
	for (int i = 0; i < MAX; i++) {
		printf("Title: %s\n", book[i].title);
		printf("Author: %s\n", book[i].author);
		printf("Pages: %d\n\n", book[i].pages);
	};
	system("PAUSE");
}