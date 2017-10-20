package com.ctci.stack.animalshelter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * CTCI 3.6 Animal Shelter
 * Holds dogs and cats. Must adopt either a) The oldest dog/cat or b) the oldest dog or cat.
 */
public class AnimalShelter {

    private LinkedList<Animal> dogList;
    private LinkedList<Animal> catList;
    private int currentTime;

    public AnimalShelter(){
        dogList = new LinkedList<>();
        catList = new LinkedList<>();
        currentTime = 0;
    }


    public void enqueue(Animal animal){
        animal.setArrivalTime(currentTime++);
        if(animal.getType() == AnimalType.CAT){
            catList.add(animal);
        }else{
            dogList.add(animal);
        }
    }

    public Animal dequeue(){
        if(!bothListsEmpty()) {
            if (dogList.getFirst().getArrivalTime() < catList.getFirst().getArrivalTime()) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }else if(!dogList.isEmpty() && catList.isEmpty()){
            return dequeueDog();
        }else if(!catList.isEmpty() && dogList.isEmpty()){
            return dequeueCat();
        }
        return null;
    }

    private boolean bothListsEmpty(){
        return dogList.isEmpty() && catList.isEmpty();
    }

    public Animal dequeueDog(){
        if(!dogList.isEmpty()){
            return dogList.removeFirst();
        }
        return null;
    }

    public Animal dequeueCat(){
        if(!catList.isEmpty()){
            return catList.removeFirst();
        }
        return null;
    }
}


