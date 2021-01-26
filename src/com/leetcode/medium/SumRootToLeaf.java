package com.leetcode.medium;
/*
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
12+13 = 25
 */
public class SumRootToLeaf {
    class Sum{int num=0;}
    public int sumNumbers(TreeNode root) {
        Sum s = new Sum();
        getSum(root, 0, s);
        return s.num;
    }
    //Time O(n), space O(h)
    void getSum(TreeNode cur, int curNum, Sum s){//using preorder traversal
        if (cur==null){
            return;
        }
        curNum = (curNum*10) + cur.val;
        if (cur.left==null&&cur.right==null){
            s.num += curNum;
        }
        getSum(cur.left, curNum, s);
        getSum(cur.right, curNum, s);
    }
}