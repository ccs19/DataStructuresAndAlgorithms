package com.ctci;

import com.ctci.graphs.*;
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
     *
     * //Could also be implemented with an ArrayList<LinkedList<Integer>> instead of hash map.
     */
    private LinkedList<Integer>[] listOfDepths(TreeNode<Integer> root){
        if(root == null) return null;
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        traverseListOfDepths(root,map);
        return map.values().toArray(new LinkedList[0]);
    }

    private void traverseListOfDepths(TreeNode<Integer> root, Map<Integer, LinkedList<Integer>> map) {
        traverseDepth(root,map,0);
    }

    private void traverseDepth(TreeNode<Integer> root, Map<Integer, LinkedList<Integer>> map, int i) {
        if(root == null) return;
        LinkedList<Integer> list;
        if(map.containsKey(i)){
            list = map.get(i);
        }else{
            list = new LinkedList<>();
            map.put(i,list);
        }
        list.add(root.value);
        traverseDepth(root.left, map, i+1);
        traverseDepth(root.right, map, i+1);
    }


    /**
     * CTCI 4.4 Check Balanced
     * Checks if a binary tree is balanced.
     */
    public boolean isBalanced(TreeNode<?> root){
        return checkBalanced(root,0, new ArrayList<Integer>());
    }

    private boolean checkBalanced(TreeNode<?> root, int current, List<Integer> minMax) {
        if(root == null){
            current--;
            if(minMax.size() == 2){
                return minMax.get(0) == current || minMax.get(1) == current;
            }else if(minMax.size() == 1){
                if(current != minMax.get(0)){
                    minMax.add(current);
                }
                int diff = Math.abs(minMax.get(0) - current);
                return diff == 0 || diff == 1;
            }else{
                minMax.add(current);
                return true;
            }
        }
        if(!checkBalanced(root.left,current+1, minMax)) return false;
        if(!checkBalanced(root.right, current+1, minMax)) return false;
        return true;
    }


    /**
     * CTCI 4.5
     * Check if a binary tree is a binary search tree
     *
     */
    //TODO Come back to this (_isBst)
    public boolean isBst(TreeNode<Integer> root){
        if(!checkLeft(root.left, root.value)) return false;
        if(!checkRight(root.right, root.value)) return false;
        return true;
    }

    static Integer lastPrinted = null;
    public boolean _isBst(TreeNode<Integer> root){
        if(root == null) return true;

        if(!_isBst(root.left)) return false;
        System.out.printf("%d <= %d\n", root.value, lastPrinted);
        if(lastPrinted != null && root.value <= lastPrinted){
            return false;
        }
        lastPrinted = root.value;
        if(!_isBst(root.right)) return false;
        return true;
    }

    private boolean checkLeft(TreeNode<Integer> node, int rootValue) {
        if(node == null){
            return true;
        }
        if(node.value > rootValue) return false;
        if(!checkLeft(node.left, rootValue)) return false;
        if(!checkLeft(node.right, rootValue)) return false;
        return true;
    }


    private boolean checkRight(TreeNode<Integer> node, int value){
        if(node == null){
            return true;
        }
        if(node.value <= value) return false;
        if(!checkRight(node.left, value)) return false;
        if(!checkRight(node.right, value)) return false;
        return true;
    }

    @Test
    public void testIsBst(){
        int[] values = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode<Integer> root = sort(values);
        //System.out.println(isBst(root));//true
        System.out.println("!! " + _isBst(root));
        System.out.println(root);
        root.left.value = root.value;
        lastPrinted = null;
        //System.out.println(isBst(root));//false
        System.out.println("!! " + _isBst(root)); //false
        System.out.println(root);

        root.right.value = root.value;
        //System.out.println(isBst(root));//false

        root = sort(values);
        //System.out.println(isBst(root));//true

        root.right.right.right.value = 6;
        //System.out.println(isBst(root));//false
    }

/**
    @Test
    public void testIsBalanced(){
        int[] values = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode<Integer> root = sort(values);
        System.out.println(isBalanced(root));
        root.right.right = null;
        root.right.left = null;
        System.out.println(isBalanced(root));
        root.right = null;
        System.out.println(isBalanced(root));
        //System.out.println(root);
        root.left.left = null;
        root.left.right = null;
        System.out.println(isBalanced(root));
        System.out.println(root);
    }

    /**
     *
    @Test
    public void testListOfDepths(){
        int[] values = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode<Integer> root = sort(values);
        System.out.println(root);
        LinkedList<Integer>[] lists = listOfDepths(root);
        for(LinkedList<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " --> ");
            }
            System.out.println();
        }
    }


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
