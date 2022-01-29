//JAVA PROGRAM TO CALCULATE RECTANGLES PERIMETER AND SQR SIZE
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the width and the height of a rectangle to calculate its circumference and square size:");

        Scanner in = new Scanner(System.in);

        int height = in.nextInt();
        System.out.println("Entered width number:" + height);
        int width = in.nextInt();
        System.out.println("Entered length number" + width);

        System.out.println("Circumference: " + getCircumference(height, width));
        System.out.println("Square size: " + getSquareSize(height, width));
    }

    static int getCircumference(int height, int width) {
        return (2 * height) + (2 * width);
    }
    static int getSquareSize(int height, int width) {
        return height * width;
    }
}
