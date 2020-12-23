package com.leetcode.medium;

public class BottomLeftTreeValue {

    class DepthAndHorizontalPos{
        int depth = 0, horizontalPos = 0;
        TreeNode node;
        DepthAndHorizontalPos(int depth, int horizontalPos, TreeNode nodeVal){
            this.depth = depth;
            this.horizontalPos = horizontalPos;
            this.node= nodeVal;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        DepthAndHorizontalPos lastNode = dfs(root, 0, 0);
        return lastNode.node.val;
    }

    private DepthAndHorizontalPos dfs(TreeNode cur, int depth, int horizontalPos) {
        if (cur == null){
            return new DepthAndHorizontalPos(depth, horizontalPos, null);
        }

        DepthAndHorizontalPos left = dfs(cur.left, depth+1, horizontalPos-1);
        DepthAndHorizontalPos right = dfs(cur.right, depth+1, horizontalPos+1);

        if (left.node == null && right.node == null){//this is a leaf node, return the current DepthAndHorizontalPos
            return new DepthAndHorizontalPos(depth, horizontalPos, cur);
        }else if (left.node == null || right.node == null){//one of the nodes are null, return the one which is non null
            return left.node == null?right:left;
        }else {//both are non null, return the deepest
            if (left.depth == right.depth){//if we get two nodes at the same depth, then return the one with the smallest horizontalPos
                return left.horizontalPos<right.horizontalPos?left:right;//ITS IMPORTANT TO COMPARE THE horizontalPos, AS THE TWO NODES MAY NOT BE THE IMMEDIATE CHILDREN OF THE CURRENT NODE
            }else {//else return the one which is deepest
                return left.depth > right.depth? left:right;
            }
        }

    }
}
