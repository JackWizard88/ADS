package com.geekbrains.krilov.algorythms.homework5.backpack;


import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int capacity;
    private int bestPrice;
    private List<Item> bestItems = null;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public List<Item> getBestItems() {
        return this.bestItems;
    }

    private int calcWeight(List<Item> items) {
        int result = 0;
        for (Item item : items) {
            result += item.getWeight();
        }
        return result;
    }

    private int calcPrice(List<Item> items) {
        int result = 0;
        for (Item item : items) {
            result += item.getPrice();
        }
        return result;
    }

    private void checkList(List<Item> items) {
        if (this.bestItems == null) {
            if (this.calcWeight(items) <= this.capacity) {
                this.bestItems = items;
                this.bestPrice = this.calcPrice(items);
            }
        } else {
            if (this.calcWeight(items) <= this.capacity && this.calcPrice(items) > this.bestPrice) {
                this.bestItems = items;
                this.bestPrice = this.calcPrice(items);
            }
        }
    }

    public void processList(List<Item> items) {
        if (items.size() > 0) {
            this.checkList(items);
            for (int i = 0; i < items.size(); i++) {
                List<Item> newSet = new ArrayList<>(items);
                newSet.remove(i);
                processList(newSet);
            }
        }
    }

}
