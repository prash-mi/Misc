package com.leetcode.medium;

import java.util.Stack;

public class BSTIterator {
    public static void main(String[] args){
        TreeNode t7 = new TreeNode(7);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t15 = new TreeNode(15);
        t7.right = t15;
        t7.left = t3;
        t3.left=t1;
        t1.right=t2;
        BSTIterator bstIte = new BSTIterator(t7);
        while (bstIte.hasNext()){
            System.out.println(bstIte.next());
        }

    }


    public BSTIterator(TreeNode root) {
        cur=root;
    }

    //(1) time
    public int next() {//constant time on an average. for n calls it will visit n nodes, hence resulting in n as average
        TreeNode inOrderNext = inOrderNext();
        return inOrderNext == null?-1:inOrderNext.val;
    }
    //(1) time
    public boolean hasNext() {
        return cur!=null || !callStk.isEmpty();
    }

    private TreeNode cur;
    private Stack<TreeNode> callStk = new Stack<>();

    private TreeNode inOrderNext(){


        if (cur!=null || !callStk.isEmpty()){

            //explore left and push to the stack
            while (cur!=null){
                callStk.push(cur);
                cur = cur.left;
            }
            //left is explored, visit the top of the stack
            cur = callStk.pop();
            TreeNode temp = cur;
            cur = cur.right;
            return temp;

        }else {
            return null;
        }
    }
/*
//vanilla inOrder Iteration logic
private void inOrderIterate(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode cur = root;
        Stack<TreeNode> callStk = new Stack<>();

        while (cur!=null || !callStk.isEmpty()){

            //explore left and push to the stack
            while (cur!=null){
                callStk.push(cur);
                cur = cur.left;
            }
            //left is explored, visit the top of the stack
            cur = callStk.pop();
            System.out.println(cur.val);

            cur = cur.right;

        }

    }*/
}
