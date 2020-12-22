package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Integer> left = new ArrayList<>();
        getLeftTraversal(root, root, left);
        List<Integer> leaves = new ArrayList<>();
        getLeaves(root, leaves);
        List<Integer> right = new ArrayList<>();
        getRightTraversal(root, root, right);

        Collections.reverse(right);//the order will be reverse in anti clockwise traversal
        if (right.size()>0){//it could be empty in a corner case where the tree has just one node
            right.remove(right.size()-1);//the last node after reversing was the root node, which is already the first element in left
        }
        left.addAll(leaves);
        left.addAll(right);//this is added after reversing

        return left;
    }

    private void getLeftTraversal(TreeNode cur,TreeNode root, List<Integer> left) {//preorder of left, excluding the left most leaf
        if (cur == null){
            return;
        }
        if (! (cur.left==null&&cur.right==null)){//not a leaf node
            left.add(cur.val);
        }
        getLeftTraversal(cur.left, root, left);
        if (cur.left == null && cur!=root){//Go right iff there is no left node, we must not visit the tree towards the right of the root
            getLeftTraversal(cur.right, root, left);
        }
    }

    private void getLeaves(TreeNode cur, List<Integer> leaves) {//pre order for leaves
        if (cur==null){
            return;
        }
        if (cur.left == null && cur.right == null){
            leaves.add(cur.val);
        }
        getLeaves(cur.left, leaves);
        getLeaves(cur.right, leaves);

    }
    private void getRightTraversal(TreeNode cur, TreeNode root, List<Integer> right) {//pre order for right, excluding the rightmost leaf
        if (cur==null){
            return;
        }
        if (! (cur.left==null&&cur.right==null)) {//not a leaf node
            right.add(cur.val);
        }
        getRightTraversal(cur.right, root, right);
        if (cur.right == null && cur!= root){//Go left iff there is no right node, we must not visit the tree towards the left of the root
            getRightTraversal(cur.left, root, right);
        }
    }
}
