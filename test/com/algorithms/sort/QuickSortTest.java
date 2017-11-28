package com.algorithms.sort;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class QuickSortTest {

    //@Test
    public void testQuickSort(){
        int[] array = new int[]{5,1,0,2,3,12,550,1023,6,8,-1};
        QuickSort.sort(array);
        for(int i : array){
            System.out.print(i + " ");
        }
        QuickSort.sort(array);
    }


    @Test
    public void testBitShift(){
        long iterations = 1000000000L;
        Random random = new Random();
        long startTimeShift = System.currentTimeMillis();
        for(long i = 0L; i < iterations; i++){
            long temp = random.nextLong() >> 1;
        }
        long endTimeShift = System.currentTimeMillis();


        long startTimeDiv = System.currentTimeMillis();
        for(long i = 0L; i < iterations; i++){
            long temp = random.nextLong() / 2;
        }
        long endTimeDiv = System.currentTimeMillis();

        System.out.printf("Time for bit shift: %d\nTime for division: %d\n", endTimeShift - startTimeShift, endTimeDiv - startTimeDiv);
    }


}
