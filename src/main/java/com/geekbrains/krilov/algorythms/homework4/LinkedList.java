package com.geekbrains.krilov.algorythms.homework4;

import com.geekbrains.krilov.algorythms.homework4.LinkedList.Node;
import java.util.Iterator;

public interface LinkedList<E> extends Iterable<Node<E>> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    Iterator<Node<E>> iterator();


    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public E getItem() {
            return item;
        }
    }

}
