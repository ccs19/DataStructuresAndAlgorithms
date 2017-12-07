package com.interviewcake.util;

public class TreeNode {


    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode insertLeft(int leftValue) {
        this.left = new TreeNode(leftValue);
        return this.left;
    }

    public TreeNode insertRight(int rightValue) {
        this.right = new TreeNode(rightValue);
        return this.right;
    }


}
