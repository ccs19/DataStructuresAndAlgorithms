package com.interviewcake;

import com.interviewcake.util.TreeFactory;
import com.interviewcake.util.TreeNode;
import org.junit.jupiter.api.Test;

public class SuperBalanced {

    /**
     * Write a method to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
     A tree is "superbalanced" if the difference between the depths of any two leaf nodes is no greater than one.
     */
    public boolean isSuperBalanced(TreeNode root){
        deepest = -1;
        shallowest = -1;
        return _isSuperBalanced(root, 0);
    }
    static int deepest = -1;
    static int shallowest = -1;
    private boolean _isSuperBalanced(TreeNode root, int current) {
        if(root == null){
            deepest = Math.max(current, deepest);
            if(shallowest == -1) shallowest = current;
            else shallowest = Math.min(shallowest, current);
            System.out.printf("Value %d, Shallowest %d, Deepest %d\n",current,shallowest,deepest);
            if(Math.abs(shallowest - deepest) >= 2 && deepest >= 0 && shallowest >= 0){
                return false;
            }
            return true;
        }
        if(!_isSuperBalanced(root.left, current+1)){
            return false;
        }
        if(!_isSuperBalanced(root.right, current+1)){
            return false;
        }
        return true;
    }

    @Test
    public void superBalanced(){
        TreeNode balanced = TreeFactory.getBalancedTree();
        TreeNode unbalanced = TreeFactory.getUnbalancedTree();
        System.out.println(isSuperBalanced(balanced));
        System.out.println(isSuperBalanced(unbalanced));
    }
}
