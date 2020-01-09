package com.leetcode.medium;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */

import java.util.Stack;


public class AddListReverse {
    //(2 -> 4 -> 3) + (5 -> 6 -> 9)
    public static void main(String[] args){

        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(9);

        ListNode sum = addTwoNumbers(n1, n2);
        ListNode cur = sum;
        while (cur!= null){
            System.out.print(cur.val+" ");
            cur = cur.next;

        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int carry = 0;
        ListNode sum = null;
        ListNode lCur = null;

        while (l1!= null || l2!= null|| carry != 0){
            int num1 = 0, num2 = 0;
            if (l1!= null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2!= null){
                num2 = l2.val;
                l2=l2.next;
            }

            int tempSum = num1+num2+carry;
            carry = tempSum/10;

            if(sum == null){
                sum = new ListNode(tempSum%10);
                lCur = sum;
            }else {
                lCur.next= new ListNode(tempSum%10);
                lCur = lCur.next;
            }


        }

        return sum;

    }

}