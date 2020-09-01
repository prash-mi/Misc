package com.leetcode.medium;

import java.util.*;
/*
Input :
       1
      / \
     2   3
    /   / \
   4   2   4
      /
     4

Output :
   2
  /    and    4
 4
Explanation: Above Trees are two duplicate subtrees.
Therefore, you need to return above trees root in the
form of a list.
 */

//O(N^2) time and space
public class DuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> occurences = new HashMap<>();
        findDuplicates(root, res, occurences);
        return res;
    }

    private String findDuplicates(TreeNode cur, List<TreeNode> res, Map<String, Integer> occurences){
        if (cur == null){
            return "#";
        }
        String leftHash = findDuplicates(cur.left, res, occurences);
        String rightHash = findDuplicates(cur.right, res, occurences);
        String curHash = cur.val+"-"+leftHash+"-"+rightHash;

        occurences.put(curHash, occurences.getOrDefault(curHash, 0)+1);

        if (occurences.get(curHash) == 2){// this implies that tree @ cur is duplicate and ignores storing duplicates when cur is duplicated more than twice
            res.add(cur);
        }
    return curHash;
    }

}
