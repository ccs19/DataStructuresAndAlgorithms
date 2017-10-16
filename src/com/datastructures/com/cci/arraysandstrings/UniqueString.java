package com.datastructures.com.cci.arraysandstrings;

public class UniqueString {

    public static boolean uniqueString(char[] word){
        boolean[] list = new boolean[26];
        for(char c : word){
            c = (char) (Character.toLowerCase(c) - 'a');
            if(list[c]){
                return false;
            }
            list[c] = true;
        }
        return true;
    }

    public static void main(String[] args){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(uniqueString(alphabet.toCharArray()));
        String alphabet2 = "abcdefghijklmnopqrstuvwxyza";
        System.out.println(uniqueString(alphabet2.toCharArray()));
    }

}
