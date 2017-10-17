package com.ctci.ds;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;

    public LinkedList(){

    }

    public LinkedList(Node<T> node){
        head = node;
        while(node != null){
            tail = node;
            node = node.getNext();
        }
    }

    public void add(Node<T> node){
        if(head == null){
            head = node;
        }
        tail.setNext(node);
        tail = node;
    }

    public void addToHead(Node<T> node){
        node.setNext(head);
        head = node;
    }

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
        Node<T> current = head;
        while(current != null){

            sb.append(current.getItem() + " -> ");
            if(current == tail && current.getNext() != null) {
                sb.append(current.getNext().getItem() + " loop");
                break;
            }
            current = current.getNext();

        }
        String result = sb.toString();
        if(result.length() >= 4) {
            return result.substring(0, result.length() - 4);
        }
        return "empty";
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
