package com.leetcode.medium;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] robNotRob = robHelper(root);
        return Math.max(robNotRob[0], robNotRob[1]);
    }

    //the return type represents {valueIfWeRobTheCurrentNode, valueIfWeDONOTRobTheCurrentNode}
    private int[] robHelper(TreeNode cur) {
        if (cur==null){
            return new int[]{0,0};
        }
        int[] leftRobNotRob = robHelper(cur.left);
        int[] rightRobNotRob = robHelper(cur.right);

        int robCurrentNode = leftRobNotRob[1] + rightRobNotRob[1] + cur.val; // do not rob left and right children, but rob current
        int notRobCurrentNode = Math.max(leftRobNotRob[0], leftRobNotRob[1]) + Math.max(rightRobNotRob[0], rightRobNotRob[1]); //we are free to rob child nodes, check robing or not robbing yield max value
        return new int[] {robCurrentNode, notRobCurrentNode};
    }
}