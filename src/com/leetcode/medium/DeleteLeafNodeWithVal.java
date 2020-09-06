package com.leetcode.medium;

public class DeleteLeafNodeWithVal {
    /*
    Target = 2

            1 -> 1
           /
          2
         /
        2

     */
    public TreeNode removeLeafNodes(TreeNode cur, int target) {
        if (cur == null){
            return null;
        }
        cur.left = removeLeafNodes(cur.left, target);
        cur.right = removeLeafNodes(cur.right, target);
        if (cur.left == null && cur.right == null && cur.val==target){
            return null;
        }else {
            return cur;
        }
    }
}
