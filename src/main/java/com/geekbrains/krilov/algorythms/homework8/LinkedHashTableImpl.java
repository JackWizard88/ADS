package com.geekbrains.krilov.algorythms.homework8;

public class LinkedHashTableImpl<K, V> implements HashTable<K, V> {

    private final int maxSize;
    private final Node<K, V>[] data;
    private int size;

    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public LinkedHashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Node[maxSize];
    }

    @Override
    public boolean put(K key, V value) {

        if (size == maxSize) {
            return false;
        }

        int index = hash(key);
        index %= data.length;

        if (data[index] == null) {
            data[index] = new Node<>(key, value);
            size++;
            return true;
        }

        Node<K, V> node = data[index];

        while (node.getNext() != null) {
            node = node.getNext();
        }

        node.setNext(new Node<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key);

        if (data[index] == null) {
            return null;
        }

        Node<K, V> node = data[index];

        while (node != null && !node.getKey().equals(key)) {
            node = node.getNext();
        }

        if (node == null) {
            return null;
        } else return node.getValue();
    }

    @Override
    public V remove(K key) {

        int index = hash(key);

        if (data[index] == null) {
            return null;
        }

        Node<K, V> current = data[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.getKey().equals(key)) {

                if (previous == null) {
                    data[index] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return current.getValue();
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");

        for (int i = 0; i < data.length; i++) {
            System.out.print(i + " = ");

            Node<K, V> node = data[i];

            while (node != null) {
                System.out.print(node + (node.getNext() != null ? " || " : ""));
                node = node.getNext();
            }

            System.out.println();
        }
        System.out.println("----------");
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

}

