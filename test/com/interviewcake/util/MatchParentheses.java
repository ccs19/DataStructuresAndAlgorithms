package com.interviewcake.util;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MatchParentheses {
    /**
     * "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

     Write a function that, given a sentence like the one above, along with the position of an opening parenthesis,
     finds the corresponding closing parenthesis.

     Example: if the example string above is input with the number 10 (position of the first parenthesis),
     the output should be 79 (position of the last parenthesis).
     */
    public int findMatch(String sentenceString, int starting){
        int parenCount = 0;
        char[] sentence = sentenceString.toCharArray();
        int stackSizeAtPosition = 0;
        for(int i = 0; i < sentence.length; i++){
            char letter = sentence[i];
            if(letter == '('){
                parenCount++;
            }else if(letter == ')'){
                parenCount--;
                if(stackSizeAtPosition != 0 && parenCount < stackSizeAtPosition){
                    return i;
                }
            }
            if(i == starting){
                stackSizeAtPosition = parenCount;
            }

        }

        return 0;
    }
    @Test
    public void test(){
        String input = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        System.out.println(findMatch(input, 10));
    }


    /**
     * Let's say:

     '(', '{', '[' are called "openers."
     ')', '}', ']' are called "closers."
     Write an efficient function that tells us whether
     or not an input string's openers and closers are properly nested.

     Examples:

     "{ [ ] ( ) }" should return true
     "{ [ ( ] ) }" should return false
     "{ [ }" should return false
     */
    public boolean validateParentheses(String input){
        char[] array = input.toCharArray();
        Stack<Character> expectedStack = new Stack<>();
        Map<Character,Character> tokenMap = new HashMap<>();
        tokenMap.put('(',')');
        tokenMap.put('[',']');
        tokenMap.put('{','}');
        Set<Character> closingSet = new HashSet<>(tokenMap.values());

        for(char letter : array){
            if(tokenMap.containsKey(letter)){
                expectedStack.push(tokenMap.get(letter));
            }else if(closingSet.contains(letter)){
                if(expectedStack.isEmpty() || expectedStack.pop() != letter) return false;
            }
        }

        return true;
    }

    @Test
    public void testValidateParentheses(){
        String good = "{[]()}";
        String bad = "{[(])}";
        String bad2 = "{[}";
        System.out.println(validateParentheses(good));
        System.out.println(validateParentheses(bad));
        System.out.println(validateParentheses(bad2));

    }

}
