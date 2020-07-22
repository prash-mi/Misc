package com.leetcode.july;

public class DeleteNode {
    public static void main(String[] args){
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(1);
    l1.next = l2;
    ListNode head = new DeleteNode().removeElements(l1, 1);
    System.out.println(head);
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode pseudohead = new ListNode(0, head);
        ListNode cur = head, prev = pseudohead;
        while (cur!= null){
            if(cur.val == val){//delete this;
                prev.next = cur.next;
            }else{//prev isn't getting updated when the node is getting deleted
                prev = cur;
            }
            cur = cur.next;
        }
        return pseudohead.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
