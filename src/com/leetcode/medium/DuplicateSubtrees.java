package com.leetcode.medium;

import java.util.*;

public class DuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> pre = new ArrayList<>();
        Map<Integer, Integer> locations = new HashMap<>();
        Set<Integer> dup = new HashSet<>();
        List<TreeNode> res = new ArrayList<>();
        getPreorder(root, pre);

        for (int i = 0; i < pre.size(); i++){
            int curVal = pre.get(i).val;
            if (locations.containsKey(curVal) && !dup.contains(curVal)){
                dup.add(curVal);//we are going to add a node with this value in solution
                res.add(pre.get(i));
            }else {
                locations.put(curVal, i);
            }
        }
        return res;
    }

    private void getPreorder(TreeNode cur, List<TreeNode> pre){
        if (cur == null){
            return;
        }
        pre.add(cur);
        getPreorder(cur.left, pre);
        getPreorder(cur.right, pre);
    }

}
