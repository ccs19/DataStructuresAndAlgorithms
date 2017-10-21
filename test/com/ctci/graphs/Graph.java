package com.ctci.graphs;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Node> nodes = new ArrayList<>();


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Node node : nodes){
            sb.append(node.name + " --> ");
            for(Node child : node.children){
                sb.append(child.name + " & ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
