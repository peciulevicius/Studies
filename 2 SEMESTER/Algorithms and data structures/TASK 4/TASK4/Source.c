//task4
#define _CRT_SECURE_NO_WARNINGS

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<string.h>
#include<dos.h>


struct stud {
	int rn, id, ph;
	char add[30], na[20], d[15], in[5];
	struct stud *next;
}*h = NULL, *p, *q, *t;

void add()
{
	int ts = 0;
	//clrscr();
	p = (struct stud *) malloc(sizeof(struct stud));
	printf("\nEnter the Initials of Student : ");
	scanf("%s", &p->in);
	printf("\nEnter the Last Name of Student : ");
	scanf("%s", &p->na);
	printf("\nEnter the ID of Student : ");
	scanf("%d", &p->id);
	printf("\nEnter the Roll No. of Student : ");
	scanf("%d", &p->rn);
	printf("\nEnter the Phone No. of Student : ");
	scanf("%d", &p->ph);
	printf("\nEnter the Address of Student : ");
	scanf("%s", &p->add);
	printf("\nEnter the D.O.B. of Student(dd/mm/yyyy) : ");
	scanf("%s", &p->d);

	p->next = NULL;

	if (h == NULL)
	{
		h = p;
	}
	else
	{
		q = h;
		while (q->next != NULL)
			q = q->next;
		q->next = p;
	}
	ts++;
}

void delAt(int r)
{
	int ts = 0;
	q = h;
	while ((q->next)->rn != r || q == NULL) {
		q = q->next;
	}
	if ((q->next)->rn == r) {
		q->next = (q->next)->next;
		printf("\n\nRecord Deleted.");
		ts--;
	} else {
		printf("\n\nRecord Not Found.");
	}
	ts--;
}

void modAt(int id)
{
	q = h;
	int ch;
	while (q->id != id && q != NULL)
		q = q->next;
	if (q->id == id)
	{
		//clrscr();
		printf("******* MODIFY *******\n1.Name Initials\n2.Last Name");
		printf("\n3.Roll No.\n4.Phone\n5.Add\n6.D.O.B.:\nEnter choice: ");
		scanf("%d", &ch);
		switch (ch)
		{
		case 1:  printf("\n\nEnter the Initials of Student : ");
			scanf("%s", &q->in); 
			break;
		case 2:  printf("\nEnter the Last Name of Student : ");
			scanf("%s", &q->na); 
			break;
		case 3:  printf("\nEnter the Roll No. of Student : ");
			scanf("%d", &q->rn); 
			break;
		case 4:  printf("\nEnter the Phone No. of Student : ");
			scanf("%d", &q->ph); 
			break;
		case 5:  printf("\nEnter the Address of Student : ");
			scanf("%s", &q->add);
			break;
		case 6:  printf("\nEnter the D.O.B. of Student(dd/mm/yyyy) : ");
			scanf("%s", &q->d); 
			break;
		}
	}
	else
		printf("\nRecord not Found.");
}

void search(char ni[5])
{
	int flag = 0;
	q = h;
	//clrscr();
	while (q != NULL)
	{
		if (_stricmp(q->in, ni) == 0)
		{
			flag = 1;
			printf("\n\nInitals of Student :   %s ", q->in);
			printf("\n\nLast Name of Student : %s ", q->na);
			printf("\n\nID of Student :        %d ", q->id);
			printf("\n\nRoll No. of Student :  %d", q->rn);
			printf("\n\nPhone No. of Student :    %d", q->ph);
			printf("\n\nAddress of Student :   %s", q->add);
			printf("\n\nD.O.B. of Student :    %s", q->d);
			printf("\n\n\n");
		}
		q = q->next;
	}
	if (flag == 0)
		printf("\n\nNo Match Found.");
}

void sort()
{
	p = h;
	while (p != NULL)
	{
		q = h;
		while (q != NULL)
		{
			if (_stricmp(q->in, (q->next)->in) > 0)
			{
				strcpy(t->in, q->in);
				strcpy(t->na, q->na);
				t->id = q->id;
				t->rn = q->rn;
				t->ph = q->ph;
				strcpy(t->add, q->add);
				strcpy(t->d, q->d);


				strcpy(q->in, (q->next)->in);
				strcpy(q->na, (q->next)->na);
				q->id = (q->next)->id;
				q->rn = (q->next)->rn;
				q->ph = (q->next)->ph;
				strcpy(q->add, (q->next)->add);
				strcpy(q->d, (q->next)->d);

				strcpy((q->next)->in, t->in);
				strcpy((q->next)->na, t->na);
				(q->next)->id = t->id;
				(q->next)->rn = t->rn;
				(q->next)->ph = t->ph;
				strcpy((q->next)->add, t->add);
				strcpy((q->next)->d, t->d);

			}
			q = q->next;
		}
		p = p->next;
	}

}

void disp()
{
	p = h;
	//clrscr();
	while (p != NULL)
	{
		printf("\nInitals of Student :   %s ", p->in);
		printf("\nName of Student :      %s ", p->na);
		printf("\nID of Student :        %d ", p->id);
		printf("\nRoll No. of Student :  %d", p->rn);
		printf("\nPhone No. of Student :    %d", p->ph);
		printf("\nAddress of Student :   %s", p->add);
		printf("\nD.O.B. of Student :    %s", p->d);
		printf("\n\n");
		p = p->next;
	}
}

void main()
{
	int ch = 0, r;
	char ni[5];
	//clrscr();
	while (ch != 8)
	{
		//clrscr();
		printf("1.Add the Record.\n\n2.Add Record at Locn.\n\n3.Delete Record.");
		printf("\n\n4.Modify Record.\n\n5.Search Record.\n\n6.Sort Records.");
		printf("\n\n7.Display\n\n8.Exit");
		printf("\n\nEnter the Choice: ");
		scanf("%d", &ch);
		switch (ch)
		{
		case 1:
			add();
			break;

		//case 2:
			//printf("\nEnter the Roll No. : ");
			//scanf("%d", &r);
			//addAt(r);
			//break;
			
		case 3:
			printf("\nEnter the Roll No. : ");
			scanf("%d", &r);
			delAt(r);
			break;

		case 4:
			printf("\nEnter the ID : ");
			scanf("%d", &r);
			modAt(r);
			break;

		case 5:
			printf("\nEnter the Initials : ");
			scanf("%s", &ni);
			search(ni);
			break;

		case 6:
			sort();
			printf("\n\nSorted");
			break;
		case 7:
			disp();
			break;
		}
		_getch();
	}
	_getch();
}
