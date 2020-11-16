package com.geekbrains.krilov.algorythms.homework6;

public class Main {

    static final int NUMBER_OF_TREES = 100;      // количество деревьев в итеррации (поставил 100 чтобы была выше точность от 100%)
    static final int MAX = 25;                  // диапазон значений в дереве (тут максимум, минус будет симметричен относительно 0)
    static final int DEPTH = 4;                 // глубина дерева

    static final int GENERATOR_LIMIT = (int) (Math.pow(2, DEPTH) - 1);

    static int balancedTrees = 0;

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_TREES; i++) {
            generateTree(DEPTH, GENERATOR_LIMIT, MAX);
        }
        calculateBalancedPercent();
    }

    static void calculateBalancedPercent() {
        double percent =  100 * (balancedTrees / (double) NUMBER_OF_TREES);
        System.out.println("Процент сбалансированных деревьев: " + (int) percent + "%");
    }

    static Tree<Integer> generateTree(int depth, int numbersLimit, int maxNumber) {

        Tree<Integer> tree = new TreeImpl<>(depth);

        for (int i = 0; i < numbersLimit; i++) {
            tree.add(rnd(-maxNumber, maxNumber));
        }

        if (tree.isBalanced()) {
            balancedTrees++;
        }

        return tree;
    }

    static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}

