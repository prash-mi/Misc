package com.leetcode.medium;

import java.security.PublicKey;

public class EqualTreePartition {
    public static void main(String[] args){
        TreeNode n5 = new TreeNode(5);
        TreeNode n10_1 = new TreeNode(10);
        TreeNode n10_2 = new TreeNode(10);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n5.left=n10_1;
        n5.right=n10_2;
        n10_2.left=n2;
        n10_2.right=n3;
    //[1,null,2,2] edge case, odd sum!
        System.out.println(new EqualTreePartition().checkEqualTree(n5));

    }
class SplitAndSum{
    boolean canSplit = false;
    int subTreeSum = 0;
    public SplitAndSum(int subTreeSum){
        this.subTreeSum = subTreeSum;
    }
    public SplitAndSum(boolean canSplit){
        this.canSplit = canSplit;
    }
}
    public boolean checkEqualTree(TreeNode root) {
        int totalSum = getTotalSum(root);
        if (Math.abs(totalSum%2) == 1){
            return false;
        }
        return canSplit(root, totalSum).canSplit;
    }

    private SplitAndSum canSplit(TreeNode cur, int totalSum) {
        if (cur == null){
            return new SplitAndSum(0);
        }

        SplitAndSum left = canSplit(cur.left, totalSum);
        SplitAndSum right = canSplit(cur.right, totalSum);

        if (left.canSplit||right.canSplit){//already found a split
            return left.canSplit?left:right;
        }
        //see if we can split one of the edges to the current children
        if ((cur.left!=null && totalSum/2 == left.subTreeSum)||
                (cur.right!=null && totalSum/2 == right.subTreeSum)){//possible split
            return new SplitAndSum(true);
        }
        return new SplitAndSum(left.subTreeSum+right.subTreeSum+cur.val);//return updated subtree sum to the parent
    }

    private int getTotalSum(TreeNode cur) {
        if (cur == null){
            return 0;
        }
        return getTotalSum(cur.left)+getTotalSum(cur.right)+cur.val;
    }
}