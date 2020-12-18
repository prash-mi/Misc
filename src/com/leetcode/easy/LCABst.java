package com.leetcode.easy;

// Lowest Common Ancestor of a Binary Search Tree
public class LCABst {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur!= null){
            if (p.val > cur.val && q.val>cur.val){
                cur = cur.right;
            }else if (p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            }else{//p and q happens to be on different sides, or cur is either p or q. In both the cases cur happens to be the LCA. Also ITS GIVEN THAT p and q will exist in the BST.
                return cur;
            }
        }
        return null;
    }
}
