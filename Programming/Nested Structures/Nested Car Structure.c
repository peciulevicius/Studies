#define _CRT_SECURE_NO_WARNINGS
#include <stdlib.h>
#include <stdio.h>
#include <string.h>



struct Car {
	char carName[20];
	char driverName[50];
	int currentSpeed;
	int isAccelerating;
	int isBraking;
};

struct raceTrack {
	char name[50];
	int length;
	int corners;
	struct Car racers[6];
}Tracks[2];

//initialize from arrays
int main() {

	/*
	create arrays with various variables, select random one and assign to correct structure
	variable.
	*/
	srand(time(NULL)); // seed different random number, helps generate true randomness
	char carArr[][50] = {
					"BMW m3",
					"Nissan 240SX",
					"Nissan R32 GTR",
					"Nissan 350Z"
	};
	char driverArr[][50] = {
					"Daly driver",
					"Stance guy",
					"Drag racer",
					"Drifter"
	};

	char trackName[][50] = {
					"City streets",
					"Parking lots",
					"Dirt track",
					"Oval"
	};

	int lengthArr[] = { 100,500,666,50,999 };
	int cornersArr[] = { 0,10,15,60,250 };

	int i = 0, j = 0, randomizer = 0;

	for (i = 0; i < 2; i++) {

		randomizer = rand() % 3;
		strcpy(Tracks[i].name, trackName[randomizer]);
		randomizer = rand() % 4;
		Tracks[i].corners = cornersArr[randomizer];
		randomizer = rand() % 5;
		Tracks[i].length = lengthArr[randomizer];
		for (j = 0; j < 6; j++) {
			randomizer = rand() % 3;
			strcpy(Tracks[i].racers[j].carName, carArr[randomizer]);
			randomizer = rand() % 3;
			strcpy(Tracks[i].racers[j].driverName, driverArr[randomizer]);
		}
	}
	//printing
	for (i = 0; i < 2; i++) {

		printf("Name: %s \t Corners: %d \t Length: %d \n", Tracks[i].name, Tracks[i].corners, Tracks[i].length);
		for (j = 0; j < 6; j++) {
			printf("Driver %d : %s \t Car : %s \n", j + 1, Tracks[i].racers[j].driverName, Tracks[i].racers[j].carName);

		}
	}

	system("pause");
	return 0;
}