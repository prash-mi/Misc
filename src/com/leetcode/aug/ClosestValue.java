package com.leetcode.aug;

public class ClosestValue {

    public int closestValue(TreeNode root, double target) {
    TreeNode cur = root;
    int closest = Integer.MAX_VALUE;
    double distance = Double.MAX_VALUE;
    while (cur!= null){
        if(Math.abs((double)cur.val - target) < distance){
            distance = Math.abs((double)cur.val - target);
            closest = cur.val;
        }
        if ((double)cur.val == target){
            break;
        }else if((double)cur.val > target) {//go left
            cur = cur.left;
        }else {
            cur = cur.right;
        }
    }
 return closest;
    }


}
