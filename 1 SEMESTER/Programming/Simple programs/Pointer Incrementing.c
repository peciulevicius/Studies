/*
	 INCREMENTING A POINTER
		2018-11-07
 */

#define _CRT_SECURE_
//it will switch off all secure warnings for use of non-secure functions
#include <stdio.h>
#include <stdlib.h>

const int MAX = 3;
int main()
{
	int var[] = { 10, 100, 200 };
	int i, *ptr;
	//let us have array adress in pointer
	ptr = var;

	for (i=0; i < MAX; i++)
	{
		printf("Adress of var[%d] = %x\n", i, ptr);
		printf("Value of var[%d] = %d\n", i, *ptr);
		//move to the next location
		ptr++;
	}
	system("PAUSE");
	return 0;
}
