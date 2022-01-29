package com.company;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double epsilon = 0.001;
        double c, f_c, f_a;

        System.out.println("Input a: ");
        double a = input.nextDouble();
        System.out.println("Input b: ");
        double b = input.nextDouble();

        while ( (b-a) > epsilon ) {
            c = (a+b)/2;           // finding Mid point

            f_c = c*c - 2.0;       // f_c = f(c)
            f_a = a*a - 2.0;       // f_a = f(a)

            if ( (f_c > 0 && f_a < 0) || (f_c < 0 && f_a > 0) ) {  // f(a) and f(mid) have different signs: move b
                b = c;
            }
            else {  // f(a) and f(mid) have same signs: move a
                a = c;
            }
            System.out.println("New interval: [" + a + " .. " + b + "]");
            // Print progress
        }
        System.out.println("Approximate solution = " + (a+b)/2 );
    }
}