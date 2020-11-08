package com.leetcode.medium;
//O(l1+l2) time and O(1) space
public class AddTwoNum {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next = l3;
        l4.next=l5;
        ListNode sum = new AddTwoNum().addTwoNumbers(l1, l4);

        while (sum!=null){
            System.out.print(sum.val);
            sum=sum.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Rev = rev(l1);
        ListNode l2Rev = rev(l2);
        ListNode biglist, smallList;

        if (length(l1Rev)>length(l2Rev)){
            biglist=l1Rev;
            smallList=l2Rev;
        }else {
            biglist=l2Rev;
            smallList=l1Rev;
        }
        //now add the numbers in place @ bigList, in the worst case we will have to add one digit at last
        int carry=0;
        ListNode cur = biglist;
        ListNode prev=null;
        while (cur!= null){//adding in place in the big list
            int d1 = smallList==null?0:smallList.val;
            int d2 = cur.val;
            cur.val = (d1+d2+carry)%10;
            carry = (d1+d2+carry)/10;
            prev=cur;
            cur=cur.next;
            smallList=smallList==null?null:smallList.next;
        }

        if (carry!=0){
            prev.next = new ListNode(carry);
        }
        return rev(biglist);
    }
    private int length(ListNode l){
        int len=0;
        while (l!=null){
            l=l.next;
            len++;
        }
        return len;
    }
    private ListNode rev(ListNode l){
        ListNode cur = l, prev = null;
        while(cur!= null){
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}