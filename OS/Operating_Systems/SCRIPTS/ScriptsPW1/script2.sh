#Write a script that prints the longest line in a file
#Džiugas Pečiulevičius PI18E
#!/bin/bash

clear
linenum=0
longest=0
linenuma=0
longestline=""
#defining values
while read line
do
    if [ "${#line}" -gt $longest ]
#if numbere line > than a longest line
 
   then
    	longest=${#line}
    	longestline="$line"
    	linenuma=$linenum
    fi
    linenum=$((linenum+1))
done < text2.txt
echo "$linenuma : $longestline"
