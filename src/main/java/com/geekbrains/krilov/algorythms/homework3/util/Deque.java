package com.geekbrains.krilov.algorythms.homework3.util;

public interface Deque<E> extends Queue<E> {

    boolean insertFirst(E value);

    boolean insertLast(E value);

    E removeFirst();

    E removeLast();

    E peekFirst();

    E peekLast();

}
