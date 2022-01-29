//Dziugas Peciulevicius
//TASK 1

	/*
	If person has 30 or less stamina, he can only go to sleep, unless he eats (Could add this later if needed). Eating will result in +15stamina. Sleeping - +50 for example.
		If person has 31 - 50 he can only take a car
		If person has 50+ stamina he can either walk or drive

		Going to sleep will result in +50 stamina.
		Going by car -10
		Going on foot -15
		Taking a taxi -5
	*/

#include <stdio.h>
#include <stdlib.h>

char mainInput;
int inputShop;
int inputGoingHome;
char inputGoingHomeByCar;
char goingSleep;
int noSleepChoice;
int stamina;

struct Person {
	int stamina;
}person;

int main() {

	printf("This is a simple algorithm.	\n");
	printf("\nYou came back from a long day of work.	\n");

changeStats:

	printf("\nInput how much stamina you have left depending on how you feel today (0-100): \n");
	scanf_s("%d", &person.stamina);

validInput:
	printf("\n");
	printf("You have %d percent stamina	\n", person.stamina);
	printf("What are you planning on doing?	\n");
	printf("0 - Go shopping; \n1 - Go to sleep;	\n2 - EXIT;	\n");
	scanf_s(" %c", &mainInput);

	switch (mainInput) {
	case '0':
		printf("\n");
		printf("You're going shopping. Are you taking a car or walking?	\n");
		printf("0 - Taking a car; \n1 - Walking to the shop; \n2 - I don't want to go shopping; \n");
		scanf_s("%d", &inputShop);
		if (inputShop == 0) {
			if (person.stamina <= 30) {
				printf("\n");
				printf("You don't have enough stamina. You need to either sleep or eat.	\n");
				goto validInput;
			} else if (person.stamina >= 31) {
				printf("\n");
				printf("You have went shopping by car!	\n");
				person.stamina = person.stamina - 10;
				printf("Left %d stamina	\n", person.stamina);
				
				printf("Now you need to go home and sleep since you have work tomorrow. Good night! \n");
				system("PAUSE");
				exit(1);
			} else {
				printf("Please enter a valid input");
				goto validInput;
			}
		} else if (inputShop == 1) {
			if (person.stamina <= 30) {
				printf("\n");
				printf("You don't have enough stamina to go shopping. You need to either sleep or eat.	\n");
				goto validInput;
			} else if (person.stamina >= 31 && person.stamina <= 50) {
				printf("\n");
				printf("You can only go shopping by car! Choose another option.	\n");
				goto validInput;
			} else {
				printf("\n");
				printf("You have went shopping on foot!	\n");
				person.stamina = person.stamina - 15;
				printf("Left %d stamina	\n", person.stamina);
			}
			validInputForGoingHome2:
				printf("\n");
				printf("\nHow are you comming back home?	\n");
				printf("0 - Taking a taxi; \n1 - Walking home; \n");
				//If needed could add money too
				scanf_s("%d", &inputGoingHome);
				if (inputGoingHome == 0) {
					printf("\n");
					printf("You're going home by taxi	\n");
					person.stamina = person.stamina - 5;
					printf("You came back home and you have %d stamina left\n", person.stamina);
				inputSleep:
					printf("\n");
					printf("\nDo you want to go to sleep now?	\n");
					printf("Yes - y; No - n;	\n");
					scanf_s(" %c", &goingSleep);
					if (goingSleep == 'y') {
						printf("\n");
						printf("You have went to sleep, because you have work tomorrow!	\n");
						printf("Good night!\n");
						system("PAUSE");
						exit(1);
					} else if (goingSleep == 'n') {
						printf("\n");
						printf("What do you want to do then?\n");
					movieOrEat:
						printf("\n");
						printf("0 - Watch a movie; \n1 - Eat;\n2 - Changed my mind, going to sleep;	\n");
						scanf_s("%d", &noSleepChoice);
						if (noSleepChoice == 0) {
							printf("\n");
							person.stamina = person.stamina + 5;
							printf("You've watched a movie and now have %d stamina!	\n", person.stamina);
							printf("Now you need to go to sleep, because you got work tomorrow! \n");
							system("Good night!	\n");
							system("PAUSE");
							exit(1);
						} else if (noSleepChoice == 1) {
							printf("\n");
							person.stamina = person.stamina + 15;
							printf("You ate dinner and now you have %d stamina!	\n", person.stamina);
							printf("Now you need to go to sleep, because you got work tomorrow! \n");
							system("Good night!	\n");
							system("PAUSE");
							exit(1);
						}  else if (noSleepChoice == 2) {
							printf("\n");
							printf("You changed your mind and you're going to sleep! Good night!	\n");
							system("PAUSE");
							exit(1);
						} else {
							printf("\n");
							printf("Enter a valid input (0-2):\n");
							goto movieOrEat;
						}
					} else {
						printf("\n");
						printf("Please enter a valid input (y/n)	\n");
						goto inputSleep;
					}
				} else if (inputGoingHome == 1) {
					printf("\n");
					printf("You're going home on foot	\n");
					person.stamina = person.stamina - 15;
					printf("You came back home and you have %d stamina left\n", person.stamina);
				sleep1:
					printf("\n");
					printf("\nDo you want to go to sleep now?	\n");
					printf("Yes - y; No - n;	\n");
					scanf_s(" %c", &goingSleep);
					if (goingSleep == 'y') {
						printf("\n");
						printf("You have went to sleep, because you have work tomorrow!	\n");
						printf("Good night!\n");
						system("PAUSE");
						exit(1);
					} else if (goingSleep == 'n') {
						printf("\n");
						printf("What do you want to do then?\n");
						printf("0 - Watch a movie; \n1 - Eat;2 - Changed my mind, going to sleep	\n");
						scanf_s("%d", &noSleepChoice);
						if (noSleepChoice == 0) {
							printf("\n");
							person.stamina = person.stamina + 5;
							printf("You've watched a movie and now have %d stamina!	\n", person.stamina);
							printf("Now you need to go to sleep, because you got work tomorrow! \n");
							printf("Good night!	\n");
							system("PAUSE");
							exit(1);
						} else if (noSleepChoice == 1) {
							printf("\n");
							person.stamina = person.stamina + 15;
							printf("You ate dinner and now you have %d stamina!	\n", person.stamina);
							printf("Now you need to go to sleep, because you got work tomorrow! \n");
							printf("Good night!	\n");
							system("PAUSE");
							exit(1);
						} else if (noSleepChoice == 2) {
							printf("\n");
							printf("You changed your mind and you're going to sleep! Good night!	\n");
							system("PAUSE");
							exit(1);
						} else {
							printf("\n");
							printf("Enter valid input (0-2):\n");
							goto sleep1;
							system("PAUSE");
							exit(1);
						}
					} else {
						printf("\n");
						printf("PLease enter a valid input (y/n)	\n");
						goto sleep1;
					}
				} else {
					printf("\n");
					printf("Please enter a valid input (0-1)");
					goto validInputForGoingHome2;
				}
		} else if (inputShop == 2) {
			printf("\n");
			printf("You don't want to go shopping.  What do you want to do then?	\n");
			goto validInput;
		} else {
			printf("\n");
			printf("Please enter a valid integer value (0-2)	\n");
			goto validInput;
		}
		break;
	case '1':
	sleep:
		if (person.stamina <= 30) {
			printf("\n");
			printf("You're going to sleep. \n");
			person.stamina = person.stamina + 50;
			printf("You woke up and gained 50 stamina. \n");
			goto validInput;
		} else if (person.stamina >=31 && person.stamina <=50) {
			printf("\n");
			printf("You still have energy to take a car to the shop. Are you sure you want to go to sleep? \n");
			printf("Y - yes;	\nN - no;	\n");
			scanf_s(" %c", &goingSleep);
			if (goingSleep == 'y') {
				printf("\n");
				printf("You're going to sleep.		\n");
				person.stamina = person.stamina + 50;
				printf("You woke up and gained 50 stamina. \n");
				goto validInput;
			} else if (goingSleep == 'n') {
				printf("\n");
				printf("What else are you planning on doing then?	\n");
				goto validInput;
			} else {
				printf("\n");
				printf("Please enter a valid input(y/n)	\n");
				goto sleep;
			}
		} else if (person.stamina >= 51) {
			printf("\n");
			printf("You still have energy to take a car or walk to the shop. Are you sure you want to go to sleep? \n");
			printf("Y - yes;	\nN - no;\n");
			scanf_s(" %c", &goingSleep);
			if (goingSleep == 'y') {
				printf("\n");
				printf("You're going to sleep.		\n");
				person.stamina = person.stamina + 50;
				printf("You woke up and gained 50 stamina. \n");
				goto validInput;
			} else if (goingSleep == 'n') {
				printf("\n");
				printf("What else are you planning on doing then?	\n");
				goto validInput;
			} else {
				printf("\n");
				printf("Please enter a valid input(y/n)	\n");
				goto sleep;
			}
		} else {
		system("PAUSE");
		exit(1);
		}
		break;
	case '2':
		exit(1);
		break;
	default:
		printf("Please enter a valid input.	\n");
		goto validInput;
		break;
	}
}