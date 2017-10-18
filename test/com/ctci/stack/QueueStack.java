package com.ctci.stack;

public class QueueStack {

    private MinStack stack;
    private MinStack queueStack;
    private boolean changed;

    public QueueStack(int size){
        stack = new MinStack(size);
        queueStack = new MinStack(size);
    }

    public void enqueue(int... numbers){
        for(int number : numbers){
            enqueue(number);
        }
    }

    public void enqueue(int number){
        changed = true;
        if(stack.isFull()){
            throw new RuntimeException("Queue full");
        }
        stack.push(number);
    }

    public int dequeue(){
        if(stack.isEmpty()) return Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            queueStack.push(stack.pop());
        }
        int next = queueStack.pop();
        while(!queueStack.isEmpty()){
            stack.push(queueStack.pop());
        }
        return next;
    }


}
