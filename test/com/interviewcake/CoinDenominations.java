package com.interviewcake;

import org.junit.jupiter.api.Test;

public class CoinDenominations {

    /**
     * Write a method that, given:

     an amount of money
     an array of coin denominations
     computes the number of ways to make the amount of money with coins of the available denominations.

     Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), your program would output 44—the number of ways to make 44¢ with those denominations:

     1¢, 1¢, 1¢, 1¢
     1¢, 1¢, 2¢
     1¢, 3¢
     2¢, 2¢
     */

    public int numberOfWays(int amount, int[] denominations){
        int numberOfWays = 0;
        for(int i = 0; i < denominations.length; i++){
            int tempAmount = amount;
            while(tempAmount > 0){
            }
        }

        return numberOfWays;
    }

    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }


    @Test
    public void testNumberOfWays(){
        int amount1 = 4;
        int[] denominations1 = new int[]{1,2,3,25};
        print(4, changePossibilitiesBottomUp(amount1,denominations1));
    }

    private void print(int expected, int actual){
        System.out.printf("Expected: %d; Actual: %d\n",expected,actual);
    }
}
