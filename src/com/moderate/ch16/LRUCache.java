package com.moderate.ch16;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {

    private LinkedListNode head;
    private LinkedListNode tail;
    private Map<String, LinkedListNode> map;
    private static final int MAX_SIZE = 3;

    public LRUCache(){
        map = new HashMap<>();
    }


    public Object get(String key){
        LinkedListNode node = map.get(key);
        updateQueue(node);
        return null;
    }

    public void put(String key, Object value){
        if(map.size() == MAX_SIZE){
            evict();
        }
        LinkedListNode node = new LinkedListNode(key, value);
        if(tail != null) {
            head.next = node;
            node.prev = head;
            head = node;
        }else{
            head = node;
            tail = node;
        }
        map.put(key, node);
    }

    private void updateQueue(LinkedListNode node){
        if(node.prev != null){
            node.prev.next = node.next;
        }
        head.next = node;
        node.prev = head;
        head = node;
        node.next = null;
    }

    private void evict(){
        map.remove(tail.key);
        tail = tail.next;
        if(tail!= null) {
            tail.prev = null;
        }
    }

    public void printContents(){
        LinkedListNode current = tail;
        while(current != null){
            //System.out.printf("Key: %s, Val: %s\n", current.key, current.item);
            System.out.printf("%s, ", current.item);
            current = current.next;
        }
        System.out.print("\n");

    }

    private class LinkedListNode{
        public Object item;
        public String key;
        public LinkedListNode next;
        public LinkedListNode prev;

        public LinkedListNode(String key, Object item){
            this.item = item;
            this.key = key;
        }
    }
}
