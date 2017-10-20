package com.ctci.stack.animalshelter;

public class Animal {

    private final AnimalType type;
    private int arrivalTime;
    private String name;


    public Animal(AnimalType type, String name){
        this.type = type;
        this.name = name;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public AnimalType getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public static Animal generate(AnimalType type, String name){
        return new Animal(type,name);
    }

    @Override
    public String toString(){
        return String.format("Time: %d, Type: %s, Name: %s", arrivalTime, type.getType(), name);
    }

}
