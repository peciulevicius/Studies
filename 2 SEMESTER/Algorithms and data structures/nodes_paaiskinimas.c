



struct node{
	
	int data;
	struct node* next;																	// cia tiesiog adresas/pointeris i node kuris eis poto, nes tikslas yra sukurti grandine/link list
	
}


// funkcijos tikslas :
// 1. sukurti nauja node
// 2. dabartini pirma eileje esanti node, pajudinti I prieki 1 reiksme
// 3. nauja node istatyti i 1 vieta, pries dabartini pirma node
struct node *insert_beg(struct node *start) {											// pradinis start node nusiustas cia, LABAI SVARBU!!!
	
	struct node *new_node; 																// naujas pointeris sukurtas ( kolkas neturi atminties, tuscias )
	
	
	int num;
	printf("\n Enter the data:");         												// galima ignoruot, tiesiog duomenis vienas is budu gauti
	scanf_s("%d", &num);
	
	
	new_node = (struct node *)malloc(sizeof(struct node));								// duodama vietos atmintyje new_node pointeriui tiek kiek uzima vienas pilnas struct node
	new_node->data = num;																// duodami duomenis naujam node, cia paprasta int reiksme, nesvarbu
	new_node->next = start;																// NUSIUSTAS start node (jo adresas) yra priskirtas naujo node adresui next. Kodel? - nes 
																						// funkcijos tikslas yra nauja node padaryti nauju pirmu, reiskes dabartinis pirmas (start node), bus 
																						// musu naujo node (new_node) next adresu. 
	
	
	
	start = new_node; // adresas priklausantis pirmam node yra perrasomas nauju node adresu 
	return start;	  // grazinama adreso reiksme, kas gaunasi, kad start node maine rodys i dabar tika sukurta new_node adresa, kai sita funkcija baigiasi, new node prapuola is atminties, bet 
					  // start node maine pasilieka. 
					  // Galutinis rezultas = naujas sukurtas node, tapo pirmu (start) node, buves start node, yra atmintyje, bet, kad ji pasiekti mums reikia kreiptis i start->next , nes jo
					  // adresas yra priskirtas prie to node, nera jokio kito budo pasiekti buvusi start node.
}




int main(){
	
	struct node* start; 																// kazkur main funkcijoj sukuriamas start pointeris/node
	
	start = insert_beg(start);															// kazkaip taip atrodo funkcijos iskvietimas. Atkreipk demesi, kad start = funkcijos rezultatui.
	
	system("pause");
	return 0;
}