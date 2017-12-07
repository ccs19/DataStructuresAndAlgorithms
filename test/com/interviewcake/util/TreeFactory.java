package com.interviewcake.util;

public class TreeFactory {


    public static TreeNode getBalancedTree(){
        TreeNode root = new TreeNode(1);
        root.left = n(2);
        root.left.left = n(3);
        root.left.right = n(4);
        root.right = n(5);
        root.right.left = n(6);
        root.right.right = n(7);
        return root;
    }

    public static TreeNode getUnbalancedTree(){
        TreeNode root = getBalancedTree();
        root.right.right.right = n(8);
        root.right.right.right.right = n(9);
        return root;
    }

    private static TreeNode n(int value){
        return new TreeNode(value);
    }

}
