package com.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    private LinkedList linkedList;


    @BeforeEach
    public void setup(){
        linkedList = new LinkedList();
    }

    @Test
    public void testLength(){
        addBJandL();
        assertEquals(3, linkedList.length());
    }

    @Test
    public void testLast(){
        addBJandL();
        assertEquals("larry", linkedList.get().toString());
    }

    @Test
    public void testMid(){
        addBJandL();
        assertEquals("jim", linkedList.get(1).toString());
    }

    @Test
    public void getAll(){
        addBJandL();
        Object[] objects = linkedList.getAll();
        assertEquals("bob", objects[0].toString());
        assertEquals("jim", objects[1].toString());
        assertEquals("larry", objects[2].toString());

    }

    private void addBJandL(){
        add("bob");
        add("jim");
        add("larry");
    }


    private void add(String str){
        linkedList.add(new LinkedListItem(str));
    }

}
