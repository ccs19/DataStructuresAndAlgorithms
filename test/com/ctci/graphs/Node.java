package com.ctci.graphs;

import java.util.ArrayList;

public class Node {
    public String name;
    public ArrayList<Node> children = new ArrayList<>();

    @Override
    public String toString(){
        return name;
    }
}
