package com.company;

public class Rectangle {

    public float length;
    public float width;
    public float x, y; //x, y coordinates of top left rectangle corner

    public Rectangle(float length, float width, float x, float y) {
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public float getPerimeter() {
        return (2 * length) + (2 * width);
    }

    public float getArea() {
        return length * width;
    }

    public float getDiagonalLength() {
        return (float) Math.sqrt(length * length + width * width);
        //return (float) Math.sqrt(Math.pow(length, 2)+Math.pow(width, 2)); //typecast
    }

    public float getXCoordinate() {
        return x + length/2;
    }

    public float getYCoordinate() {
        return y - width/2;
    }
}