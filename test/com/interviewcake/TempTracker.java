package com.interviewcake;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TempTracker {

    private int numberOfTemps;
    private int maxTemp;
    private int minTemp;
    private double meanTemp;
    private List<Integer> modeList;
    private int modeCount;
    private Map<Integer, Integer> temperatures;

    @Override
    public String toString(){
        return String.format("TempCount: %d, Max Temp: %d, Min Temp: %d, Mean Temp: %f, Mode: %s",
                numberOfTemps, maxTemp, minTemp, meanTemp, Arrays.toString(modeList.toArray()));
    }


    public TempTracker(){
        numberOfTemps = 0;
        maxTemp = Integer.MIN_VALUE;
        minTemp = Integer.MAX_VALUE;
        temperatures = new HashMap<>();
        modeList = new ArrayList<>();
    }

    public void insert(int temperature){
        if(!temperatures.containsKey(temperature)){
            temperatures.put(temperature, 1);
        }else{
            temperatures.put(temperature, temperatures.get(temperature) + 1);
        }
        updateStats(temperature);
    }

    private void updateStats(int temperature){
        maxTemp = Math.max(temperature, maxTemp);
        minTemp = Math.min(temperature, minTemp);
        meanTemp = (meanTemp * numberOfTemps + temperature) / (numberOfTemps + 1);
        numberOfTemps++;

        checkMode(temperature);
    }

    private void checkMode(int temperature) {
        int numberOfTemps = temperatures.get(temperature);
        if(numberOfTemps > modeCount){
            modeCount = numberOfTemps;
            modeList.clear();
            modeList.add(temperature);
        }else if (numberOfTemps == modeCount){
            modeList.add(temperature);
        }
    }

    public int getMax(){
        return maxTemp;
    }

    public int getMin(){
        return minTemp;
    }

    public List<Integer> getMode(){
        return modeList;
    }

    public double getMean(){
        return meanTemp;
    }

    public static class TestClass{
        @Test
        public void testTracker(){
            int[] temps = new int[]{55,12,110,0,55,66,66,71,82,51,15,79};
            TempTracker tt = new TempTracker();
            for(int temp : temps){
                tt.insert(temp);
                System.out.println(tt);
            }
            int total = 0;
            for(int i = 0; i < temps.length; i++){
                total += temps[i];
                int avg = total / (i+1);
                System.out.println("avg: " + avg);
            }
        }
    }


}
