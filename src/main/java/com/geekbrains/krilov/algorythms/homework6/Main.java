package com.geekbrains.krilov.algorythms.homework6;

public class Main {

    static final int NUMBER_OF_TREES = 20;      // количество деревьев в итеррации
    static final int MAX = 25;                  // диапазон значений в дереве (тут максимум, минус будет симметричен относительно 0)
    static final int DEPTH = 4;                 // глубина дерева

    static final int MIN = -MAX;
    static final int GENERATOR_LIMIT = (int) (Math.pow(2, DEPTH) - 1);

    static int balancedTrees = 0;

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            generateTree(DEPTH, GENERATOR_LIMIT, MIN, MAX);
        }
        calculateBalancedPercent();
    }

    static void calculateBalancedPercent() {
        double percent =  100 * (balancedTrees / (double) NUMBER_OF_TREES);
        System.out.println("Процент сбалансированных деревьев: " + percent + "%");
    }

    static Tree<Integer> generateTree(int depth, int numbersLimit, int minNumber, int maxNumber) {

        Tree<Integer> tree = new TreeImpl<>(DEPTH);

        for (int i = 0; i < 15; i++) {
            tree.add(rnd(MIN, MAX));
        }
        if (tree.isBalanced()) {
            balancedTrees++;
        }
        return tree;
    }

    static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}

