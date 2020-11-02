package com.geekbrains.krilov.algorythms.homework3;

import com.geekbrains.krilov.algorythms.homework3.util.Deque;
import com.geekbrains.krilov.algorythms.homework3.util.DequeImpl;
import com.geekbrains.krilov.algorythms.homework3.util.Stack;
import com.geekbrains.krilov.algorythms.homework3.util.StackImpl;

import java.util.Scanner;

public class Main {

    private static final String TEXT_TO_FLIP = "Курс евро на Московской бирже поднялся выше 93,7 рубля, обновив максимум с декабря 2014 года.";

    public static void main(String[] args) {
        //text flip
        System.out.println("Переворот стеком: " + flipText(TEXT_TO_FLIP));
        flipTextSimple(TEXT_TO_FLIP);

        //Deque test
        Deque<Integer> deque = new DequeImpl<>(5);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.toString());
        System.out.println(deque.insertLast(2));
        System.out.println(deque.toString());
        System.out.println(deque.insertLast(3));
        System.out.println(deque.toString());
        System.out.println(deque.insertFirst(4));
        System.out.println(deque.toString());
        System.out.println(deque.insertFirst(5));
        System.out.println(deque.toString());
        System.out.println(deque.insertLast(7));


        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());
        System.out.println("Size: " + deque.size());
        System.out.println("Is full: " + deque.isFull());

        System.out.println(deque.toString());

        while (!deque.isEmpty()) {
//            System.out.print(deque.removeLast() + " ");
            System.out.print(deque.removeFirst() + " ");
        }

    }

    //переворот строки через стек
    static String flipText(String text) {

        Stack<Character> stack = new StackImpl<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }


    //переворот строки циклом
    static void flipTextSimple(String text) {
        System.out.print("Переворот циклом: ");
        for (int i = text.length() - 1; i >= 0 ; i--) {
            System.out.print(text.charAt(i));
        }
        System.out.println(System.lineSeparator());
    }

}
