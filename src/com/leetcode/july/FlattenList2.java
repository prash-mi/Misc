package com.leetcode.july;

public class FlattenList2 {
    public static void main(String[] args){

            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            Node n4 = new Node(4);
            Node n5 = new Node(5);
           Node n6 = new Node(6);
            Node n7 = new Node(7);
           Node n8 = new Node(8);
            Node n9 = new Node(9);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n2.child = n5;
           n5.next = n6;
           n6.next = n7;
            n6.child = n8;
            n8.child = n9;
        Node flat = flatten(n1);
        print(flat);

    }

    static void print(Node cur){
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }


    public  static Node flatten(Node head) {
        if(head == null)
            return head;
        Node tail  = flaternHelper(head);
        return head;
    }


    public static Node flaternHelper( Node cur){
    if(cur.next == null && cur.child == null){
        return cur;//it's the tail
    }

    if(cur.child != null){

        Node tempChild = cur.child;
        Node tail = flaternHelper( cur.child);
        tail.next = cur.next;

        Node tempNext = cur.next;
        cur.child = null;
        tail.next = tempNext;
        if(tempNext!= null){
            tempNext.prev = tail;
        }
        cur.next = tempChild;
        tempChild.prev = cur;


    }
    return flaternHelper( cur.next);
    }
}


