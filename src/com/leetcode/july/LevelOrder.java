package com.leetcode.july;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {

    public static void main(String[] args){


    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stk = new Stack<>();
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> rev = new LinkedList<>();

        if(root == null ){
            return rev;
        }

        que.add(root);
        que.add(null);
        List<Integer> temp = new LinkedList<>();
        while(!que.isEmpty()){
            TreeNode cur =  que.poll();

            if (cur!= null){
                temp.add(cur.val);
                if(cur.left != null){
                    que.add(cur.left);
                }
                if(cur.right != null){
                    que.add(cur.right);
                }
            }else{
                stk.add(temp);
                temp = new LinkedList<>();
                if(!que.isEmpty()) {
                    que.add(null);
                }
            }
        }

        while (!stk.isEmpty()){
            rev.add(stk.pop());
        }

        return rev;
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