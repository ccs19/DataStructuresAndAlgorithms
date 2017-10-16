package com.ctci.ds;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;



    public void add(T... item){
        for(T i : item) {
            Node<T> node = new Node<>();
            node.setItem(i);
            if (head == null) {
                head = node;
                tail = node;
            }
            tail.setNext(node);
            tail = node;
        }
    }



    public Node<T> getHead(){
        return head;
    }

    public void setHead(Node<T> head){
        this.head = head;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T item : this){
            sb.append(item + " ");
        }
        return sb.toString();
    }

    public class LinkedListIterator implements Iterator<T>{

        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.getItem();
            current = current.getNext();
            return item;
        }
    }
}
