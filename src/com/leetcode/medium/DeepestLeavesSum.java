package com.leetcode.medium;

public class DeepestLeavesSum {
    class DepthAndSum{
        int depth=0, sum=0;
        public DepthAndSum(int depth, int sum){
            this.depth = depth;
            this.sum = sum;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        DepthAndSum deepestSum = getDeepestSum(root, 0);
        return deepestSum.sum;
    }

    private DepthAndSum getDeepestSum(TreeNode cur, int depth) {
        if (cur==null){
            return new DepthAndSum(depth, 0);
        }
        if (cur.left == null&& cur.right == null){
            return new DepthAndSum(depth, cur.val);//leaf node
        }

        DepthAndSum left = getDeepestSum(cur.left, depth+1);
        DepthAndSum right = getDeepestSum(cur.right, depth+1);

        if (left.depth == right.depth){//depths are equal at the current level, add those
            return new DepthAndSum(left.depth, (left.sum+right.sum));
        }else{//unequal depths, return the deepest
            return left.depth>right.depth?left:right;
        }
    }
}
