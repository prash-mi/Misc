package com.leetcode.easy;
/*
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"

Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

Output: "1(2()(4))(3)"

 */

public class StringFromBtree {
    public String tree2str(TreeNode t) {
        StringBuffer buf = new StringBuffer();
        dfsTree(t,buf);
        return buf.toString();
    }

    private void dfsTree(TreeNode cur, StringBuffer buf){
        if (cur == null){
            return;
        }

        buf.append(cur.val);
        if (cur.left!= null || cur.right!= null){
            buf.append("(");
            dfsTree(cur.left, buf);
            buf.append(")");
        }

        if (cur.right!= null){
            buf.append("(");
            dfsTree(cur.right, buf);
            buf.append(")");
        }
    }
}
