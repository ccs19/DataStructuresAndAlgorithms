package com.interviewcake;

import java.util.HashSet;
import java.util.Set;

public class MovieFlight {
    /**
     * Users on longer flights like to start a second movie right when their first one ends,
     * but they complain that the plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.

     Write a method that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes)
     and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.
     */

    public boolean movieLengths(int flightLength, int[] movieLengths){
        Set<Integer> movieSet = new HashSet<>();
        for(int movieLength : movieLengths){
            int desiredMovieLength = flightLength - movieLength;
            if(movieSet.contains(desiredMovieLength)){
                return true;
            }
            movieSet.add(movieLength);
        }
        return false;
    }
}
