/*
	C program to find sum of two numbers using command line arguments
				DŽIUGAS PEČIULEVIČIUS
					2018-10-02
*/

//Open CMD
//Change directory to Debug folder in CMD
//Type in dir
//Type in filename.exe and numbers for their sum ((FileName.exe 2 2    or FileName.exe 150 555))

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) //Main CMD command
{
	int a, b, sum; //Input
	{
		if (argc != 3)
			printf("please use \"prg_name value1 value2 \"\n");
		return 0;
	}

	a = atoi(argv[1]);
	b = atoi(argv[2]);
	sum = a + b;

	printf("Sum of %d, %d is: %d\n", a, b, sum);

	system("pause");
	return 0;
}
