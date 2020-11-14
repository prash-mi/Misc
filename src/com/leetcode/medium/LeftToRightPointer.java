package com.leetcode.medium;

//connect left to right pointers in a perfectly balanced binary tree in O(1) space
public class LeftToRightPointer {
    public Node connect(Node root) {
        //connect the child level and then move there
        if (root == null){
            return null;
        }
        Node cur = root;
        while (cur!=null){//this loop goes level by level
            Node nextCur = cur.left;
            Node right = null;
            Node curLvl = cur;
            while (curLvl!=null){//this connects all the children's right pointers
                if (right!=null){
                    right.next=curLvl.left;
                    right=null;
                }
                if (curLvl.left!= null){
                    curLvl.left.next = curLvl.right;
                }
                right = curLvl.right;
                curLvl = curLvl.next;
            }
            cur=nextCur;
        }
        return root;
    }
}