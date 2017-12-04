package com.algorithms.sort.challenges;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    static List<BigInteger> fibCache;
    static BigInteger getFib(int n){
        if(fibCache == null){
            fibCache = new ArrayList<>();
            fibCache.add(BigInteger.ZERO);
            fibCache.add(BigInteger.ONE);
        }
        while(fibCache.size() < n+1){
            int index = fibCache.size();
            BigInteger value = fibCache.get(index-1).add(fibCache.get(index-2));
            fibCache.add(index, value);
        }
        return fibCache.get(n);
    }

    @Test
    public void testFib(){
        System.out.println(getFib(5));
        System.out.println(getFib(275000));
        System.out.println(getFib(275000));
        for(int i = 0; i < 100; i++){
            System.out.println(getFib(i));
        }
    }
}
