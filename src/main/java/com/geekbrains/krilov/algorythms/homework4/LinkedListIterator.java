package com.geekbrains.krilov.algorythms.homework4;

import java.util.Iterator;
import com.geekbrains.krilov.algorythms.homework4.LinkedList.Node;

class LinkedListIterator<E> implements Iterator<Node<E>> {

    private Node<E> current;

    public LinkedListIterator(Node<E> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Node<E> next() {
        Node<E> node = current;
        current = current.next;
        return node;
    }
}