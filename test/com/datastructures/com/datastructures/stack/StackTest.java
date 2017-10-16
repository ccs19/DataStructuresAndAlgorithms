package com.datastructures.com.datastructures.stack;

import com.datastructures.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StackTest {

    Stack stack = new Stack();

    @Test
    public void testStack(){
        assertNull(stack.pop());
        assertNull(stack.peek());
        stack.push("one");
        assertEquals("one", stack.peek());
        stack.push("two");
        assertEquals("two", stack.peek());
        assertEquals("two", stack.pop());
        assertEquals("one", stack.pop());
    }
}
