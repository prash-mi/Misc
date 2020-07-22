package com.leetcode.july;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag = new LinkedList<>();

        boolean leftToRight = true;
        Deque<TreeNode> curLev = new LinkedList<>();
        Deque<TreeNode> nextLev = new LinkedList<>();
        curLev.add(root);

        while (!curLev.isEmpty()){

            TreeNode cur = curLev.poll();
            //add children
            if (leftToRight){

            }else {

            }

        }


        return zigZag;
    }

}
