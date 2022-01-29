package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("\nVIGENERE CIPHER (DE/EN)CRYPTOR");
        System.out.println("\n- Press 1 to encrypt a message - \n- Press 2 to decrypt a message - ");
        int input = in.nextInt();

        if (input == 1) {
            System.out.print("Enter the message without spaces that would like to be encrypted by Vigenere cipher:  ");
            String EMessage = in.next();
            System.out.print("Enter the key in UPPER Case: ");
            String key = in.next();
            String encryptMessage = encrypt(EMessage, key);
            System.out.println("The encrypted message is: " + encryptMessage);
        }
        else if (input == 2) {
            System.out.print("Enter the message without spaces that would like to be decrypted by Vigenere cipher: ");
            String DMessage = in.next();
            System.out.print("Enter the key in UPPER Case: ");
            String key = in.next();
            String decryptMessage = decrypt(DMessage, key);
            System.out.println("The decrypted message is: " + decryptMessage);
        }
        else {
            System.out.println("Wrong Input!");
        }
        in.close();
    }

    //	Encryption
    //	ASCII: "H" is 72 && "S" is 83
    //	((72-65) + (83-65)) % 26 + 65 >> Encrypted "Z"
    private static String encrypt(String Message, String Key) {
        StringBuilder EMessage = new StringBuilder();
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            EMessage.append((char) (((letter - 65) + (Key.charAt(j) - 65)) % 26 + 65));
            //EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
            j = ++j % Key.length();
        }
        return EMessage.toString();
    }

    //	Decryption
    //	Decryption Logic: Using ASCII Dec Representation:
    //	Example:
    //	ASCII: "Z" is 90 && "S" is 83
    //	(90-83+26) % 26 + 65 >> Encrypted "Z"
    private static String decrypt(String Message, String Key) {
        StringBuilder DMessage = new StringBuilder();
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            DMessage.append((char) ((letter - Key.charAt(j) + 26) % 26 + 65));
            //DMessage += (char)((letter - Key.charAt(j) + 26) % 26 + 65);
            j = ++j % Key.length();
        }
        return DMessage.toString();
    }
}