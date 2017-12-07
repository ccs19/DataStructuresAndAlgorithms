package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public    class NPlusOne {

    /**
     I have an array of n+1 numbers.
     Every number in the range 1..n appears once except for one number that appears twice.
     Write a function for finding the number that appears twice.
     */

    public int numberAppearsTwice(int[] numbers){
        int count = 0;
        for(int i = 0; i < numbers.length; i++){
            count = count + numbers[i] - i;
        }
        return count;
    }

    @Test
    public void testNumberAppearsTwice(){
      /**  int[] array1 = getArray(100);
        array1[100] = 52;
        shuffleArray(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(numberAppearsTwice(array1)); //52**/
        int[] array1 = getArray(100);
        array1[100] = 5;
        shuffleArray(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(numberAppearsTwice(array1));

    }


    public int numberAppearsTwiceTwo(int[] numbers){
        for(int i = 0, j = 2; i < numbers.length; i++, j+=2){
            if(j >= numbers.length) j = 1;
            if(numbers[i] == numbers[j]) return numbers[i];
        }
        return -1;
    }

    @Test
    public void testNumberAppearsTwiceTwo(){
        /**  int[] array1 = getArray(100);
         array1[100] = 52;
         shuffleArray(array1);
         System.out.println(Arrays.toString(array1));
         System.out.println(numberAppearsTwice(array1)); //52**/
        int[] array1 = getArray(100);
        array1[100] = 5;
        array1[50] = 12;
        shuffleArray(array1);
        System.out.println(numberAppearsTwiceTwo(array1));

    }

    /**
     * Perform in O(N) time and O(1) space.
     */
    @Test
    public void testNumberAppearsTwiceTwoSpaceEdition(){
        /**  int[] array1 = getArray(100);
         array1[100] = 52;
         shuffleArray(array1);
         System.out.println(Arrays.toString(array1));
         System.out.println(numberAppearsTwice(array1)); //52**/
        int[] array1 = getArray(5);
        array1[5] = 3;
        shuffleArray(array1);
        System.out.println(numberAppearsTwiceTwoSpaceEdition(array1));

    }

    private int numberAppearsTwiceTwoSpaceEdition(int[] array){
        System.out.println(Arrays.toString(array));
        int n = array.length - 1;
        int headIndex = n+1;
        for(int i = 0; i < n; i++){
            headIndex = array[headIndex-1];
        }
        int currentIndex = array[headIndex-1];
        int cycleLength = 1;
        while(currentIndex != headIndex){
            currentIndex = array[currentIndex-1];
            cycleLength++;
        }
        int lookAhead = n+1;
        for(int i = 0; i < cycleLength; i++){
            lookAhead = array[lookAhead-1];
        }
        System.out.println("Cycle length: " + cycleLength);
        int catchUp = n+1;
        while(catchUp != lookAhead){
            catchUp = array[catchUp-1];
            lookAhead = array[lookAhead-1];
        }

        //
        return lookAhead;
    }

    void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private int[] getArray(int n){
        int[] array = new int[n+1];
        for(int i = 0; i < n; i++){
            array[i] = (i+1);
        }

        return array;
    }


    @Test
    public void testRand5(){
        long[] array = new long[5];
        long n = 100000000;
        for(long i = 0L; i < n; i++){
            //array[rand5()-1]++;
            array[r.nextInt(5)]++;
        }
        for(int i = 0; i < array.length; i++){
            double count = array[i];

            System.out.printf("[%d] [%.2f]\n",i+1, ((count/(double)n) * (double)100));
        }
    }


    @Test
    public void testRand7(){
        long[] array = new long[7];
        long n = 100000000;
        for(long i = 0L; i < n; i++){
            array[_rand7()-1]++;
            //array[r.nextInt(5)]++;
        }
        for(int i = 0; i < array.length; i++){
            double count = array[i];

            System.out.printf("[%d] [%.2f]\n",i+1, ((count/(double)n) * (double)100));
        }
    }

    static Random r = new Random();
    private int rand7(){
        return r.nextInt(7);
    }

    private int rand5(){
        return ((rand7() + rand7() + rand7() + rand7() + rand7()) % 5) + 1;
    }

    private int _rand5(){
        return r.nextInt(5) + 1;
    }

    private int _rand7(){
        int result;
        while((result = rand5() + rand5()) > 7);
        return result;
    }


}
