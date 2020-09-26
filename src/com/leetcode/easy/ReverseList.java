package com.leetcode.easy;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//recursive reverse list
public class ReverseList {

    // * Definition for singly-linked list.

    public static void main(String[] args){
           ListNode l1 = new ListNode(1);
           ListNode l2 = new ListNode(2);
           ListNode l3 = new ListNode(3);
           l1.next=l2;
           l2.next=l3;
        ListNode rev = new ReverseList().reverseList(l1);
        System.out.println(rev.val);
    }
class NodeWrapper{
        ListNode tail;
}
    public ListNode reverseList(ListNode head) {
           if (head == null){
               return null;
           }
            NodeWrapper nw = new NodeWrapper();
            ListNode front = revListHelper(head, nw);
            front.next=null;
            return nw.tail;
    }

    private ListNode revListHelper(ListNode cur, NodeWrapper nw) {
           if (cur.next==null){
               nw.tail=cur;
               return cur;
        }
        revListHelper(cur.next, nw).next=cur;
        return cur;
    }
}
