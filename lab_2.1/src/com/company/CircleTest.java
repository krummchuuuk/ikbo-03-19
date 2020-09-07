package com.company;

class Circle {
    private int center_x = 0;
    private int center_y = 0;
    private int radius = 5;

    public void set_center(int x, int y)
    {
        center_x=x;
        center_y=y;
    }

    public void set_radius (int R)
    {
        radius = R;
    }

    public int get_x()
    {
        return center_x;
    }
    public int get_y()
    {
        return center_y;
    }

    public int get_radius()
    {
        return radius;
    }
}
public class CircleTest
{
    public static void main(String[] args)
    {
        Circle circ = new Circle();
        circ.set_center(5, 6);
        circ.set_radius(10);
        System.out.print("Center: {"+circ.get_x()+";"+circ.get_y()+"}, Radius = "+circ.get_radius());
    }
}
