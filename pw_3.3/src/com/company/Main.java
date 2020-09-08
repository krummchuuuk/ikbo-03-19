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
    Square() {}
    Square(double side)
    {
        this.width = side;
    }
    Square(double side, String color, boolean filled) {
        this.width = side;
        this.color = color;
        this.filled = filled;
    }
    public void setSide(double side) {
        this.width = side;
    }
    public double getSide() {
        return width;
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
        return "Square{" + "color=" + color  +  ", side=" + width +  ", perimeter= "+getPerimeter()+ ", area= "+getArea()+'}';
    }
}

public class Main {

    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius());

        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        //Shape s2 = new Shape();

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getLength());

        Rectangle r1 = (Rectangle)s3;
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide());

        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide());
        System.out.println(r2.getLength());

        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());
    }
}
