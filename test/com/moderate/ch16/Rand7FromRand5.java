package com.moderate.ch16;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class Rand7FromRand5 {

    static Random r;
    static{
        r = new Random();
        r.setSeed(System.currentTimeMillis());
    }

    public static int rand5() {
        int val = r.nextInt() % 5;
        return (val < 0 ? val * -1 : val);
    }

    public static int rand7(){
        int val = rand5();
        val += rand5();
        val += rand5();
        val += rand5();
        val += rand5();
        val += rand5();
        val += rand5();
        return val % 7;
    }



    @Test
    public void test(){
        int[] buckets = new int[7];
        for(int i = 0; i < 50000000; i++){
            buckets[rand7()]++;
        }

        for(int i = 0; i < buckets.length; i++){
            System.out.println(i + ": " + buckets[i]);
        }
    }

}
