package com.algorithms.sort.challenges;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GetMaxProfit {/**
    Suppose we could access yesterday's stock prices as a list, where:

    The indices are the time in minutes past trade opening time, which was 9:30am local time.
    The values are the price in dollars of Apple stock at that time.
            So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

    stock_prices_yesterday = [10, 7, 5, 8, 11, 9]

    **/
    static int stockPricesYesterday(int[] prices){
        if(prices == null || prices.length <= 1) return 0;
        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int current: prices){
            min = Integer.min(min, current);
            int potential = current - min;
            maxProfit = Integer.max(potential, maxProfit);
        }
        return maxProfit;
    }

    private static int getProfit(int[] prices, int low, int high){
        return prices[high] - prices[low];
    }

    @Test
    public void testStockPrices(){
        int[] input = new int[]{10,7,5,8,11,9};
        int[] input2 = new int[]{9,11,8,5,4,5};
        System.out.println(stockPricesYesterday(input)); // should be 6
        System.out.println(stockPricesYesterday(input2)); //should be 2
    }
}

