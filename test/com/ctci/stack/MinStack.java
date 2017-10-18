package com.ctci.stack;

/**
 * Stack to keep track of min in O(1) time.
 */
public class MinStack {

    private final int size;
    private int index;
    private Node[] stack;

    public MinStack(int size){
        stack = new Node[size];
        this.size = size;
        this.index = 0;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return stack[index-1].value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        index--;
        return stack[index].value;
    }

    public void push(int... values){
        for(int value : values){
            push(value);
        }
    }


    public void push(int value){
        if(isFull()) throw new RuntimeException("Stack overflow");

        int min = value;
        if(index != 0){
            min = stack[index-1].min > value ? value : stack[index-1].min;
        }
        Node node = new Node(value,min);
        stack[index] = node;
        index++;
    }

    public int min(){
        if(isEmpty())throw new RuntimeException("Stack is empty");
        return stack[index-1].min;
    }

    /**
     * CTCI 3.5
     * Sort stack where smallest items are on top
     * //Terrible runtime. Can be improved. Not feeling up to it today.
     */
    public void sortStack(){
        MinStack tempStack = new MinStack(size);
        tempStack.push(this.pop());
        boolean changed = true;
        while(changed) {
            changed = false;
            while (!this.isEmpty()) {
                int temp = this.peek();
                if (temp < tempStack.peek()) {
                    temp = tempStack.pop();
                    tempStack.push(this.pop());
                    tempStack.push(temp);
                    changed = true;
                }else{
                    tempStack.push(this.pop());
                }
            }
            while(!tempStack.isEmpty()){
                this.push(tempStack.pop());
            }
            if(changed){
                System.out.println(this);
                tempStack.push(this.pop());
            }
        }

    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean isFull(){
        return index == size;
    }

    private static class Node{
        int value;
        int min;
        Node(int value, int min){
            this.value = value;
            this.min = min;
        }

    }

    @Override
    public String toString(){
        MinStack temp = new MinStack(size);
        StringBuilder sb = new StringBuilder();
        while(!this.isEmpty()){
            sb.append(this.peek() + "\n");
            temp.push(this.pop());
        }
        while(!temp.isEmpty()){
            this.push(temp.pop());
        }
        return sb.toString();
    }
}
