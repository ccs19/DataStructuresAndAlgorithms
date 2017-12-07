package com.interviewcake;

import org.junit.jupiter.api.Test;

public class BigWords {

    /**
     * Given a rotated array of strings, find the index where they were rotated.
     *
     *      "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote",  // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage"

     Feels like this can be done in lg(n)?
     */

    public int findRotatedIndex(String[] array){
    /** O(logn)
       char firstLetter = array[0].charAt(0);
        for(int i = 0; i < array.length; i++){
            if(array[i].charAt(0) < firstLetter){
                return i;
            }

        }**/

        int floor = -1;
        int ceiling = array.length - 1;
        char startingCharacter = array[0].charAt(0);
        while(true){
            int length = ceiling - floor;
            int index = length/2 + floor;
            char firstLetter = array[index].charAt(0);

            if(firstLetter < startingCharacter){
                if(array[index-1].charAt(0) > firstLetter) return index;
                ceiling = index;
            }else if(firstLetter >= startingCharacter){
                if(array[index+1].charAt(0) < firstLetter) return index +1;
                floor = index;
            }
        }
    }

    @Test
    public void testRotatedIndex(){
        String[] words = new String[]{

                "babka",
                "banoffee",
                "engender",
                "gooftard",
                "hullaballo",
                "interactive",
                "juxtopose",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // 5

        };
        System.out.println(findRotatedIndex(words));

    }


}
