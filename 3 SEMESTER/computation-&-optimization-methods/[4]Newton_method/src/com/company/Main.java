// Java program for implementation of Newton method for solving equations
package com.company;

class Main{
    static final double epsilon = 0.001;
        // x^3 - x^2 + 2

    static double function(double x){
        return x * x * x - x - 0.231;
    }

    static double derivativeFunction(double x){
        // 3*x^x - 2*x
        return 3 * x * x - 2 * x;
    }

    static void newtonRaphson(double x){
        double h = function(x) / derivativeFunction(x);
        while (Math.abs(h) >= epsilon) {

            h = function(x) / derivativeFunction(x);
            // x(i+1) = x(i) - f(x) / f'(x)  
            x = x - h;
        }

        System.out.print("The value of the root is : "
                + Math.round(x * 100.0) / 100.0);
    }

    // Guess
    public static void main (String[] args) {
        double x0 = -20;
        newtonRaphson(x0);
    }
} 