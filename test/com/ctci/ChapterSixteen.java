package com.ctci;

import org.junit.jupiter.api.Test;

public class ChapterSixteen {
    /**
     * 16.1 Write a function to swap two numbers in place. (No temporary variables.)
     * @param one
     * @param two
     */
    public void swap(IntWrapper one, IntWrapper two){
        one.num = one.num + two.num;
        two.num = one.num - two.num;
        one.num = one.num - two.num;
    }

    public class IntWrapper{
        int num;

        public IntWrapper(int num){
            this.num = num;
        }
    }

    /**
     * 16.2 Design a method to find the frequency of occurences of any given word in a book.
     * What if we were running this algorithm multiple times? (Not sure what this means.)
     */

/**
    @Test
    public void testSwap(){
        IntWrapper one = new IntWrapper(10);
        IntWrapper two = new IntWrapper(15);
        swap(one,two);
        System.out.println("One: " + one.num + " Two: " + two.num);
    }**/



}
