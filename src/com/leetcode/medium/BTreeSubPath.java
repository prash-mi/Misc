package com.leetcode.medium;
/*
Given a binary tree root and a linked list with head as the first node.
Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 */
public class BTreeSubPath {
    //A linear time solution seems impossible for this problem, so we are matching the list starting every node in the tree, resulting in a worst case O(n/2 * Log(n) * m) Time complexity solution
    public boolean isSubPath(ListNode head, TreeNode cur) {
        if (head==null||cur==null){
            return false;
        }

        //check if there is a path from cur which matches with the list
        if (checkSubPath(head, cur)){
            return true;//found a matching path
        }

        boolean left = isSubPath(head, cur.left);
        boolean right = isSubPath(head, cur.right);
        return left || right;
    }

    boolean checkSubPath(ListNode listCur, TreeNode treeCur){
        if (listCur == null || treeCur == null){
            return false;
        }
        if (listCur.next == null && listCur.val == treeCur.val){//matched till the last node of the list
            return true;
        }

        boolean left = false, right = false;
        if (listCur.val == treeCur.val) {//advance the list pointer
            left = checkSubPath(listCur.next, treeCur.left);
            right = checkSubPath(listCur.next, treeCur.right);
        }
        return left || right;
    }
}