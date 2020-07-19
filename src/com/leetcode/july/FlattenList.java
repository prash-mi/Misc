package com.leetcode.july;

import java.util.Stack;

public class FlattenList {
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
        Node flat = new FlattenList().flatten(n1);
        print(flat);

    }

    static void print(Node cur){
        if (cur==null){
            return;
        }
        System.out.println(cur.val);
        if(cur.child != null){
            print(cur.child);
        }
        print(cur.next);
    }

    Node flatHead = new Node(0), flatCur = flatHead;
    public  Node flatten(Node head) {

        copy(head);
        if(flatHead.next!= null)
            flatHead.next.prev =null;
        return flatHead.next;
    }

    void copy(Node cur){
        if (cur==null){
            return ;
        }


        Node temp = flatCur;
        flatCur.next = new Node(cur.val);
        flatCur = flatCur.next;
        flatCur.prev = temp;

        //    System.out.println(cur.val);

        if(cur.child != null){
            copy(cur.child);
        }
        copy(cur.next);
    }
    /*
    public static Node flatten(Node head) {

        Node root = head, cur = head;

        Stack<Node> stk = new Stack<>();
        Node last = null;
        while (cur!= null && !stk.isEmpty()){
            if(cur == null && !stk.isEmpty()){
                cur = stk.pop();//get the previous level for traversal
                last.next = cur;
                cur.prev = last;
            }
            if(cur!=null && cur.child == null){
                last = cur;
                cur = cur.next;
            }else{//cur has a child
                Node temp = cur;
                cur.next = cur.child;//we will visit the child first
                stk.add(temp.next);//we will visit it later
                temp.child=null;//flatten it
                cur.child.prev = temp;
            }
        }
        return root;
    }
*/

}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    Node(int val){
        this.val = val;
    }
};
