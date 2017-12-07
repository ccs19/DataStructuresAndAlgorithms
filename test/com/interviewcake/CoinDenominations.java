package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        int amount1 = 5;
        int[] denominations1 = new int[]{1,2,3,4,5};
        print(1, _checkDenominations(amount1,denominations1));
    }

    private void print(int expected, int actual){
        System.out.printf("Expected: %d; Actual: %d\n",expected,actual);
    }

    private int checkDenominations(int amount, int[] denominations){
        if(amount == 0) return 0;
        //return _checkDenominations(amount, denominations, 0);
        return 0;
    }

    private int _checkDenominations(int amount, int[] denominations) {
        int result[] = new int[amount+1];
        result[0] = 1;
        for(int i = 0; i < denominations.length; i++){
            int coin = denominations[i];
            int currentAmount = coin;
            while(currentAmount <= amount){
                if(currentAmount >= coin){
                    result[currentAmount] += result[currentAmount-coin];
                }
                currentAmount++;
            }
        }
        return result[amount];
    }

    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) {
            System.out.println("Made combination");
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) {
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length) {
            return 0;
        }

        System.out.println(String.format("checking ways to make %d with %s",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        currentIndex, denominations.length))));

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations,
                    currentIndex + 1);
            amountLeft -= currentCoin;
        }

        return numPossibilities;
    }
}
