package com.ctci;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chapter13 {

    /**
     * CTCI 13.8: Lambda random
     * Using lambda expressions, write a function that returns a random subset of arbitrary size. All subsets should be equally likely to be chosen.
     *
     */
    @Test
    public void getRandom(){
        List<Integer> list = new ArrayList<>();
        addInts(list, 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        int[] check = new int[list.size()];

        RandomSubset randomSubset = (input) -> {
            Random rand = new Random();
            int index1 = Math.abs(rand.nextInt(input.size()));
            int index2 = Math.abs(rand.nextInt(input.size()));
            int lowerIndex = index1 < index2 ? index1: index2;
            int higherIndex = index1 < index2 ? index2 : index1;
            List<Integer> newList = new ArrayList<>();
            check[lowerIndex]++;
            check[higherIndex]++;
            for(int i = lowerIndex; i < higherIndex; i++){
                newList.add(input.get(i));
                //if(input.get(i)==20) System.out.println("twenty");
            }
            return newList;
        };
        for(int i = 0; i < 50000; i++){
            randomSubset.getRandomSubset(list);
        }
        for(int i = 0; i < check.length; i++){
            System.out.println((i) + " : " + check[i]);
        }

    }

    public void addInts(List<Integer> list, int... ints){
        for(int integer : ints){
            list.add(integer);
        }
    }

    public interface RandomSubset{
        List<Integer> getRandomSubset(List<Integer> list);
    }
}
