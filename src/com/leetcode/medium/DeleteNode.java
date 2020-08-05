package com.leetcode.medium;

import javax.swing.tree.TreeCellRenderer;

public class DeleteNode {
    /*
    root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7
     */
    public static void main(String[] args){

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

        TreeNode nod = new DeleteNode().deleteNode(t5, 5);
        System.out.println(nod);
    }

    public TreeNode deleteNode(TreeNode cur, int val) {
        if (cur == null){
            return null;
        }//we reached a dead end, nothing to delete
        if (cur.val == val){//delete it
            if (cur.left == null && cur.right == null){//both children are null, attach parent to null
                return null;
            }

            //if right children is not null then replace cur with inorder successor, then delete the successor recursively[same logic applies when both the children aren't null]
            if(cur.right!= null){
                TreeNode suc = findInorderSuccessor(cur.right);
                cur.val = suc.val;
                cur.right = deleteNode(cur.right, suc.val);
                return cur;
            }else{
                TreeNode pre = findInorderPredecessor(cur.left);
                cur.val = pre.val;
                cur.left = deleteNode(cur.left, pre.val);
                return cur;
            }

        }
        if (cur.val<val){//go right
            cur.right = deleteNode(cur.right, val);
        }else {
            cur.left = deleteNode(cur.left, val);
        }
        return cur;
    }

    private TreeNode findInorderSuccessor(TreeNode cur){
        if (cur.left == null){
            return cur;
        }
        return findInorderSuccessor(cur.left);
    }

    private TreeNode findInorderPredecessor(TreeNode cur){
        if (cur.right == null){
            return cur;
        }
        return findInorderPredecessor(cur.right);
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