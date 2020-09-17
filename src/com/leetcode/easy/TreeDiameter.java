package com.leetcode.easy;


public class TreeDiameter {

    class DiameterHeight{
        int diameter, height;
        DiameterHeight(int diameter, int height){
            this.diameter=diameter;
            this.height=height;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {

    }

    private DiameterHeight diameterOfBinaryTreeHelper(TreeNode cur){


        if(cur==null){
            return new DiameterHeight(0,0);
        }

        DiameterHeight lHeightDia = diameterOfBinaryTreeHelper(cur.left);
        DiameterHeight rHeightDia = diameterOfBinaryTreeHelper(cur.right);

        int maxDiameter =


        return res;
    }
}
