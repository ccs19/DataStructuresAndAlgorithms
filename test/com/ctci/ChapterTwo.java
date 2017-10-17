package com.ctci;

import com.ctci.ds.LinkedList;
import com.ctci.ds.Node;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

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

    /**
     * CTCI 2.5 Sum lists:
     * Sums the values in two linked lists.
     *
     * e.g. 1 -> 2 -> 3 + 7 -> 8 -> 9
     * is 321 + 987, or 1308 and returns
     * 8 -> 0 -> 3 -> 1
     */
    public LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2){
        int num1 = buildNumber(list1);
        int num2 = buildNumber(list2);
        return buildList(num1 + num2);
    }

    private int buildNumber(LinkedList<Integer> list){
        Node<Integer> current = list.getHead();
        int result = 0;
        int multiplier = 1;
        while(current != null){
            result += current.getItem() * multiplier;
            multiplier *= 10;
            current = current.getNext();
        }
        return result;
    }

    private LinkedList<Integer> buildList(int number){
        LinkedList<Integer> ll = new LinkedList<>();
        while(number > 0){
            ll.add(number % 10);
            number /= 10;
        }
        return ll;
    }

    /**
     * CTCI 2.5 Sum Lists
     * Same as other, except values are in forward order. Algorithm is practically the same..
     * e.g. 1 -> 2 -> 3 + 4 -> 5 -> 6
     * is 123 + 456 and returns another list:
     * 5 -> 7 -> 9
     *
     * O(n) time
     * O(m) storage (m digits in result)
     */
    public LinkedList<Integer> sumLists2(LinkedList<Integer> list1, LinkedList<Integer> list2){
        int num1 = buildNumber2(list1);
        int num2 = buildNumber2(list2);
        return buildList2(num1+num2);
    }

    private int buildNumber2(LinkedList<Integer> list) {
        Node<Integer> current = list.getHead();
        int total = 0;
        while(current != null){
            total *= 10;
            total += current.getItem();
            current = current.getNext();
        }
        return total;
    }

    private LinkedList<Integer> buildList2(int num){
        Node<Integer> head = new Node<>();
        head.setItem(num%10);
        num /= 10;
        while(num > 0){
            Node<Integer> temp = new Node<>();
            temp.setNext(head);
            temp.setItem(num % 10);
            head = temp;
            num /= 10;
        }
        LinkedList<Integer> result =  new LinkedList<>();
        result.setHead(head);
        return result;
    }

    /**
     * CTCI 2.6 Is List palindrome?
     * Checks if a list is a palindrome. Destroys LL order but runs in O(n) and O(1) space.
     * Problem doesn't state that we can't destroy list structure.
     * a big mess
     */
    public boolean isListPalindrome(LinkedList<Character> list){
        Node<Character> middle = list.getHead();
        Node<Character> runner = list.getHead();

        while(runner != null && runner.getNext() != null){
            runner = runner.getNext().getNext();
            middle = middle.getNext();
        }

        Node<Character> head = list.getHead();
        Node<Character> newHead = null;
        while(head != middle){ // Reverse up to middle node
            Node<Character> temp = head;
            head = head.getNext();
            temp.setNext(newHead);
            newHead = temp;
        }
        boolean oneOff = false;
        while(newHead != null || middle != null){
            if(middle != null && newHead == null){
                return false;
            } else if(newHead.getItem() != middle.getItem()){
                if(oneOff){
                    return false;
                }
                oneOff = true;
                middle = middle.getNext();
            }else{
                newHead = newHead.getNext();
                middle = middle.getNext();
                oneOff = true;
            }
        }

        return true;
    }

    /**
     * CTCI 2.7 Intersection
     * Given two singly linked list, determine if the two lists intersect.
     * Return the intersecting node.
     * Use four pointers? (Only if lists are same size)
     * Use hashmap
     * This takes O(N + M) and O(1) space.
     */
    public Node<Integer> listIntersection(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Node<Integer> currentOne = list1.getHead();
        Node<Integer> currentTwo = list2.getHead();
        HashSet<Node<Integer>> set = new HashSet<>();
        while (currentOne != null || currentTwo != null) {
            if (currentOne != null) {
                if (set.contains(currentOne)) {
                    return currentOne;
                } else {
                    set.add(currentOne);
                }
            }
            if (currentTwo != null) {
                if (set.contains(currentTwo)) {
                    return currentTwo;
                } else {
                    set.add(currentTwo);
                }
            }
        }
        return null;
    }

    /**
     * CTCI 2.8 Loop detection
     * Check if a LinkedList has a loop, and if so return the node that begins the loop
     */
    public Node<Integer> linkedListLoopCheck(LinkedList<Integer> ll){
        Node<Integer> current = ll.getHead();
        Node<Integer> runner = ll.getHead();
        while(runner != null && runner.getNext() != null){
            current = current.getNext();
            runner = runner.getNext().getNext();
            if(runner == current){
                break;
            }
        }
        if(runner == null || runner.getNext() == null) return null;
        current = ll.getHead();
        while(current != runner){
            current = current.getNext();
            runner = runner.getNext();
        }

        return runner;
    }


    @Test
    public void testLinkedListLoop(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1,2,3,4,5,6,7,8,9,10,11,12,13,154);
        Node<Integer> nodeToLoopBackTo = ll.getHead().getNext().getNext().getNext(); //Node with val 4
        Node<Integer> node = new Node<>();
        node.setItem(571925);
        node.setNext(nodeToLoopBackTo);
        ll.add(node);
        System.out.println(linkedListLoopCheck(ll));
    }

    /**
    @Test
    public void testIntersection(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1024,2,3,4,5,6);
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.add(9,1,5,1,2,3);
        ll2.add(ll.getHead());
        System.out.println(listIntersection(ll,ll2));
    }




    @Test
    public void testIsPalindrome(){
        LinkedList<Character> ll = new LinkedList<>();
        //ll.add('a','b','c','d','c','b','a');
        ll.add('a','b','c','d','d','c','b','a');

        System.out.println(isListPalindrome(ll));
    }

    @Test
    public void reverseLinkedListInPlace(){
        LinkedList<Integer> old = new LinkedList<>();
        old.add(1,2,3,4,5);
        Node<Integer> oldNode = old.getHead();
        Node<Integer> newNode = null;

        while(oldNode != null){
            Node<Integer> temp = oldNode;

            oldNode = oldNode.getNext();
            temp.setNext(newNode);
            newNode = temp;
        }
        old.setHead(newNode);
        System.out.println(old);
    }


    @Test
    public void testSumLists2(){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(9,0,3);
        list2.add(1,0,0);

        System.out.println(sumLists2(list1,list2));
    }

    @Test
    public void testSumLists(){
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(1,2,3);
        list2.add(7,8,9);

        System.out.println(sumLists(list1,list2));
    }

    @Test
    public void testPartitionX(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(13,30,20,30,12,50,11);
        partitionAroundX(ll,20);
        System.out.println(ll);
    }


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
