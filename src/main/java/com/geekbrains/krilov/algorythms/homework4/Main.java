package com.geekbrains.krilov.algorythms.homework4;

import com.geekbrains.krilov.algorythms.homework4.LinkedList.Node;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        for (Node<Integer> node: list) {
            System.out.print(node.getItem() + " ");
        }
    }
}
