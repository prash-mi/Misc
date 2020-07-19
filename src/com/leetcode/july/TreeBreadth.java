package com.leetcode.july;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBreadth {
    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        System.out.println(new TreeBreadth().widthOfBinaryTree(t1));
    }

    public  int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
     Queue<Pair> curLevel = new LinkedList<>();
     Queue<Pair> nextLevel = new LinkedList<>();

     curLevel.add(new Pair(root, 1));
     int maxWidth = Integer.MIN_VALUE, minLevelWidth=Integer.MAX_VALUE, maxLevelWidth = Integer.MIN_VALUE;
     while (!curLevel.isEmpty()){
         Pair curElem = curLevel.poll();
         minLevelWidth = Math.min(minLevelWidth, curElem.cnt);
         maxLevelWidth = Math.max(maxLevelWidth, curElem.cnt);
         if(curElem.node.left!= null){
             nextLevel.add(new Pair(curElem.node.left, curElem.cnt*2));
         }
         if(curElem.node.right!= null){
             nextLevel.add(new Pair(curElem.node.right, (curElem.cnt*2) +1));
         }

         if (curLevel.isEmpty()){
             curLevel = nextLevel;
             nextLevel = new LinkedList<>();
             maxWidth = Math.max(maxWidth, (maxLevelWidth-minLevelWidth + 1 ));
             minLevelWidth=Integer.MAX_VALUE;//reset the level variables
             maxLevelWidth = Integer.MIN_VALUE;
         }
     }
    return maxWidth;
    }


}

class Pair{
    TreeNode node;
    int cnt;
    Pair(TreeNode cur, int cnt){
        this.node = cur;
        this.cnt = cnt;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

