package com.interviewcake;

import com.datastructures.linkedlist.LinkedList;
import com.interviewcake.util.LinkedListNode;
import org.junit.jupiter.api.Test;

public class ReverseLinkedList {

    /**
     * Reverse a linked list in place given its head.
     */

    public LinkedListNode reverseLinkedList(LinkedListNode head){
        LinkedListNode current,previous,next;
        current = head;
        previous = null;
        next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    @Test
    public void test(){
        LinkedListNode head = LinkedListNode.LinkedListFactory.buildLinkedList(1,2,3,4,5,6,7,8,9,10,11,12);
        System.out.println(reverseLinkedList(head));
    }

}
