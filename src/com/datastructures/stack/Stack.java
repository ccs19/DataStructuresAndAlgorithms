package com.datastructures.stack;

public class Stack {

    private StackItem top;

    public void push(Object o){
        StackItem sItem = new StackItem(o);
        sItem.next = top;
        top = sItem;
    }

    public Object pop(){
        Object ret = null;
        if(top != null){
            ret = top.o;
            top = top.next;
        }
        return ret;
    }

    public Object peek(){
        if(top != null){
            return top.o;
        }
        return null;
    }

}
