package com.datastructures.heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class MinHeapTest {

    Heap minHeap = new MinHeap();



    @Test
    public void something(){
        String[] result = (textJustification(new String[]{"Two",
                "words."}, 10));
        for(String s : result){
            System.out.println(s);
        }
    }

    String[] textJustification(String[] words, int l) {
        String word = "";
        int len = 0;
        List<String> wordList = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            len += words[i].length() + 1;
            if(len-1 == l){
                len = 0;
                word += words[i];
                wordList.add(word);
                word = "";
            }
            else if(len > l) {
                len = 0;
                wordList.add(word.trim());
                word = words[i] + " ";
                len += words[i].length() +1;
            }else{
                word += words[i] + " ";
            }
        }
        if(word.length() > 0) wordList.add(word.trim());

        String[] padded = padList(wordList,l);

        return padded;
    }

    String[] padList(List<String> wordList, int l){
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < wordList.size(); i++){
            if(i == wordList.size() -1){
                int padding = l - wordList.get(i).length();
                sb.append(wordList.get(i));
                for(int j = 0; j < padding; j++){
                    sb.append(" ");
                }
                result.add(sb.toString());
                break;
            }
            String word = wordList.get(i);
            String[] split = word.split(" ");
            int padding = l - word.length() + split.length - 1;
            for(int k = padding, j = 0; k > 0; k--, j++){
                int index = 0;
                if(split.length > 1){
                    index = j % (split.length - 1);
                }
                split[index] += " ";
            }

            for(int k = 0; k < split.length; k++){
                sb.append(split[k]);
            }
            result.add(i, sb.toString());
            sb = new StringBuilder();
        }
        return result.toArray(new String[0]);
    }




    //@Test
    public void testFill(){
        fillHeap();
        minHeap.print();
    }


    @Test
    public void testMath(){

        int [][] n = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] n1 = new int[][]{{1,2,3},{1,4,2},{5,6,6}};


        System.out.println(rotateImage(n));
    }
    int[][] rotateImage(int[][] a) {
        int q = a.length-1;
        for(int i = 0;i < a.length / 2; i++, q--){
            int first = i;
            int last = a.length - 1 - i;
            for(int j = first;j < last; j++){
                int offset = j - first;
                int temp = a[first][j];
                a[first][j] = a[last-offset][first];
                a[last-offset][first] = a[last][last-offset];
                a[last][last-offset] = a[j][last];
                a[j][last] = temp;
            }
        }
        return a;
    }



    @Test
    public void testRemove(){
        fillHeap();
        //System.out.println(minHeap.peek());
        minHeap.print();
        System.out.println("REMOVING:");

        while(!minHeap.isEmpty()) {
            System.out.println("POP: " + minHeap.pop());
            //minHeap.print();
        }
    }

    private void fillHeap() {
        minHeap.insert(5,2,1,79,12,24,14,-1,77,212,52,278);
    }


    //@Test
    public void testPrint(){
        int[] array = new int[]{5,2,1,79,12,24};
        String str = "";
        boolean done = false;
        for(int i = 0;!done;){
            int start = 0;
            int end = 0;
            if(i != 0) {
                start = (int)Math.pow(2.0,i) -1;
                end = (int) Math.pow(2.0,i+1)-2;
            }
            System.out.println("Start: " + start + " End: " + end);
            for(int j = start; j < end+1; j++){
                if(j == array.length){
                    done = true;
                    break;
                }
                str += array[j] + "[" + j + "] , ";
            }
            str += "\n";
            //System.out.print(str);

            i++;

        }
        System.out.print(str);
    }
}
