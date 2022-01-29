//PI18E
//DZIUGAS PECIULEVICIUS
//TASK 2 BinaryTree

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>

struct node {
	int value; //the number of the node
	struct node *left;
	struct node *right;
};

struct node* newNode(int value) {
	struct node* node = (struct node*)malloc(sizeof(struct node));
	node->value = value;
	node->left = NULL;
	node->right = NULL;

	return (node);
}

void printPostorder(struct node* node) {
	if (node == NULL)
		return;
	
	printPostorder(node->left);
	printPostorder(node->right);
	printf("%d ", node->value);
}

void printInorder(struct node* node) {
	if (node == NULL)
		return;

	printInorder(node->left);
	printf("%d ", node->value);
	printInorder(node->right);
}

void printPreorder(struct node* node) {
	if (node == NULL)
		return;

	printf("%d ", node->value);
	printPreorder(node->left);
	printPreorder(node->right);
}

int main() {
	struct node *root = newNode(1);
	root->left = newNode(2);
	root->right= newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);

	printf("\nPreorder traversal of binary tree is \n");
	printPreorder(root);

	printf("\nInorder traversal of binary tree is \n");
	printInorder(root);

	printf("\nPostorder traversal of binary tree is \n");
	printPostorder(root);

	getchar();
	return 0;
}