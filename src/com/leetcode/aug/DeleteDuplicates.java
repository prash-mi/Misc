package com.leetcode.aug;
class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode prev = head, cur = head.next;
        while (cur!=null){
            if (cur.val == prev.val){
                prev.next=cur.next;//delete cur node
            }else{
                prev = cur;//for the next iteration
            }
            cur = cur.next;
        }
        return head;
    }
}
