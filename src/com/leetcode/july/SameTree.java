package com.leetcode.july;

public class SameTree {

    public static void main(String[] args){

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q!= null) || (q==null && p!=null)){
            return false;
        }
        if(p!= null && q!= null && p.val!=q.val){
            return false;
        }

        if(p!= null && q!= null && !isSameTree(p.left, q.left)){
            return false;
        }
        if(p!= null && q!= null && !isSameTree(p.right, q.right)){
            return false;
        }
        return true;
    }
}

/*
 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
*/