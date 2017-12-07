package com.interviewcake;

import com.interviewcake.util.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class GraphColoring {

    /**
     * Given an undirected graph with maximum degree D, find a graph coloring using at most D+1 colors.
     */
    static final String[] COLORS = {"Red", "Blue", "Green", "Purple"};
    private void colorGraph(GraphNode[] node){
        Set<String> colorsInUse = null;
        for(GraphNode parent : node){
            colorsInUse = new HashSet<>();
            for(GraphNode child : parent.getNeighbors()){
                if(child.hasColor()){
                    colorsInUse.add(child.getColor());
                }
            }
            for(String color : COLORS){
                if(!colorsInUse.contains(color)){
                    parent.setColor(color);
                    break;
                }
            }
        }
    }

    @Test
    public void testColorGraph(){
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");

        a.addNeighbor(b);
        b.addNeighbor(a);
        b.addNeighbor(c);
        c.addNeighbor(b);

        GraphNode[] graph = new GraphNode[] { a, b, c };
        colorGraph(graph);
        for(GraphNode g : graph){
            System.out.printf("Node: %s, Color %s\n", g.getLabel(), g.getColor());
            for(GraphNode child : g.getNeighbors() ){
                System.out.printf("Child: %s, Color %s\n", child.getLabel(), child.getColor());
            }
        }
    }

}
