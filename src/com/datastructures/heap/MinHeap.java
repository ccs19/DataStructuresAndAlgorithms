package com.datastructures.heap;

public class MinHeap implements Heap {

    private static final int START_SIZE = 1;
    private int[] heap;
    private int size;


    public MinHeap(){
        size = 0;
        heap = new int[START_SIZE];
    }

    public int peek(){
        return heap[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(int... n) {
        for(int _n : n){
            _insert(_n);
        }
    }


    private void _insert(int n){
        checkSize();
        heap[size] = n;
        sort();
        size++;
    }

    private void sort() {
        int i = size;
        while(i > 0 &&  heap[i] < heap[i/2]){
            swap(i, i/2);
            i = i/2;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
        System.out.printf("Swapped %d and %d\n", heap[i], heap[j]);
    }

    @Override
    public int pop() {
        int min = heap[0];
        heap[0] = heap[--size];
        int index = 0;
        while(index < size){
            int swap = 0;
            int pos1 = index*2+1;
            int pos2 = index*2+2; //ISSUE: Need to check array bounds. Otherwise it seems to work.
            if(pos1 < size && pos2 < size) {
                if (heap[pos1] > heap[pos2]) {
                    swap = index * 2 + 2;
                } else {
                    swap = index * 2 + 1;
                }
            }else{
                break;
            }
            swap(index, swap);
            index = swap;
        }
        return min;
    }

    private void checkSize() {
        if(size == heap.length){
            resizeArray();
        }
    }

    private void resizeArray() {
        int[] newHeap = new int[heap.length * 2];
        for(int i = 0; i < heap.length; i++){
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }



    @Override
    public void print() {
        String str = "";
        boolean done = false;
        for(int i = 0;!done;){
            int start = 0;
            int end = 0;
            if(i != 0) {
                start = (int)Math.pow(2.0,i) -1;
                end = (int) Math.pow(2.0,i+1)-2;
            }
            for(int j = start; j < end+1; j++){
                if(j == size){
                    done = true;
                    break;
                }
                str += heap[j] + "[" + j + "] , ";
            }
            str += "\n";
            //System.out.print(str);

            i++;

        }
        System.out.print(str);
    }
}
