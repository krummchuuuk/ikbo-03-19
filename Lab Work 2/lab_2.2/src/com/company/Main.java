package com.company;

class Head {
    private String eye_color ="green";
    private String hair_color = "brown";

    public void set_hair_color(String color)
    {
        hair_color = color;
    }
    public void set_eye_color(String color)
    {
        eye_color = color;
    }
    public String get_hair_color()
    {
        return hair_color;
    }
    public String get_eye_color()
    {
        return eye_color;
    }
}

class Leg {
    private int leg_size = 37;
    private String nail_color = "black";

    public void set_leg_size(int size)
    {
        leg_size = size;
    }
    public void set_nail_color(String color)
    {
        nail_color = color;
    }
    public int get_leg_size()
    {
        return leg_size;
    }
    public String get_nail_color()
    {
        return nail_color;
    }
}

class Hand {
    private int ring_count = 0;
    private String nail_color = "black";

    public void set_ring_count(int rings)
    {
        ring_count = rings;
    }
    public void set_nail_color(String color)
    {
        nail_color = color;
    }
    public int get_ring_count()
    {
        return ring_count;
    }
    public String get_nail_color()
    {
        return nail_color;
    }
}

class Human {
    public Head head = new Head();
    public Leg leg = new Leg();
    public Hand hand = new Hand();
}

public class Main {

    public static void main(String[] args) {
        Human girl = new Human();
        girl.hand.set_nail_color("red");
        girl.leg.set_leg_size(38);
        girl.head.set_eye_color("blue");
        System.out.print("Our girl has "+girl.head.get_eye_color()+" eyes, "+girl.hand.get_nail_color()+" nails. Her size of shoes is "+girl.leg.get_leg_size());
    }
}
