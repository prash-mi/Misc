package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RightNode {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root==null||u==null){
            return null;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);

        while (!qu.isEmpty()){
            TreeNode cur = qu.poll();
            if (cur==null && !qu.isEmpty()){
                qu.add(null);//end of the level
                continue;
            }
            if (cur.val==u.val){
                return qu.isEmpty()?null:qu.poll();
            }
            if (cur.left!=null){
                qu.add(cur.left);
            }
            if (cur.right!=null){
                qu.add(cur.right);
            }
        }
        return null;
    }
}
