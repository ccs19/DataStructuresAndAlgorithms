package com.ctci.graphs;

public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(){}

    public TreeNode(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return printTree("", this, false, sb);
    }

    private String printTree(String prefix, TreeNode<T> t, boolean isLeft, StringBuilder sb) {
        if(t != null){
            sb.append(prefix + (isLeft ? "|-- " : "\\-- ") + t.value + "\n");
            printTree(prefix + (isLeft ? "|   " : "    "), t.left, true, sb);
            printTree(prefix + (isLeft ? "|   " : "    "), t.right, true, sb);
        }
        return sb.toString();

    }

}
