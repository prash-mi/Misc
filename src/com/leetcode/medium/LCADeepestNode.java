package com.leetcode.medium;

public class LCADeepestNode {
    class DepthAndNode{
        int depth;
        TreeNode node;
        DepthAndNode(TreeNode node, int depth){
            this.depth = depth;
            this.node = node;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        DepthAndNode lcaDeepest = getLCAofDeepestNode(root, 0);
        return lcaDeepest.node;
    }

    private DepthAndNode getLCAofDeepestNode(TreeNode cur, int depth) {
        if (cur == null){
            return new DepthAndNode(null, depth);
        }

        DepthAndNode left = getLCAofDeepestNode(cur.left, depth+1);
        DepthAndNode right = getLCAofDeepestNode(cur.right, depth+1);

        if (left.depth == right.depth){//if both the depths are equal, then the current node is the common node having both the nodes as children
            return new DepthAndNode(cur, left.depth);
        }else if (left.depth > right.depth){//left is the deepest node, and it's the lowest common ancestor (there is no question of having a "common" anscestor in this case
            return left;
        }else {
            return right;
        }

    }
}
