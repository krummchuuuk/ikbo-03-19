package com.company;

abstract class Dog
{
    protected String name;
    protected String color;
    protected String voice;

    Dog() {}
    Dog(String name, String color, String voice)
    {
        this.name = name;
        this.color = color;
        this.voice = voice;
    }
    public void setVoice(String voice) {
        this.voice = voice;
    }
    public String getVoice()
    {
        return (voice+"-"+voice);
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor()
    {
        return color;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public String toString()
    {
        return "Hello, my name is "+name+". Im "+color+". "+voice+"-"+voice;
    }
}

class Dalmatian extends Dog {
    private int count_birthmark;
    Dalmatian (int count_birthmark) {
        this.count_birthmark = count_birthmark;
    }
    public int getCount_birthmark() {
        return count_birthmark;
    }
}
class Husky extends Dog {
    private String Eyes_color;
    Husky(String Eyes_color) {
        this.Eyes_color = Eyes_color;
    }
    public String getEyes_color() {
        return Eyes_color;
    }
}

public class Main
{
    public static void main(String[] args)
    {
	    Dalmatian dog1 = new Dalmatian(40);
	    dog1.setColor("white");
	    dog1.setName("Dalma");
	    dog1.setVoice("Woof");

	    Husky dog2 = new Husky("blue");
        dog2.setColor("brown");
        dog2.setName("Hatiko");
        dog2.setVoice("Gaf");

        System.out.print(dog1.toString()+"\n"+dog2.toString());
    }
}
