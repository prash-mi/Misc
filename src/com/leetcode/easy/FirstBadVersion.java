package com.leetcode.easy;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(100));
    }

    public int firstBadVersion(int n) {
        int left=1, right = n, mid;
        while (left < right){
            mid = left + (right-left)/2;
            if(!isBadVersion(mid)){//go right
                left = mid+1;
            }else {
                right = mid;//not mid-1 as the terminating condition is left<right. This way the left pointer will be at the last valid version
            }
        }
        return left;
    }

    //this is slower than the above, despite having O(log n) time complexity
    public int firstBadVersion2(int n) {
        int left = 1, right = n, mid;
        while (left<=right){
            mid = left + (right-left)/2;
            if (!isBadVersion(mid-1)&& isBadVersion(mid)){//go left
                return mid;//first bad version
            }else if (mid +1 <= n && isBadVersion(mid+1) && !isBadVersion(mid)){
                return mid+1;//first bad version
            }else if (isBadVersion(mid)){//go left
                right = mid-1;
            }
            else {//go right
                left = mid+1;
            }
        }
        return -1;
    }

    public boolean isBadVersion(int num){//hardcoding for testing
        return num >70;
    }
}
