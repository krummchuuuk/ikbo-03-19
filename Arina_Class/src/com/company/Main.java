package com.company;

class Cat
{
    private int age = 10;
    private String voice = "meow";

    public void set_age(int age)
    {
        this.age = age;
    }
    public void set_voice(String voice)
    {
        this.voice = voice;
    }
    public int get_age()
    {
        return this.age;
    }
    public String get_voice()
    {
        return this.voice;
    }
}
public class Main {

    public static void main(String[] args) {
	Cat kitten = new Cat();
	kitten.set_age(2);
    kitten.set_voice("Mrr");
    System.out.print(kitten.get_age() + " " + kitten.get_voice());
    }
}
