package com.datastructures.linkedlist;

public class LinkedList {


    private ListNode head;
    private ListNode tail;
    private int length = 0;

    public boolean isEmpty(){
        return head == null;
    }

    public int length(){
        return length;
    }

    /**
     * Adds to end of list
     * @param o
     */
    public void add(Object o){
        ListNode listNode = new ListNode(o);
        if(head == null){
            head = listNode;
            tail = listNode;
        }
        tail.setNext(listNode);
        tail = listNode;
        length++;
    }


    public Object get(int position){
        ListNode current = head;
        int counter = 0;
        while(current != null && counter != position){
            current = current.getNext();
            counter++;
        }
        return current.getObj();
    }

    /**
     * Gets last item in list
     * @return
     */
    public Object get(){
        return tail.getObj();
    }

    public Object[] getAll(){
        if(isEmpty()) return null;
        Object[] objects = new Object[length()];
        ListNode current = head;
        int i = 0;
        while(current != null){
            objects[i++] = current.getObj();
            current = current.getNext();
        }
        return objects;
    }

    public Object[] get(int beginning, int end){
        return null;
    }

    public void remove(int position){

    }

    /**
     * Removes from end
     */
    public void remove(){

    }

    /**
     * Print all elements
     */
    public void print(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.getObj().toString() + ", ");
            current = current.getNext();
        }
    }



}
