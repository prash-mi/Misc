package com.leetcode.medium;

import java.util.Arrays;

public class LISLength {
    public static void main(String[] args){
        System.out.println(new LISLength().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(new LISLength().lengthOfLIS(new int[] {0,1,0,3,2,3}));
        System.out.println(new LISLength().lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
        System.out.println(new LISLength().lengthOfLIS(new int[] {0,1,0,3,2,3,7,7,7,7,7,7,7,10,9,2,5,3,7,101,18}));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null||nums.length==0){
            return 0;
        }
        int[][] prevCurMemo = new int[nums.length][nums.length];
        for (int r = 0; r < prevCurMemo.length; r++){
            Arrays.fill(prevCurMemo[r], -1);
        }
        return getLisLen(nums, -1, 0, prevCurMemo);
    }

//O(n^2) time and space
    int getLisLen(int[] nums, int prevIdx, int curIdx, int[][] prevCurMemo){
        if (curIdx >= nums.length){
            return 0;
        }

        if (prevCurMemo[prevIdx+1][curIdx] != -1){
            return prevCurMemo[prevIdx+1][curIdx];
        }


        int selectCurrentIdx = 0;
        if (prevIdx == -1 || nums[prevIdx] < nums[curIdx]){//select the current index, we add 1 to the length and curIdx becomes prevIdx for the next iteration
            selectCurrentIdx = getLisLen(nums, curIdx, curIdx+1, prevCurMemo)+1;
        }
        int notSelectCurrentIdx = getLisLen(nums, prevIdx, curIdx+1, prevCurMemo);//we pass prevIdx as is

        prevCurMemo[prevIdx+1][curIdx] = Math.max(selectCurrentIdx, notSelectCurrentIdx);//max is LIS, its stored against the prevId and curIdx
        return prevCurMemo[prevIdx+1][curIdx];
    }

/*
 // O(2^n) bruitforce solution
 int getLisLen(int[] nums, List<Integer> buff, int idx){
        if (idx >= nums.length){
            return buff.size();
        }

        //select it current index
        int selectCurrentIdx = 1;//min length of a subsequence is 1


        if (buff.size() == 0 || buff.get(buff.size()-1) < nums[idx]){//buffer is empty, blindly add the current element OR if  buffer has some value(s) of LIS already, add the value iff it's greater than the last value
            List<Integer> tempBuf = new ArrayList<>(buff);
            tempBuf.add(nums[idx]);
            selectCurrentIdx = getLisLen(nums, tempBuf, idx+1);
        }

        int notSelectCurrentIdx = getLisLen(nums, buff, idx+1);//pass the buff as is

        return Math.max(selectCurrentIdx, notSelectCurrentIdx);
    }*/
}
