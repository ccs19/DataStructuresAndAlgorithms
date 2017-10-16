package com.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1.1 CTCI
 */

public class ChapterOne {

    /**
     * Does the string have unique characters?
     * assuming only ascii, a-z
     */
    public static boolean isUnique(String str){
        int bitmap = 0x0;
        int bitmask = 0x1;

        char[] array = str.toCharArray();
        for(char character : array){
            int shift = (Character.toLowerCase(character) - 'a');
            int exists = bitmap >> shift & bitmask;
            if(exists == 1){
                return false;
            }else{
                bitmap |= 1 << shift;
            }
        }
        return true;
    }

    /**
     * Is permutation?
     * 1.2 CTCI
     * is string2 a permutation of string1?
     *
     * assuming only ascii a-z
     */
    public static boolean isPermutation(String string1, String string2){
        if(string1.length() != string2.length()) return false;

        int[] charVector = new int[26];
        for(int i = 0; i < string1.length(); i++){
            int indexString1 = Character.toLowerCase(string1.charAt(i)) - 'a';
            int indexString2 = Character.toLowerCase(string2.charAt(i)) - 'a';
            charVector[indexString1]++;
            charVector[indexString2]--;
        }
        for(int i = 0; i < charVector.length; i++){
            if(charVector[i] != 0) return false;
        }
        return true;
    }


    /**
     * URLIFY a string. Converts ' ' to '%20'
     * 1.3 CTCI
     * Assumes char[] has enough space for %20. (length +
     */
    public void urlify(char[] url){
        int numSpaces = 0;
        int length = 0;
        for(int i = 0; i < url.length; i++){
            length++;
            if(url[i] == ' '){
                numSpaces++;
            }
            else if(url[i] == '\0'){
                length -= 1;
                break;
            }
        }

        for(int i = length - 1 ; i > 0; i--){
            if(url[i] == ' '){
                int index = numSpaces * 2 + i;
                url[index] = '0';
                url[index - 1] = '2';
                url[index - 2] = '%';
                numSpaces -= 1;
            }else{
                url[numSpaces * 2 + i] = url[i];
            }
        }
    }


    /**
     * Is permutation of palindrome
     * 1.4 CTCI
     * Assume ASCII, ignores case.
     */
    public boolean isPermutationPalindrome(String input){
        int[] asciiMap = new int[128];
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' ') continue;
            asciiMap[input.charAt(i)]++;
        }
        boolean foundOdd = false;
        for(int i = 0; i < asciiMap.length; i++){
            if(asciiMap[i] > 0 && asciiMap[i] % 2 != 0){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * CTCI 1.5
     * Returns true if strings are equal or one edit away from equal.
     */
    public boolean oneAway(String str1, String str2){
        int diff = Math.abs(str1.length() - str2.length());
        if(diff > 1) {
            return false;
        }
        int[] asciiTable = new int[128];
        for(int i = str1.length()-1, j = str2.length()-1; ; i--, j--){
            if(i >= 0) asciiTable[str1.charAt(i)]++;
            if(j >= 0) asciiTable[str2.charAt(j)]--;
            if(i <= 0 && j <= 0) break;
        }
        int differences = 0;
        for(int i = 0; i < asciiTable.length; i++){
            differences += Math.abs(asciiTable[i]);
            if(differences > 2) return false;
        }

        return true;
    }

    /**
     * CTCI 1.6
     * String compression
     */
    public String compressString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            sb.append(c);
            int count = 1;
            while(true){
                if(i+1 == str.length()){
                    sb.append(count);
                    break;
                }
                if(str.charAt(i+1) == str.charAt(i)){
                    count++;
                    i++;
                }else{
                    sb.append(count);
                    break;
                }
            }
        }
        return sb.length() >= str.length() ? str : sb.toString();
    }


    /**
     * CTCI 1.7
     * Rotate matrix
     *
     * Rotates a matrix 90 degrees.
     */
    public void rotateMatrix(int[][] matrix){
        int len = matrix.length;
        for(int i = 0; i < len/2; i++){
            for(int j = len - 1; j+1 > len/2; j--){
                int temp = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = matrix[len - j - 1][len - i - 1];
                matrix[len - j - 1][len - i - 1] = matrix[len-i-1][j];
                matrix[len-i-1][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * CTCI 1.8
     * In an MxN matrix, if an element is 0, its row and column are set to zero.
     */
    public void zeroMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> pairs = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    pairs.add(new int[]{i,j});
                }
            }
        }
        for(int[] pair : pairs){
            int x = pair[0];
            int y = pair[1];
            for(int i = 0; i < m; i++){
                matrix[x][i] = 0;
            }
            for(int i = 0; i < n; i++){
                matrix[i][y] = 0;
            }
        }
    }

    /**
     * CTCI 1.9
     * String rotation.
     * Given two strings, is s2 a rotation of s1?
     * Can only call substring once.
     */
    public boolean isRotation(String s1, String s2){
        if(s1 != null && s2 != null && s1.length() > 0 && s1.length() - s2.length() == 0){
            return (s2 + s2).contains(s1);
        }
        return false;
    }


    /**
     @Test
    public void testZeroMatrix(){
        int[][] m = new int[][]{
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,0,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };
        zeroMatrix(m);
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**   @Test
    public void testRotateMatrix(){
        int[][] matrix2 = new int[][]{
                {1,1,3,3},
                {1,1,3,3},
                {5,5,7,7},
                {5,5,7,7}
        };
        int[][] matrix = new int[][]{
                {1,1,1,3,3},
                {1,1,1,3,3},
                {5,5,0,7,7},
                {5,5,5,7,7},
                {5,5,5,7,7}
        };
        rotateMatrix(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    @Test
    public void testCompressString(){
        System.out.println(compressString("aaabbcccd"));
        System.out.println(compressString("abcdefgh"));
    }


    @Test
    public void testOneDiff(){
        System.out.println("\nOnediff");
        System.out.println(oneAway("pale","ple"));
        System.out.println(oneAway("pales","pale"));
        System.out.println(oneAway("pale","bale"));
        System.out.println(oneAway("pale","bake"));
        System.out.println();
    }

    @Test
    public void testIsPermPalindrome(){
        System.out.println();
        System.out.println("IsPermPalindrome");
        System.out.println(isPermutationPalindrome("not a palindrome"));
        System.out.println(isPermutationPalindrome("tact coa"));
        System.out.println(isPermutationPalindrome("tact coatta"));
        System.out.println();
    }

    @Test
    public void testUrlify(){
        char[] input = new char[]{'t', ' ', 's', ' ', 'h','\0',' ',' ',' '};
        System.out.println("urlify: " + new String(input));
        urlify(input);
        System.out.println(input);
    }

    @Test
    public void testIsPermutation(){
        System.out.println("IsPermutation: ");
        System.out.println("False: " + isPermutation("abababab", "bababababa"));
        System.out.println("True: " + isPermutation("aaaaaaaabababab", "aaaaaaababababa"));
        System.out.println("false: " + isPermutation("atlanta", "georgia"));
        System.out.println("True: " + isPermutation("z", "z"));
        System.out.println("True: " + isPermutation("atlanta", "anatlta"));

    }


    @Test
    public void testBits(){
        System.out.println("ChapterOne: ");
        System.out.println("Fals: " + isUnique("aa"));
        System.out.println("False: " + isUnique("abcdefzzz"));
        System.out.println("True: " + isUnique("abcdefghijklmnopqrstuvwxyz"));
    }**/

}
