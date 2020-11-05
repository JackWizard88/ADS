package com.geekbrains.krilov.algorythms.homework3.util;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peekHead();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
