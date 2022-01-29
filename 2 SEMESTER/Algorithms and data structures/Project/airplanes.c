#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Airplanes
{
	int shortrange;
	int midrandge;
	int longrange;
} a;
struct User_info {
	int money;
	int day;
}m;

void Fly(int);
void Show_airplanes();
void Menu();
void Airplane_shop();
int random(int, int);
//New funcitons
void Set_default();
void New_day();
void End_stats();

void Airplane_shop() {
	int option;

	printf("Welcome to Airplane shop\n");
	printf("You have %d\n", m.money);
	printf("Would you to buy an airplane?\n");
	do {

		printf("1- 'Small-range': 1000 money  2- 'Mid-range':2500 money 3- 'Long-range': 5000 money\n");
		printf("4- Exit the shop\n");
		scanf_s(" %d", &option);
		switch (option)
		{
		case 1:
			if (m.money >= 1000) {
				printf("You bought small-range airplane\n");
				m.money = m.money - 1000;
				a.shortrange = a.shortrange + 1;
				printf("You have left %d money\n", m.money);

			}
			else {
				printf("You don't have enough money\n");

			}
			break;
		case 2:
			if (m.money >= 2500) {
				printf("You bought mid-range airplane\n");
				m.money = m.money - 2500;
				a.midrandge = a.midrandge + 1;
				printf("You have left %d money\n", m.money);


			}
			else {
				printf("You don't have enough money\n");

			}
			break;
		case 3:
			if (m.money >= 5000) {
				printf("You bought long-range airplane\n");
				m.money = m.money - 5000;
				a.longrange = a.longrange + 1;
				printf("You have left %d money\n", m.money);

			}
			else {
				printf("You don't have enough money\n");

			}

			break;
		case 4:
			return;
		}


	} while (1);


}

void Fly(int done) {
	//when user will choose to fly, if done is 0, it will work, if 1 - doesn't work owo
	int passengers = 0;
	int total_p = 0;
	//how much the ticket to the plane for one person costs
	int ticket_cost = 50;
	//how much income do we get
	int income = 0;

	//ammount of people min and max in each type of plane. We can change it as we like
	int short_passengers_min = 1;
	int short_passengers_max = 10;
	int mid_passengers_min = 10;
	int mid_passengers_max = 30;
	int long_passengers_min = 30;
	int long_passengers_max = 150;


	if (done == 0) {
		for (int i = 0; i < a.shortrange; i++) {
			//random number of passengers
			passengers = random(short_passengers_max, short_passengers_min);
			//how much this plane produced income
			income = income + passengers * ticket_cost;
			//this is for testing, cause the random number stays the same :I
			//printf("\n%d", passengers);
			total_p += passengers;
		}
		//same as above
		for (int i = 0; i < a.midrandge; i++) {
			passengers = random(mid_passengers_max, mid_passengers_min);
			income = income + passengers * ticket_cost;
			total_p += passengers;
		}
		//-||-
		for (int i = 0; i < a.longrange; i++) {
			passengers = random(long_passengers_max, long_passengers_min);
			income = income + passengers * ticket_cost;
			total_p += passengers;
		}

		m.money = m.money + income;

		//shows the user how much they got and how many peeps flew
		printf("\nYou flew %d people in total.", total_p);
		printf("\nIncome: %d money.\n", income);
		printf("\nTotal ammount of money: %d\n", m.money);
	}
	else {
		printf("\n You've already flown today\n");
	}
}

void Show_airplanes() {
	//Shows how many airplanes you have	
	printf("\nsmol airplanes: %d\nmed airplanes:%d\nbig airplanes: %d", a.shortrange, a.midrandge, a.longrange);

}

void Menu() {
	int option;
	int done = 0;
	int airplanes = 0;

	do {
		printf("\n1 - Airplane shop\n");
		printf("2 - Show my airplanes\n");
		printf("3 - Fly\n");
		printf("4 - New day\n");
		printf("5 - Quit\n");
		printf("\nChoose an action:\n");
		scanf_s("%d", &option);
		switch (option) {
		case 1:
			Airplane_shop();
			//Counts how many airplanes you have. Used in third(3) option of this menu
			airplanes = airplanes + a.shortrange + a.midrandge + a.longrange;
			break;
		case 2:
			Show_airplanes();
			break;
		case 3:
			if (airplanes == 0){
				printf("You don't have any planes!");
			}
			else {
				Fly(done);
				//You can fly only once per day
				done = 1;
			}
			break;
		case 4:
			New_day();
			//Nulls the done variable for flying, used in third(3) option of this menu
			done = 0;
			break;
		case 5:
				printf("\nGame over!\n");
				End_stats();
				system("PAUSE");
				return 0;
		default:
			printf("Invalid option\n");

		}
	} while (1);
}


int random(int max_number, int min_number){
	srand(time(NULL));
	int x = rand() % (max_number + 1 - min_number) + min_number;
	return x;

}

void Set_default() {
//Nulls the airplanes owned
	a.shortrange = 0;
	a.midrandge = 0;
	a.longrange = 0;
//Declares starting sum of money
	m.money = 10000;
//Sets day count to one
	m.day = 1;

}

void New_day() {
	//Sleepy sleep sleep owo
	m.day++;
	printf("Day: %d\n", m.day);
	printf("A new day has started!\n");
}

void End_stats() {
	//Shows the stats of user when they quit
	printf("\nDay: %d\n", m.day);
	printf("Planes owned: %d\n", a.shortrange+a.midrandge+a.longrange);
	printf("Money: %d\n", m.money);
}

//This is cursed
//void Write_to_file() {
//
//	//don't look here
//	FILE* f = fopen("C:\Users\saule\Desktop\file.txt", "w");
//	if (f == NULL) {
//		printf("Error opening file!\n");
//		exit(1);
//	}
//
//	int i = 1;
//	fprintf(f, "Integer: %d", i);
//
//	fclose(f);
//}

int main() {

	Set_default();
	Menu();

}