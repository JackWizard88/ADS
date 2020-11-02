package com.geekbrains.krilov.algorythms.homework3.util;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertFirst(E value) {
        if (isFull()) {
            return false;
        }
        if (head == 0) {
            head = data.length;
        }
        data[--head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(E value) {
        return super.insert(value);
    }

    @Override
    public E removeFirst()  {
        return super.remove();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (tail < 0) {
            tail = data.length - 1;
        }
        E removedValue = data[tail--];
        size--;
        return removedValue;
    }

    @Override
    public E peekFirst() {
      return super.peekHead();
    }

    @Override
    public E peekLast() {
        return data[tail];
    }

}
