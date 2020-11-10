package com.geekbrains.krilov.algorythms.homework5.backpack;

public class Item {

    private int price;
    private int weight;

    public Item(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Item {" +
                "weight=" + weight +
                ", price=" + price +
                "}";
    }
}
