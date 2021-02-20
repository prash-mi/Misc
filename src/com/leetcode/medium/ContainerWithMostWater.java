package com.leetcode.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null||height.length<=1){
            return 0;
        }
        int maxArea = 0;
        int left = 0, right = height.length-1;
        while (left<right){
            int curArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, curArea);
            //advance the pointer at the smaller height. as the area is limited by the smaller height
            if (height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
    return maxArea;
    }
}
