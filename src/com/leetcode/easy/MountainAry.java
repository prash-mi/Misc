package com.leetcode.easy;

public class MountainAry {
    public static void main(String[] args){
        int[] ary = {0,1,2,3,4,5,6,7,8,9};
        int[] ary2 = {0,3,2,1};
        System.out.println(new MountainAry().validMountainArray(ary));
        System.out.println(new MountainAry().validMountainArray(ary2));
    }
    public boolean validMountainArray(int[] arr) {
        if(arr == null || arr.length < 3){
            return false;
        }
        int left = 1, right =arr.length-2;
        while (left<=arr.length-1){
            if (arr[left-1] == arr[left]){
                return false;
            }
            if (arr[left-1] > arr[left]){//arry started decreasing, left-1 is the peak
                break;
            }
            left++;
        }
        while (right>=0){
            if (arr[right+1] == arr[right]){
                return false;
            }
            if (arr[right] < arr[right+1]){//right +1 is the peak
                break;
            }
            right--;
        }

        return right+1 == left-1 && right+1 > 0 && right+1 < arr.length-1;//increasing and decreasing arrays meet at the same point, and the point is not the left or the right extreme indexes
    }
}
