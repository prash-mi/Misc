package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnForest {
    public static void main(String[] args){

        /*
        5
       /  \
      3    6
     / \    \
    2   4     7
      */

        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t5.left = t3;
        t5.right = t6;
        t6.right = t7;
        t3.left=t2;
        t3.right = t4;

        int[] to_del = {3,7};
        List<TreeNode> forest =  new ReturnForest().delNodes(t5, to_del);
        System.out.println();

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int i: to_delete){
            toDelete.add(i);
        }
        createForest(root, toDelete, forest);
        if (!toDelete.contains(root.val)){
            forest.add(root);
        }
        return forest;
    }

   private TreeNode createForest(TreeNode cur, Set<Integer> toDelete, List<TreeNode> forest ){
        if (cur == null){
            return null;
        }
        if (toDelete.contains(cur.val)){//put the children's ref in forest (if they are not null and not to be deleted)
            if(cur.left != null && !toDelete.contains(cur.left.val)){
                forest.add(cur.left);
            }
            if(cur.right != null && !toDelete.contains(cur.right.val)){
                forest.add(cur.right);
            }
        }
        //dfs and delete
        cur.left = createForest(cur.left, toDelete, forest);
        cur.right = createForest(cur.right, toDelete, forest);
        return toDelete.contains(cur.val)?null:cur;
    }

    /******Class definition*******/

/*class TreeNode {
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
 }*/
}
