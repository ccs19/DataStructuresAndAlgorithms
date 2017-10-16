package com.ctci.ds;

public class Node<T> {

    private T item;
    private Node<T> next;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public boolean equals(Object node){
        if(node != null){
            Node<?> n = (Node<?>)node;
            return n.getItem() == this.getItem();
        }
        return false;
    }

    @Override
    public String toString(){
        return item.toString();
    }
}
