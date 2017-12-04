package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class HighestProduct {


    public int highestProduct(int[] numbers){
        int highestProductOfTwo = numbers[0] * numbers[1];
        int lowestProductOfTwo = highestProductOfTwo;
        int higestProductOfThree = highestProductOfTwo * numbers[2];
        int highest = Math.max(numbers[0], numbers[1]);
        int lowest = Math.min(numbers[0], numbers[1]);

        for(int i = 2; i < numbers.length; i++){
            int current = numbers[i];

            int tempHigestProductOfThree = Math.max(highestProductOfTwo * current, lowestProductOfTwo * current);
            higestProductOfThree = Math.max(higestProductOfThree, tempHigestProductOfThree);

            highestProductOfTwo = Math.max(Math.max(current * highest, current * lowest), highestProductOfTwo);

            lowestProductOfTwo = Math.min(Math.min(current * highest,current*lowest), lowestProductOfTwo);

            highest = Math.max(current, highest);
            lowest = Math.min(current, lowest);
            /**      int current = numbers[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            higestProductOfThree = Math.max(Math.max(
                    higestProductOfThree,
                    current * highestProductOfTwo),
                    current * lowestProductOfTwo);

            // do we have a new highest product of two?
            highestProductOfTwo = Math.max(Math.max(
                    highestProductOfTwo,
                    current * highest),
                    current * lowest);

            // do we have a new lowest product of two?
            lowestProductOfTwo = Math.min(Math.min(
                    lowestProductOfTwo,
                    current * highest),
                    current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);**/


            System.out.printf("H3: %d, H2: %d, L2: %d, L: %d, H: %d\n", higestProductOfThree, highestProductOfTwo, lowestProductOfTwo, lowest, highest);
        }
        return higestProductOfThree;
    }

    /**
     * Given a list of integers, find the highest product you can get from three of the integers.
     * The input list_of_ints will always have at least three integers.
     */
    @Test
    public void testHighestProduct(){
        int[] testOne = new int[]{8,1,7,2,5,1,12,55,4}; //(55 * 12 * 8)
        int testOneExpected = 8 * 12 * 55;
        int[] testTwo = new int[]{8,1,7,2,5,1,12,-55,4};
        int testTwoExpected = 12 * 8 * 7;
        int[] testThree = new int[]{8,-2,7,2,5,1,12,-55,4};
        int testThreeExpected = -55 * 12 * -2;
        //print(testOne, testOneExpected);
        //print(testTwo, testTwoExpected);
        print(testThree, testThreeExpected);
    }

    private void print(int[] values, int expected){
        int result = highestProduct(values);
        ///System.out.printf("Expected: %d, Result: %d\n", expected, result);
    }

}
