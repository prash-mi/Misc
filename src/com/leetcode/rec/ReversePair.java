package com.leetcode.rec;



public class ReversePair {
    public static void main(String[] args){

        //PsuedoPrev -> 1 -> 2 -> 3 -> 4
        //

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode head = new ReversePair().swapPairs(l1);

        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }

    }


    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pseudoPrev = new ListNode(0);
        pseudoPrev.next=head;
        return swapPairsHelper(pseudoPrev, head);
    }

    public ListNode swapPairsHelper(ListNode prev, ListNode cur) {

        if (cur==null){
            return null;
        }
        ListNode nex = cur.next;
        if(nex == null){
            return cur;
        }
        prev.next = nex;
        ListNode nextCur = null;
        if(nex!= null) {
            nextCur = nex.next;
            nex.next = cur;
        }
        cur.next = swapPairsHelper(cur, nextCur);
        return prev.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

