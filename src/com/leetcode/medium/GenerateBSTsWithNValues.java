package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class GenerateBSTsWithNValues {

    public List<TreeNode> generateTrees(int n) {
        if (n<1){
            return new ArrayList<>();//empty list as no tree is possible
        }
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        if (start>end){//return nullTree
            List<TreeNode> nullTree = new ArrayList<>();
            nullTree.add(new TreeNode(-1));;//represents null tree
            return nullTree;
        }

        //do round robin and every node from start to end will become root node
        List<TreeNode> treesCurLevel = new ArrayList<>();
        for (int i = start; i <=end; i++){
            //make i as the root
            List<TreeNode> leftTrees = generateTreesHelper(start, i-1);
            List<TreeNode> rightTrees = generateTreesHelper(i+1, end);
            //now all the combinations of left and right subtrees with i as the root node will become a structurally unique tree @ the current level
            for (TreeNode l: leftTrees){
                for (TreeNode r: rightTrees){
                    TreeNode curRoot = new TreeNode(i);
                    curRoot.left = l.val==-1?null:l;
                    curRoot.right = r.val==-1?null:r;
                    treesCurLevel.add(curRoot);//no need to deep copy as it's a new instance everytime
                }
            }
        }
     return treesCurLevel;
    }
}