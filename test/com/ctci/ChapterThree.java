package com.ctci;

import  com.ctci.stack.ArrayTripleStack;
import com.ctci.stack.MinStack;
import com.ctci.stack.QueueStack;
import com.ctci.stack.animalshelter.Animal;
import com.ctci.stack.animalshelter.AnimalShelter;
import com.ctci.stack.animalshelter.AnimalType;
import org.junit.jupiter.api.Test;
import static com.ctci.stack.ArrayTripleStack.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ChapterThree {


    /**
     * CTCI 3.6 Animal Shelter
     */
    @Test
    public void testAnimalShelter(){
        AnimalShelter a = new AnimalShelter();
        assertNull(a.dequeue());
        assertNull(a.dequeueCat());
        assertNull(a.dequeueDog());
        a.enqueue(Animal.generate(AnimalType.DOG, "Rusty1"));
        a.enqueue(Animal.generate(AnimalType.CAT, "Mittens1"));
        a.enqueue(Animal.generate(AnimalType.DOG, "Rusty2"));
        a.enqueue(Animal.generate(AnimalType.CAT, "Mittens2"));
        a.enqueue(Animal.generate(AnimalType.CAT, "Mittens3"));
        a.enqueue(Animal.generate(AnimalType.DOG, "Rusty3"));
        a.enqueue(Animal.generate(AnimalType.CAT, "Mittens4"));
        System.out.println(a.dequeue());
        System.out.println(a.dequeueDog());
        System.out.println(a.dequeue());
        System.out.println(a.dequeue());
        System.out.println(a.dequeueCat());
        System.out.println(a.dequeue());

    }

    /**
     * CTCI 3.5 test sort stack
     */
   /** @Test
    public void testSortStack(){
        MinStack stack = new MinStack(10);
        stack.push(5,1,0,1,2,4,8,12);
        stack.sortStack();
        System.out.println(stack);

    }**/

    /**
     * CTCI 3.4 Queue using two stacks
     */
 /**   @Test
    public void testQueueStack(){
        QueueStack qs = new QueueStack(10);
        qs.enqueue(1,2,3,4,5);
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());

    }**/

    /**
     * CTCI 3.2 A stack with O(1) push, pop, and min functionality
     */
    /**    @Test
    public void testMinStack(){
        MinStack stack = new MinStack(10);
        stack.push(0);
        stack.push(10);
        stack.push(20);
        stack.push(-1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(Integer.MIN_VALUE);
        System.out.println(stack.min());
    }



     * CTCI 3.1
     * Single array to implement three stacks.
     */
/**    @Test
    public void testTripleStack(){
        ArrayTripleStack ats = new ArrayTripleStack(1);
        ats.push("stackOne", STACK_ONE);
        ats.push("stackTwo", STACK_TWO);
        ats.push("stackThree", STACK_THREE);
        System.out.println(ats.peek(STACK_ONE));
        System.out.println(ats.peek(STACK_TWO));
        System.out.println(ats.peek(STACK_THREE));
        ats.pop(STACK_ONE);
        ats.pop(STACK_TWO);
        ats.pop(STACK_THREE);
        System.out.println();
        System.out.println(ats.peek(STACK_ONE));
        System.out.println(ats.peek(STACK_TWO));
        System.out.println(ats.peek(STACK_THREE));
        System.out.println();
        System.out.println(ats.pop(STACK_ONE));
        System.out.println(ats.pop(STACK_TWO));
        System.out.println(ats.pop(STACK_THREE));
        ats.push("stackOne", STACK_ONE);
        ats.push("stackOneFull", STACK_ONE);
    }**/


}
