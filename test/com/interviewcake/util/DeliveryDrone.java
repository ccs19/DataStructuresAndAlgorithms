package com.interviewcake.util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class DeliveryDrone {

    /**
     * Given an array with many duplicate integers and one unique integer, find the unique integer.
     * HashSet... easy solution.
     */



    @Test
    public void testDrone(){
        int[] ids = new int[]{17,19,21,44,55,66,62,61,6,4,12,18,19,21,44,55,66,62,61,6,4,12,18}; //Expected 17
        System.out.println(_findMissingDrone(ids));
    }

    private int findMissingDrone(int[] ids) {
        Set<Integer> orderIds = new HashSet<>();
        for(int order : ids){
            if(orderIds.contains(order)){
                orderIds.remove(order);
            }else{
                orderIds.add(order);
            }
        }
        return orderIds.toArray(new Integer[1])[0];
    }
    private int _findMissingDrone(int[] ids) {
        int orderNumber = 0;
        for(int id: ids){
            orderNumber ^= id;
        }
        return orderNumber;
    }


}
