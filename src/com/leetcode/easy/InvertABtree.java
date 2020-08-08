package com.leetcode.easy;
//https://leetcode.com/problems/invert-binary-tree/
public class InvertABtree {

    public TreeNode invertTree(TreeNode cur) {
        if (cur == null){
            return null;
        }
        TreeNode left = cur.left;
        cur.left = cur.right;
        cur.right = left;
        invertTree(cur.left);
        invertTree(cur.right);
    return cur;
    }
}

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

