package com.interviewcake;

import com.interviewcake.util.LinkedListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    /**
     * You have a singly-linked list ↴ and want to check if it contains a cycle.
     */
    public boolean linkedListContainsCycle(LinkedListNode head){
        Set<LinkedListNode> nodeSet = new HashSet<>();
        while(head != null){
            if(nodeSet.contains(head)){
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     *
     * O(1) space, O(n) runtime
     */
    public boolean _linkedListContainsCycle(LinkedListNode head){
        LinkedListNode walker = head;
        LinkedListNode runner = null;
        if(head.next != null) runner = head.next.next;
        else return false;
        while(true){
            if(runner == walker) return true;
            if(runner != null && runner.next != null){
                runner = runner.next.next;
            }else{
                return false;
            }
            walker = walker.next;
        }
    }

    @Test
    public void test(){
        LinkedListNode head = LinkedListNode.LinkedListFactory.buildLinkedList(5,1,2,5,1,2,5,7,9,1,2,15,29,18);
        System.out.println(_linkedListContainsCycle(head));
        buildCycle(head);
        System.out.println(_linkedListContainsCycle(head));
    }


    private void buildCycle(LinkedListNode head){
        LinkedListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = head;
    }

}
