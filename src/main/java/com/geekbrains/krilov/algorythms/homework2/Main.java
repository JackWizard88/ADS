package com.geekbrains.krilov.algorythms.homework2;

import com.geekbrains.krilov.algorythms.homework2.utils.MyArray;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        MyArray<Integer> initialArray= createTestIntegerArray(100000, 1000);

        MyArray<Integer> bubbleArray = initialArray.copyOf();
        MyArray<Integer> selectArray = initialArray.copyOf();
        MyArray<Integer> insertArray = initialArray.copyOf();

        long startTime = System.currentTimeMillis();
        System.out.print("Сортировка пузырьком: ...   ");
        bubbleArray.sortBubble();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("%s мс", (endTime - startTime)));

        startTime = System.currentTimeMillis();
        System.out.print("Сортировка выбором: ...   ");
        selectArray.sortSelect();
        endTime = System.currentTimeMillis();
        System.out.println(String.format("%s мс", (endTime - startTime)));

        startTime = System.currentTimeMillis();
        System.out.print("Сортировка вставками: ...   ");
        insertArray.sortInsert();
        endTime = System.currentTimeMillis();
        System.out.println(String.format("%s мс", (endTime - startTime)));
    }

    static MyArray<Integer> createTestIntegerArray(int size, int bounds) {
        MyArray<Integer> arr = new MyArray<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(bounds));
        }
        return arr;
    }

}
