package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    //Level order traversal (BFS) where we pick the right most node of each level
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> lvl = new LinkedList<>();
        lvl.add(root);
        lvl.add(null);

        TreeNode prev = null;
        while (!lvl.isEmpty()){
            TreeNode cur = lvl.poll();
            if (cur == null && prev!=null){
                res.add(prev.val);
            }
            if (cur == null && !lvl.isEmpty()){
                lvl.add(null);
                continue;
            }
            if (cur!=null && cur.left!=null){
                lvl.add(cur.left);
            }
            if (cur!=null && cur.right!=null){
                lvl.add(cur.right);
            }
            prev=cur;
        }
        return res;
    }

}
