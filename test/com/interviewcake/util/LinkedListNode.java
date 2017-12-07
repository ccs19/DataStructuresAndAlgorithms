package com.interviewcake.util;

import java.util.HashSet;
import java.util.Set;

public class LinkedListNode {


    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        Set<LinkedListNode> set = new HashSet<>();
        LinkedListNode current = this;
        String str = "";
        while(current != null){
            if(set.contains(current)){
                return str + " CYCLE DETECTED -> " + current.value;
            }
            set.add(current);
            str += current.value + " -> ";
            current = current.next;
        }
        return str.substring(0,str.length()-4);
    }


    public static class LinkedListFactory{
        public static LinkedListNode buildLinkedList(int... values){
            if(values.length == 0)
                throw new IllegalArgumentException("Must have at least one value to build LinkedList");
            LinkedListNode head = new LinkedListNode(values[0]);
            LinkedListNode current = head;
            for(int i = 1; i < values.length; i++){
                current.next = new LinkedListNode(values[i]);
                current = current.next;
            }
            return head;
        }
    }
}
