#Write a script that removes all empty files in a whole directory tree.
#Root of the tree is entered from the keyboard
#Džiugas Pečiulevičius PI18E
#!/bin/bash

clear
echo "Enter root of the directory to delete all empty files"
read dir

find $dir -empty -type f -delete

#this last line finds empty files in the $dir (directory)
#-f will test if the file exsists and if it's simple
#and then -deletes them
