package com.leetcode.medium;

public class InOrderSuccessorPrntPtr {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node cur) {
        Node suc = null;
        if (cur.right!= null){
            return minNode(cur.right);
        }
        //else find the first parent greater than nodeVal
        int nodeVal = cur.val;
        while (cur!=null){
            if (cur.val>nodeVal){//the first node having value greater than the given node's value
                return cur;
            }
            cur=cur.parent;
        }
        return null;
    }

    private Node minNode(Node cur){
        while (cur.left!=null){
            cur=cur.left;
        }
        return cur;
    }
}
