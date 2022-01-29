//Class Rectangle attributes: length, width, top left corner coordinates (x, y)
//There has to be methods who return:
//-Rectangle square size (2t)
//-Rectangle perimeter (2t)
//-Diagonal length (2t)
//-Rectangle diagonals intersection coordinates (4t)
//
//EXTRA REQUIREMENT: Class Rectangle has to have single responsibility principle (5t)

package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("PLease enter the length of a rectangle: ");
        float inputLength = input.nextFloat();
        System.out.println("PLease enter the width of a rectangle:");
        float inputWidth = input.nextFloat();
        System.out.println("Length: "+ inputLength + "\nWidth: " + inputWidth);

        Rectangle rectangle1 = new Rectangle(inputLength, inputWidth, 0, 0);

        System.out.println("The perimeter of a rectangle is: " + rectangle1.getPerimeter());
        System.out.println("The square of a rectangle is: " + rectangle1.getArea());
        System.out.printf("Diagonal is: %.2f \n", rectangle1.getDiagonalLength());
        System.out.println("Rectangles intersection coordinates are X: "
                + rectangle1.getXCoordinate() + " and Y: " + rectangle1.getYCoordinate());
    }
}