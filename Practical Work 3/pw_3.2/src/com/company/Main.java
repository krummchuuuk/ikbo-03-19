package com.company;

abstract class Shape {
    protected String color ="none";
    protected boolean filled = false;

    Shape() {}
    Shape (String color, boolean filled)  {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}
class Circle extends Shape {
    protected double radius;

    Circle() {}
    Circle(double radius) {
        this.radius = radius;
    }
    Circle (double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return (2*3.14*Math.pow(radius,2));
    }
    @Override
    public double getPerimeter() {
        return (2*3.14*getRadius());
    }

    @Override
    public String toString() {
        return "Circle{" +"radius=" + radius +'}';
    }
}

class Rectangle extends Shape{
    protected double width;
    protected double length;

    Rectangle() {}
    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return width*length;
    }
    @Override
    public double getPerimeter() {
        return 2*(width+length);
    }
    @Override
    public String toString() {
        return "Rectangle{" +"width=" + width +", length=" + length +", perimeter= "+getPerimeter() +", area= "+getArea()+'}';
    }
}

class Square extends Rectangle {
    protected double side;

    Square() {}
    Square(double side)
    {
        this.side = side;
    }
    Square(double side, String color, boolean filled) {
        this.side = side;
        this.color = color;
        this.filled = filled;
    }
    public void setSide(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }
    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square{" + "color=" + color  +  ", side=" + side +  ", perimeter= "+getPerimeter()+ ", area= "+getArea()+'}';
    }
}

public class Main {

    public static void main(String[] args) {
    }
}
