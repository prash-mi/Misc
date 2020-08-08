package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateRightPointer {

    /*O(n) time and O(1) space*/
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Node leftMost = root;
        Node nextLeftMost = null;

        while (leftMost!= null){
            Node cur = leftMost;
            while (cur!= null){
                if(cur.left!= null){
                    cur.left.next = getNext(cur, true);//skipFirstLeft because we do not want to point the next pointer to the same element
                }
                if(cur.right!= null){
                    cur.right.next = getNext(cur.next, false);
                }

                if (nextLeftMost == null){
                    nextLeftMost = cur.left!= null?cur.left: (cur.right!= null? cur.right:null);
                }

                cur = cur.next;
            }
            //update the leftmost now
            leftMost = nextLeftMost;
            nextLeftMost = null;
        }
      return root;
    }

    //find the first non null element at a given level using the list at the parent level
    private Node getNext(Node ptr, boolean skipFirstLeft){

        while (ptr!=null){
            if (!skipFirstLeft){
                if (ptr.left!= null){
                    return ptr.left;
                }
            }
            skipFirstLeft = false;

            if (ptr.right!= null){
                return ptr.right;
            }
            ptr = ptr.next;
        }
        return null;
    }


    /* O(n) time and space solution*/
    public Node connect2(Node root) {
        if (root == null){
            return null;
        }
        Queue<NWrap> bf= new LinkedList<>();
        bf.add(new NWrap(root, 0));
        while (!bf.isEmpty()){
            NWrap cur = bf.poll();

            NWrap head = bf.peek();
            if (head!= null && head.y==cur.y){//put a next pointer
                cur.node.next = head.node;
            }
            if (cur.node.left!= null){
                bf.add(new NWrap(cur.node.left, cur.y+1));
            }
            if (cur.node.right!= null){
                bf.add(new NWrap(cur.node.right, cur.y+1));
            }
        }
        return root;
    }

}

class NWrap{
    Node node;
    int y;
    NWrap(Node node, int y){
        this.node = node;
        this.y = y;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
