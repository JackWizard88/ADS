package com.geekbrains.krilov.algorythms.homework5;

import com.geekbrains.krilov.algorythms.homework5.backpack.Backpack;
import com.geekbrains.krilov.algorythms.homework5.backpack.Item;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int BACKPACK_CAPACITY = 20;

    public static void main(String[] args) {

        System.out.println("Возведение в степень рекурсией: " + recursivePow(2, 3));

        Backpack backpack = new Backpack(BACKPACK_CAPACITY);
        List<Item> items = new ArrayList<>();

        items.add(new Item(100, 1));
        items.add(new Item(300, 4));
        items.add(new Item(500, 5));
        items.add(new Item(800, 3));
        items.add(new Item(1000, 7));
        items.add(new Item(900, 2));
        items.add(new Item(550, 6));
        items.add(new Item(350, 4));
        items.add(new Item(600, 1));
        items.add(new Item(750, 3));

        backpack.processList(items);
        System.out.println("Оптимальный набор:\n" + backpack.getBestItems());
    }


    //рекурсивное возведение в степень
    public static int recursivePow(int value, int degree) {
        return degree == 1 ? value : value * recursivePow(value, degree - 1);
    }
}
