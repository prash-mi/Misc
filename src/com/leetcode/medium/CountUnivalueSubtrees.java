package com.leetcode.medium;

public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] len = {0};
        getUnivalSubTrees(root, len);
        return len[0];
    }

    private Integer getUnivalSubTrees(TreeNode cur, int[] len) {
        if (cur==null){
            return null;
        }
        if (cur.left == null && cur.right == null){//a leaf node is always a univalue subtree
            len[0]++;
            return cur.val;//we will match this value while recursing up
        }

        Integer left = getUnivalSubTrees(cur.left, len);
        Integer right = getUnivalSubTrees(cur.right, len);

        if (left!=null && right!=null && cur.val == left && cur.val==right){//that is the subtree rooted at cur node is univalue
            len[0]++;
            return left;
        }
        if (left == null && right==cur.val){//right subtree is univalued
            len[0]++;
            return right;
        }
        if (right==null && left==cur.val){//left subtree is univalued
            len[0]++;
            return left;
        }
        return Integer.MIN_VALUE;//the subtree isn't univalued, returning MIN_VALUE so that the parent doesnt consider the child univalued
    }
}
