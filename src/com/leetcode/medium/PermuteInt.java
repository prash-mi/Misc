package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PermuteInt {
    public static void main(String[] args){
int[] ip = {1,2,3};
        new PermuteInt().permute(ip);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, 0, res);
        return res;
    }

    private void permuteHelper(int [] ip, int fix, List<List<Integer>> res){
        if (fix> ip.length-1){
          List<Integer> cur =  new ArrayList<>();
            for (int i:ip){
                cur.add(i);
            }
           res.add((cur));//deep copying
            return;
        }

        for (int i = fix; i < ip.length; i++){
            //swap fix and i
            swap(ip, fix, i);
            permuteHelper(ip, fix+1, res);
            swap(ip, fix, i);//undo the swap
        }
    }

    private void swap(int[] ip, int x, int y){
        int temp = ip[x];
        ip[x] = ip[y];
        ip[y] = temp;
    }
}
