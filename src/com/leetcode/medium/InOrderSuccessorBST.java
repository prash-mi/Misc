package com.leetcode.medium;

public class InOrderSuccessorBST {
//Given a binary search tree and a node in it, find the in-order successor of that node in the BST.


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null){
            return null;
        }
        if(p.right!=null){
            return findMinNode(p.right);
        }
        //else search from root and find the min value which is > p
        TreeNode suc = null, cur=root;
        while (cur!= null){
            if (cur.val> p.val) {//go left (this could be the succesor if another smaller value isn't found)
                suc = cur;
                cur = cur.left;
            }else if (cur.val == p.val){
                break;
            }else {
                cur = cur.right;
            }
        }
        return suc;
    }

    private TreeNode findMinNode(TreeNode cur){
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur;
    }

}
