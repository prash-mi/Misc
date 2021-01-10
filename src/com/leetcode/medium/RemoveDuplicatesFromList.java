package com.leetcode.medium;

//Remove Duplicates from Sorted List II - Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list. Return the linked list sorted as well.
public class RemoveDuplicatesFromList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pseudoHead = new ListNode(-1);
        pseudoHead.next = head;
        ListNode prev = pseudoHead, cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {//delete this sublist
                while (cur.next!= null && cur.val == cur.next.val) {//move the cursor to the last repeating value
                    cur = cur.next;
                }
                prev.next = cur.next;//deleted the current duplicate sublist, the list at cur.next might be duplicate as well, so do not advance prev
            } else {//next value is not duplicate, increment prev
                prev = cur;
            }
            cur = cur.next;
        }
        return pseudoHead.next;
    }
}