/*
ARRAYS WITH RANDOM NUMBERS FROM 1 TO 10
Džiugas Pečiulevičius
2018-10-17
*/


#include <stdio.h>
#include <stdlib.h>


int main(){
	int myArray[100], evenArray[100], oddArray[100];
	int i, j, k;
	
	// 1.    
	//loop --> int array[100] --> random numbers from 1 to 10
	
	for (i = 0; i < 100; i++){
		
		myArray[i] = rand() % 10;
	}
	for (i = 0; i < 100; i++) {

		printf("%-6d", myArray[i]);
	}
	
	// 2. 
	//loop --> int even[100]
	//loop --> int odd[100]

	j = 0;
	k = 0;
	for (i = 0; i < 100; i++) {
		if (myArray[i] % 2 == 0)
		{
			evenArray[j] = myArray[i];
			j++;
		}
		else
		{
			oddArray[k] = myArray[i];
			k++;
		}
	}

	// 3.
	// Print initial array 
	// Print even & odd array
	
	printf("Even numbers:\n");
	for(i = 0; i < j; i++)
	{
		printf("%2d", evenArray[i]);
	}
	
	printf("\n");
	
	printf("Odd numbers:\n");
	for(i = 0; i < k; i++)
	{
		printf("%2d", oddArray[i]);
	}
	
	printf("\n");
	system("PAUSE");
	return 0;
}
