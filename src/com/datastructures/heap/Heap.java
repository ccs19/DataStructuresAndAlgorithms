package com.datastructures.heap;

public interface Heap {

    int peek();

    boolean isEmpty();


    int pop();

    void insert(int... n);

    void print();
}
