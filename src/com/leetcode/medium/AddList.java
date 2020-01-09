package com.leetcode.medium;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output:8 -> 0 -> 7
Explanation: 243 + 564 = 807.
 */


import java.util.LinkedList;
import java.util.Stack;

//Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


public class AddList {
//(2 -> 4 -> 3) + (9 -> 6 -> 4)
       public static void main(String[] args){

           ListNode n1 = new ListNode(2);
           n1.next = new ListNode(4);
           n1.next.next = new ListNode(3);

           ListNode n2 = new ListNode(9);
           n2.next = new ListNode(6);
           n2.next.next = new ListNode(4);

           ListNode sum = addTwoNumbers(n1, n2);
           ListNode cur = sum;
           while (cur!= null){
               System.out.print(cur.val+" ");
               cur = cur.next;

           }
       }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 !=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 !=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode sum = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int num1 = 0, num2 = 0;
            if (!s1.isEmpty()){
                num1 = s1.pop();
            }
            if (!s2.isEmpty()){
                num2 = s2.pop();
            }

            int tempSum = num1+num2+carry;
            carry = tempSum/10;

            if(sum == null){
                sum = new ListNode(tempSum%10);
            }else {
                ListNode tempList = new ListNode(tempSum%10);
                tempList.next = sum;
                sum = tempList;
            }


        }

        return sum;

    }

}
