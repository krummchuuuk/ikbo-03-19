package com.company;
import java.util.LinkedList;

class Animal {
    private String type;
    private int hight;
    private int weight;

    Animal(String type, int hight, int weight) {
        this.type = type;
        this.hight = hight;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{type= " + type + ", hight=" + hight +", weight=" + weight +'}';
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList <Animal> animal = new LinkedList<>();
        animal.add(new Animal("tiger", 120, 90));
        animal.add(new Animal("horse", 180, 100));
        animal.remove(0);
        System.out.print(animal.toString());
    }
}
