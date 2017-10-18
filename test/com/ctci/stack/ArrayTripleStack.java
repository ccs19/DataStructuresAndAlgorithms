package com.ctci.stack;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayTripleStack {

    private int[] stack;
    public static final int STACK_ONE = 0;
    public static final int STACK_TWO = 1;
    public static final int STACK_THREE = 2;
    private static final int MULTI = 3;
    private int stackIndex[];
    private int size;
    /**
     * CTCI 3.2 -- Keep track of minimum value in stack.
     */
    private int min;


    /**
     * Allocates stack of size * 3 (three stacks).
     * @param size
     */
    public <T> ArrayTripleStack(int size){
        stackIndex = new int[MULTI];
        stackIndex[STACK_ONE] = 0;
        stackIndex[STACK_TWO] = size;
        stackIndex[STACK_THREE] = size * 2;
        min = Integer.MAX_VALUE;
        this.size = size;
    }

    public void push(int s, int stackNumber){
        checkStackValid(stackNumber);
        if(isFull(stackNumber)) throw new RuntimeException("MinStack is full");
        stack[stackIndex[stackNumber]] = s;
        stackIndex[stackNumber]++;
    }

    public int pop(int stackNumber){
        checkStackValid(stackNumber);
        if(isEmpty(stackNumber)) return Integer.MIN_VALUE;
        stackIndex[stackNumber]--;
        return stack[stackIndex[stackNumber]];
    }

    public int peek(int stackNumber){
        checkStackValid(stackNumber);
        if(isEmpty(stackNumber)) return Integer.MIN_VALUE;
        return stack[stackIndex[stackNumber] - 1];
    }

    public boolean isFull(int stackNumber){
        return stackIndex[stackNumber] == getMaxStackSize(stackNumber);
    }

    public boolean isEmpty(int stackNumber){
        return stackIndex[stackNumber] == getMinStackSize(stackNumber);
    }

    private int getMaxStackSize(int stackNumber){
        return stackNumber * size + size;
    }

    private int getMinStackSize(int stackNumber){
        return stackNumber * size;
    }

    private void checkStackValid(int stackNumber){
        if(stackNumber > STACK_THREE || stackNumber < STACK_ONE) throw new RuntimeException("Invalid stack number");
    }

}
