package com.interviewcake;

import org.junit.jupiter.api.Test;

public class TradingStock {

    /**
     * Suppose we could access yesterday's stock prices as an array, where:

     The indices are the time in minutes past trade opening time, which was 9:30am local time.
     The values are the price in dollars of Apple stock at that time.
     So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

     Write an efficient method that takes stockPricesYesterday and returns
     the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
     */
    public int bestProfit(int[] stockPrices){
        int bestProfit = stockPrices[1] - stockPrices[0];
        int lowestPrice = Math.min(stockPrices[0], stockPrices[1]);
        for(int i = 2; i < stockPrices.length; i++){
            int current = stockPrices[i];
            bestProfit = Math.max(bestProfit, current - lowestPrice);
            lowestPrice = Math.min(lowestPrice, current);
        }
        return bestProfit;
    }

    @Test
    public void testBestProfit(){
        System.out.println(bestProfit(new int[]{10,7,5,8,11,9,12}));
    }

}
