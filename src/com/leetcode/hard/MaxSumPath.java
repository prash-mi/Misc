package com.leetcode.hard;
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

public class MaxSumPath {
      class Max{int val=Integer.MIN_VALUE;}

      public int maxPathSum(TreeNode root) {
        Max m = new Max();
        getMaxDFS(root, m);
        return m.val;
        }
//Time O(n), space O(h)
    int getMaxDFS(TreeNode cur, Max m){
          if (cur == null){
              return 0;
          }
          int leftSum = getMaxDFS(cur.left, m);
          int rightSum = getMaxDFS(cur.right, m);

          int sumRootedCurNode = leftSum+rightSum+cur.val;//that is the subtree having the max sum is rooted at the current node
          int sumThroughCurNode = Math.max(leftSum, rightSum) + cur.val;//sum passes through the current node, but isn't rooted there

          m.val = Math.max(m.val, Math.max(sumRootedCurNode, Math.max(cur.val, sumThroughCurNode)));//Max path sum would be the global max value of (cur.val, sumThroughCurNode, sumRootedCurNode)
                                        //that is the max sum path could be a single node, a subtree, or just a branch!

          return Math.max(sumThroughCurNode, cur.val);//either the path passes through the current node, or starts at it
    }
}
