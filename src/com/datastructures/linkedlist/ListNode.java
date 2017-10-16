package com.datastructures.linkedlist;

public class ListNode {

    private ListNode next;
    private Object obj;

    public ListNode(Object obj){
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }


    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return next;
    }



}
