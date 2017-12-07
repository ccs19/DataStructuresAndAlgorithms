package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergedSortedArrays {

    public int[] mergedSortedArray(int[] array1, int[] array2){
        int[] merged = new int[array2.length + array1.length];
        int arrayOneIndex = 0;
        int arrayTwoIndex = 0;
        for(int i = 0; i < merged.length; i++){
            if(arrayOneIndex == array1.length){
                merged[i] = array2[arrayTwoIndex++];
            }
            else if(arrayTwoIndex == array2.length){
                merged[i] = array1[arrayOneIndex++];
            }
            else if(array1[arrayOneIndex] <= array2[arrayTwoIndex]){
                merged[i] = array1[arrayOneIndex++];
            }
            else{
                merged[i] = array2[arrayTwoIndex++];
            }
        }
        return merged;
    }

    @Test
    public void testMerged(){
        int[] array1     = new int[]{3, 4, 6, 10, 11, 15};
        int[] array2 = new int[]{1, 5, 8, 12, 14, 19};
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]

        System.out.println(Arrays.toString(mergedSortedArray(array1, array2)));
    }


}
