package com.ctci.stack.animalshelter;

public enum AnimalType {



    DOG("dog"),
    CAT("cat");

    private final String type;

    AnimalType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
