package com.ctci;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
     * 16.2 Design a method to find the frequency of occurrences of any given word in a book.
     * What if we were running this algorithm multiple times? (Not sure what this means.)
     */
    public int wordFrequency(String book, String word){
        String[] split = book.split("\\s+|,\\s*|\\.\\s*|!\\s*|\"|;\\s*");
        int count = 0;
        for(String s : split){
            if(s.equalsIgnoreCase(word)){
                count++;
            }
        }
        return count;
    }

    public String readFile(String fileName){

        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int)file.length()];
            fis.read(data);
            fis.close();
            return new String(data, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testWordFrequency(){
        String word = readFile("./resources/alice.txt");
        System.out.printf("Alice found %d times\n", wordFrequency(word,"Alice"));
    }

/**
    @Test
    public void testSwap(){
        IntWrapper one = new IntWrapper(10);
        IntWrapper two = new IntWrapper(15);
        swap(one,two);
        System.out.println("One: " + one.num + " Two: " + two.num);
    }**/



}
