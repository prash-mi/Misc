package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRootOfNAryTree {
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

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //Time O(n) and space O(1)
    public Node findRoot(List<Node> tree) {
        if(tree == null || tree.size() ==0){
            return null;
        }
        //The idea is that all the nodes will be appearing twice in the list and just the root will appear ones.
        //this boils down o the problem where we can XOR all the numbers to find the unique number. Or in this case add the number when it appears as parent and subtract when it appears as a child.

        int nodeVal = 0;
        for (Node parent: tree){
            nodeVal += parent.val;//add the value as parent
            for (Node child: parent.children){
                nodeVal -= child.val;
            }
        }

        //now return the node with value nodeVal

        for (Node parent: tree){
            if (parent.val == nodeVal){
                return parent;
            }
        }

        return null;
    }

    //Time and space O(n)
    public Node findRoot2(List<Node> tree) {
        if(tree == null || tree.size() ==0){
            return null;
        }
        //else find a tree with 0 in Degree
        Map<Node, Integer> indegree = new HashMap<>();
        for (Node cur: tree){
            if (!indegree.containsKey(cur)){
                indegree.put(cur, 0);
            }
            for (Node curChild: cur.children){
                //add 1 to curChild's indegree
                indegree.put(curChild, indegree.getOrDefault(curChild, 0)+1);
            }
        }
        //now return the node with 0 indegree
        for (Node n: indegree.keySet()){
            if (indegree.get(n) == 0){
                return n;
            }
        }
    return null;
    }
}
