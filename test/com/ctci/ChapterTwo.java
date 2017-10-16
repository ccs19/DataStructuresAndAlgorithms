package com.ctci;

import com.ctci.ds.LinkedList;
import com.ctci.ds.Node;
import org.junit.jupiter.api.Test;

public class ChapterTwo {

    /**
     * CTCI 2.1 Remove Dupes
     * Remove duplicates from an unsorted linked list
     */
    public void removeDuplicate(LinkedList<?> ll){
        Node current = ll.getHead();
        while(current != null) {
            Node next = current;
            while(next.getNext() != null) {
                if (next.getNext().equals(current)) {
                    next.setNext(next.getNext().getNext());
                } else {
                    next = next.getNext();
                }
            }
            current = current.getNext();
        }
    }

    /**
     * CTCI 2.2 kth to last element
     *  th
     */
    public Node<?> kthToLastElement(LinkedList<?> ll, int k){
        Node<?> result = ll.getHead();
        Node<?> runner = ll.getHead();
        for(int i = 0; i < k; i++){
            runner = runner.getNext();
        }
        while(runner.getNext() != null){
            result = result.getNext();
            runner = runner.getNext();
        }
        return result;
    }

    /**
     * CTCI 2.3 delete middle node
     * Deletes a node in the middle of a linked list given the head.
     * (NOT what the problem asks for, but a decent implementation.
     */
    public void deleteMiddleNode2(LinkedList<?> ll){
        Node current = ll.getHead();
        Node runner = ll.getHead();
        Node previous = ll.getHead();
        while(runner != null){
            if(runner.getNext() != null) {
                runner = runner.getNext().getNext();
            }else{
                break;
            }
            previous = current;
            current = current.getNext();
        }
        previous.setNext(current.getNext());
    }

    /**
     * CTCI 2.3 delete middle node
     * Deletes a node in the middle of a linked list given a node that is in the middle.
     * So if I'm given node 5 in 1->5->10 the resulting linkedlist should be 1->10
     * //First solution. Not optimal. No need to iterate through list!
     *
     */
    public void deleteMiddleNodeNotOptimal(Node node){
        Node previous = node;
        while(node.getNext() != null){
            node.setItem(node.getNext().getItem());
            previous = node;
            node = node.getNext();
        }
        previous.setNext(null);

    }

    /**
     * CTCI 2.3 delete middle node OPTIMAL
     * Instead of iterating through the list, just copy the data from the next node into the current node,
     * then delete the next node. Remember to error check!
     */
    public void deleteMiddleNode(Node node){
        if(node == null || node.getNext() == null){
            return;
        }
        node.setItem(node.getNext().getItem());
        node.setNext(node.getNext().getNext());
    }

    /**
     * CTCI 2.4 partition linked list around x
     * Partitions a linked list around a value, x, where nodes less than x
     * come before nodes greater than or equal to x.
     */
    public void partitionAroundX(LinkedList<Integer> ll, int x){
        if(ll.getHead() == null) return;

        Node<Integer> pivotHigh = ll.getHead();
        Node<Integer> pivotLow = pivotHigh;

        while(pivotHigh.getNext() != null && pivotHigh.getItem() < x){
            pivotLow = pivotHigh;
            pivotHigh = pivotHigh.getNext();
        }

        Node<Integer> current = pivotHigh.getNext();
        while(current != null){
            if(current.getItem() >= x){
                pivotHigh = current;
                current = current.getNext();
            }else{
                pivotHigh.setNext(current.getNext());
                current.setNext(pivotLow);
                pivotLow = current;
                current = pivotHigh.getNext();
            }
        }
        ll.setHead(pivotLow);
    }

    @Test
    public void testPartitionX(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(13,30,20,30,12,50,11);
        partitionAroundX(ll,20);
        System.out.println(ll);
    }

/**
    @Test
    public void testDeleteMiddleNode(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5,4,3);
        deleteMiddleNode(ll.getHead().getNext());
        System.out.println(ll);
    }


    @Test
    public void testDeleteMiddleNode2(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5,4,3,2);
        deleteMiddleNode(ll.getHead().getNext());
        deleteMiddleNode(ll);
        System.out.println(ll);
    }


    @Test
    public void testKthToLast(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5,4,3,2,1,0);
        System.out.println(kthToLastElement(ll,0));
    }


    @Test
    public void testRemoveDuplicate(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1,2,3,4,1,2,3,4);
        removeDuplicate(ll);
        for(Integer i : ll){
            System.out.print(i + " ");
        }
    }


     * */
}
