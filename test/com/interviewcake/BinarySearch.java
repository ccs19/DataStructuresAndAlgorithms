package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySearch {
    /**
     * Suppose we had an array ↴ of nn integers sorted in ascending order.
     * How quickly could we check if a given integer is in the array?
     */
    public boolean binarySearch(int target, int[] array){
        int ceiling = array.length;
        int floor = -1;

        while(floor + 1 < ceiling){
            int distance = ceiling - floor;
            int index = (distance / 2) + floor;
            if(array[index] == target){
                System.out.println("Found at index " + index);
                return true;
            }
            if(array[index] > target){
                ceiling = index;
            }else if(array[index] < target){
                floor = index;
            }
        }
        return false;
    }

    @Test
    public void testBinarySearch(){
        int[] array = new int[]{1,2,3,4,5,6,18,202,500,12,7,55,23};
        Arrays.sort(array);
        System.out.println(binarySearch(500, array));
    }

}
