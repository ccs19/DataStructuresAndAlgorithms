package com.ctci.graphs;

public class GraphBuilder {

    /**
     * Create a new graph with a single node of name.
     * @param name
     * @return
     */
    public static Graph buildGraph(String name){
        Graph g = new Graph();
        buildNode(g, null, null, name);
        return g;
    }

    public static Node buildNode(Graph graph, Node parent, Node child, String name){
        Node node = new Node();
        node.name = name;
        if(parent != null){
            parent.children.add(node);
        }
        if(child != null){
            node.children.add(child);
        }
        graph.nodes.add(node);
        return node;
    }

    public static void addChild(Node parent, Node child){
        if(child != null && parent != null){
            parent.children.add(child);
        }
    }

}
