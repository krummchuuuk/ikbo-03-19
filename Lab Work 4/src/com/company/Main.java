package com.company;

class Milk implements Priceable {
    private int price;
    private String firm;

    Milk(int price, String firm) {
        this.price = price;
        this.firm = firm;
    }
    @Override
    public int getPrice() {
        return price;
    }
}

class Cheese implements Priceable {
    private int percent;
    private int price;

    Cheese (int percent, int price) {
        this.percent = percent;
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }
}

public class Main {

    public static void main(String[] args) {
	Milk milk = new Milk(50, "Lactomilk");
	Cheese cheese = new Cheese(30,180);
	System.out.print("This milk is "+milk.getPrice()+". This cheese is "+cheese.getPrice());
    }
}
