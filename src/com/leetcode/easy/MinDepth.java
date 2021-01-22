package com.leetcode.easy;

public class MinDepth {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.right = n3;
        System.out.println(new MinDepth().minDepth(n1));
    }
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return minDepthDFS(root);
    }


    public int minDepthDFS(TreeNode cur) {
        if (cur == null){
            return Integer.MAX_VALUE;
        }
        int l = minDepthDFS(cur.left);
        int r = minDepthDFS(cur.right);

        if(l == Integer.MAX_VALUE && r== Integer.MAX_VALUE){
            return 1;//this is a leaf node, hence depth is 1
        }
        //now just one of the values could be Integer.MAX_VALUE, so we can take min and add 1
        return Math.min(l, r)+1;
    }

}
