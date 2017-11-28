package com.algorithms.sort.challenges;

import org.junit.jupiter.api.Test;

public class PerfectSquare {

    /**
     * Takes two numbers and returns the number of perfect squares in that range.
     *
     * So from 2-9, the return would be 2, as 4 and 9 are perfect squares of 2 and 3.
     */
    public static int perfectSquare(int low, int high){
        int perfectSquareCount = 0;
        int floor = (int)Math.sqrt(low);
        if(floor * floor != low) floor++;
        while(true){
            int square = floor * floor;
            if(square <= high){
                perfectSquareCount++;
                floor++;
            }else{
                break;
            }
        }
        return perfectSquareCount;
    }


    @Test
    public void testPerfectSquare(){
        System.out.println(perfectSquare(2,9));
        System.out.println(perfectSquare(10,100));
    }


}
