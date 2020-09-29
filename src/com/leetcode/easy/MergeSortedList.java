package com.leetcode.easy;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pseudoHead = new ListNode();
        mergeTwoListsHelper(pseudoHead, l1, l2);
        return pseudoHead.next;
    }

    private void mergeTwoListsHelper(ListNode pseudoHead, ListNode l1, ListNode l2) {
        if (l1!= null && l2!= null){
            if (l1.val< l2.val){
                pseudoHead.next = l1;
                l1 = l1.next;
            }else {
                pseudoHead.next = l2;
                l2 = l2.next;
            }
            pseudoHead = pseudoHead.next;
            mergeTwoListsHelper(pseudoHead, l1, l2);
        }else if (l1 == null){
            pseudoHead.next = l2;
        }else {
            pseudoHead.next = l1;
        }
    }
}
