package com.geekbrains.krilov.algorythms.homework6;

public class Main {

    static final int MIN = -25;
    static final int MAX = 25;
    static final int DEPTH = 4;
    static final int GENERATOR_LIMIT = 15;

    public static void main(String[] args) {
        generateTree(DEPTH, GENERATOR_LIMIT, MIN, MAX).display();
    }

    static Tree<Integer> generateTree(int depth, int numbersLimit, int minNumber, int maxNumber) {

        Tree<Integer> tree = new TreeImpl<>(DEPTH);

        for (int i = 0; i < 15; i++) {
            tree.add(rnd(MIN, MAX));
        }

        return tree;
    }

    static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}

