package com.leetcode.medium;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode pseudoHeadOdd = new ListNode(-1), pseudoHeadEven = new ListNode(-1);
        ListNode oddCur = pseudoHeadOdd, evenCur = pseudoHeadEven;
        ListNode cur = head;
        boolean odd = true; //first node at 0th index is odd (it's by possition and note index)
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = null;//detach this node
            if (odd){
                oddCur.next=cur;
                oddCur = oddCur.next;
            }else {
                evenCur.next=cur;
                evenCur = evenCur.next;
            }
            cur=temp;
            odd=!odd;
        }

        oddCur.next=pseudoHeadEven.next;//join the odd and even lists
        return  pseudoHeadOdd.next;//return the list
    }
}
