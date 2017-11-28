package com.algorithms.sort;

import org.jetbrains.annotations.TestOnly;

public class QuickSort {

    public static void sort(int[] array){
        if(array == null || array.length <= 1) return;
        int high = array.length-1;
        int low = 0;
        quickSort(array, low, high);

    }

    private static void quickSort(int[] array, int low, int high) {
        System.out.printf("low: %d high %d\n", low, high);
        if (low >= high) return;
        int pivot = (low + high) / 2;
        System.out.println(pivot);
        int i = low;
        int j = high;
        while(i <= j){
            while(array[i] < array[pivot] ){
                i++;
            }
            while(array[j] > array[pivot] ){
                j--;
            }
            if(i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(array, low, j);
        quickSort(array, i, high);
    }


}
