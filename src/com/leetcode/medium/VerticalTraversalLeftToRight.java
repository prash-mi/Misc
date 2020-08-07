package com.leetcode.medium;

import java.util.*;

public class VerticalTraversalLeftToRight {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        //do a BFS
        List<List<Integer>> res = new ArrayList<>();
        Queue<NodeAndX> bf = new LinkedList<>();
        bf.add(new NodeAndX(root, 0));
        Map<Integer, List<Integer>> verMap = new HashMap<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        while (!bf.isEmpty()){
            NodeAndX curNodeAndX = bf.poll();

            minX = Math.min(minX, curNodeAndX.x);
            maxX = Math.max(maxX, curNodeAndX.x);
            //populate the map
            if (verMap.containsKey(curNodeAndX.x)){
                verMap.get(curNodeAndX.x).add(curNodeAndX.node.val);
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(curNodeAndX.node.val);
                verMap.put(curNodeAndX.x, temp);
            }

            //add the children in queue
            if (curNodeAndX.node.left!=null){
                bf.add(new NodeAndX(curNodeAndX.node.left, curNodeAndX.x-1));
            }
            if (curNodeAndX.node.right!=null){
                bf.add(new NodeAndX(curNodeAndX.node.right, curNodeAndX.x+1));
            }

        }
        for(int i = minX; i <= maxX; i++){
            if(verMap.containsKey(i)) {
                res.add(verMap.get(i));
            }
        }
    return res;
    }
}

class NodeAndX{
    TreeNode node;
    int x;
    NodeAndX(TreeNode node, int x){
        this.node = node;
        this.x = x;
    }
}