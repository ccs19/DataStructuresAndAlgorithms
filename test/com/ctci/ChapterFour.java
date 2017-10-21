package com.ctci;

import com.ctci.graphs.Graph;
import com.ctci.graphs.GraphBuilder;
import com.ctci.graphs.Node;
import com.ctci.graphs.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ChapterFour {


    /**
     * CTCI 4.1 Route between two nodes
     * Given a directed graph, find out if there is a route between two nodes.
     */
    public boolean isRoute(Node node1, Node node2){
        if(node1 == node2) return true;
        if(breadthFirstSearch(node1, node2, new HashSet<Node>()))
            return true;
        if(breadthFirstSearch(node2, node1, new HashSet<Node>()))
            return true;
        return false;
    }

    boolean depthFirstSearch(Node node, Node searchFor, Set<Node> visited){
        if(node == null) return false;
        if(node == searchFor) return true;
        visited.add(node);
        for(Node child : node.children){
            if(!visited.contains(child)){
                if(depthFirstSearch(child, searchFor, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean breadthFirstSearch(Node node, Node searchFor, Set<Node> visited){
        Queue<Node> queue = new LinkedList<>();
        visited.add(node);
        queue.add(node);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n == searchFor) return true;
            for(Node child : n.children){
                if(!visited.contains(child)){
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        return false;
    }


    /**
     * CTCI 4.2 Minimal tree.
     * Given a sorted array with unique integer elements, write an create a binary search tree with minimal height.
     *
     *  Split the array into sub arrays, then build out the tree.
     */
    public TreeNode sort(int[] integers){
        TreeNode<Integer> rootNode = null;
        TreeNode<Integer> leftNode = null;
        TreeNode<Integer> rightNode = null;

        if(integers.length > 2) {
            int rootVal = integers[integers.length / 2];
            int[] left = Arrays.copyOfRange(integers, 0, integers.length / 2);
            int[] right = Arrays.copyOfRange(integers, integers.length / 2 + 1, integers.length);
            rootNode = new TreeNode<>(rootVal);
            leftNode = sort(left);
            rightNode = sort(right);
        }else if(integers.length == 2){
            rootNode = new TreeNode<>(integers[1]);
            leftNode = new TreeNode<>(integers[0]);
        }else if(integers.length == 1){
            rootNode = new TreeNode<>(integers[0]);
        }

        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }


    private void insertBst(TreeNode<Integer> node, TreeNode<Integer> insertNode) {
        insert(node, insertNode);
    }

    private TreeNode<Integer> insert(TreeNode<Integer> node, TreeNode<Integer> insertNode) {
        if(node == null) return insertNode;
        if(insertNode.value < node.value){
            node.left = insert(node.left, insertNode);
        }else if(insertNode.value >= node.value){
            node.right = insert(node.right, insertNode);
        }
        return node;
    }

    /**
     * CTCI 4.3 List of Depths
     * Given a binary tree, create LinkedLists cotaining elements of each level.
     * e.g. a tree of depth D should return D linkedLists.
     */
    private LinkedList<Integer>[] listOfDepths(TreeNode<Integer> root){
        if(root == null) return null;
        return null;
    }

    @Test
    public void testListOfDepths(){

    }


    @Test
    public void testSomething(){
        int[] values = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode<Integer> root = sort(values);
        LinkedList<Integer>[] lists = listOfDepths(root);
        for(LinkedList<Integer> list : lists){
            for(Integer i : list){
                System.out.println(i + " --> ");
            }
        }
    }

    /**
     *
    @Test
    public void testSortTree(){
        int[] values = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        System.out.println(sort(values));
    }


    @Test
    public void testIsRoute(){
        Graph g = GraphBuilder.buildGraph("zero");
        Node zero = g.nodes.get(0);
        Node one = GraphBuilder.buildNode(g, zero, null, "one");
        Node two = GraphBuilder.buildNode(g, one, null, "two");
        Node three = GraphBuilder.buildNode(g, null, zero, "three");
        Node four = GraphBuilder.buildNode(g, null, null, "four");
        Node five = GraphBuilder.buildNode(g, four, four, "five");
        Node six = GraphBuilder.buildNode(g, zero, null, "six");
        Node seven = GraphBuilder.buildNode(g, zero, null, "seven");
        GraphBuilder.addChild(two, zero); //Creates cycle
        //GraphBuilder.addChild(four, five);
        //Check for route between zero and two Should be true.
        System.out.println(isRoute(zero, two));
        //Check for route between zero and three. Should be true.
        System.out.println(isRoute(zero, three));
        //Check for route between zero and five. Should be false;
        System.out.println(isRoute(zero,five));

    }

**/



}
