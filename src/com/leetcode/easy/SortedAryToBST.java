package com.leetcode.easy;

public class SortedAryToBST {
    public static void main(String[] args) {
        int[] ip = {1,2,3,4,5,6,7,8,9};
        TreeNode cur = new SortedAryToBST().sortedArrayToBST(ip);
        System.out.println(cur.val);

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0){
            return null;
        }
        return sortedArrayToBSTHelper(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right){
        if (left>right){
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = sortedArrayToBSTHelper(nums, left, mid-1);
        cur.right = sortedArrayToBSTHelper(nums, mid+1, right);
        return cur;
    }
}
