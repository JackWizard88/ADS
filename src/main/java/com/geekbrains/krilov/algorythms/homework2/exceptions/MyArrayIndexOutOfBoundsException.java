package com.geekbrains.krilov.algorythms.homework2.exceptions;

public class MyArrayIndexOutOfBoundsException extends RuntimeException {

    public MyArrayIndexOutOfBoundsException(int index, int size) {
        super(String.format("Invalid index %d for array with length %d", index, size));
    }
}
