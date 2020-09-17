package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfNAryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    class MaxDiameter{
        int max=0; 
    }

    public int diameter(Node root) {
        MaxDiameter maxDiaWrapper = new MaxDiameter();
        diameterHelper(root, maxDiaWrapper);
        return maxDiaWrapper.max; 
    }

    private int diameterHelper(Node cur, MaxDiameter maxDiaWrapper) {
        if (cur==null){
            return 0;
        }
        int maxHeight=0, secondMaxHeight=0;
        //We will iterate throught all the children and find the maxHeight and the secondMaxHeight. Diameter would be maxHeight+ secondMaxHeight
        for (Node child: cur.children){
            int curHeight = diameterHelper(child, maxDiaWrapper);
            if (curHeight>maxHeight){
                secondMaxHeight = maxHeight;
                maxHeight = curHeight;
            }else if (curHeight >secondMaxHeight){
                secondMaxHeight=curHeight;
            }
        }
        maxDiaWrapper.max = Math.max(maxDiaWrapper.max, (maxHeight+ secondMaxHeight));
        return maxHeight+1;
    }
}
