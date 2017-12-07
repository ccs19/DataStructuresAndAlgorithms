package com.interviewcake;

import com.interviewcake.util.LinkedListNode;
import org.junit.jupiter.api.Test;

public class KthToLastNodeLinkedList {

    /**
     * Write a function kthToLastNode() that takes an integer kk and the
     * headNode of a singly-linked list, and returns the kth to last node in the list.
     *
     * Another "runner" problem
     * Runner runs ahead K nodes. Then walker starts. When runner hits the end of the List,
     * walker will be at the correct position.
     */
    public LinkedListNode kthToLastNode(LinkedListNode head, int k){
        LinkedListNode runner = head, walker = head;
        for(int i = 0; i < k; i++){
            runner = runner.next;
            if(runner == null) return null;
        }
        while(runner != null){
            runner = runner.next;
            walker = walker.next;
        }
        return walker;
    }

    @Test
    public void test(){
        LinkedListNode head = LinkedListNode.LinkedListFactory.buildLinkedList(1,2,3,4,5,6,7,8,9,10,11,12);
        System.out.println(kthToLastNode(head, 5));
    }




}
