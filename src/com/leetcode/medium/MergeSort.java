package com.leetcode.medium;

public class MergeSort {

    public static void main(String[] args){
        int[] ip = {5,7,1,6,0,100,50,3,200,6};
        int[] sorted = new MergeSort().sortArray(ip);
        for (int i: sorted){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] nums) {
        if (nums==null || nums.length< 2){
            return nums;
        }
        sortArrayHelper(nums, 0, nums.length-1);
        return nums;
    }

    private void sortArrayHelper(int[] nums, int left, int right) {

        if (left>=right){
            return ;
        }

        int mid = left + (right-left)/2;
        sortArrayHelper(nums, left, mid);
        sortArrayHelper(nums, mid+1, right);

        mergeInplace(nums, left, mid, right);

    }

    private void mergeInplace(int[] nums, int left, int mid, int right) {
        // create a temp array
        int temp[] = new int[right - left + 1];

        // crawlers for both intervals and for temp
        int i = left, j = mid+1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k += 1; i += 1;
            }
            else {
                temp[k] = nums[j];
                k += 1; j += 1;
            }
        }

        // add elements left in the first interval
        while(i <= mid) {
            temp[k] = nums[i];
            k += 1; i += 1;
        }

        // add elements left in the second interval
        while(j <= right) {
            temp[k] = nums[j];
            k += 1; j += 1;
        }

        // copy temp to original interval
        for(i = left; i <= right; i += 1) {
            nums[i] = temp[i - left];
        }

    }

}
