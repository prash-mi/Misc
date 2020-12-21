package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> res = new Combinations().combine(4, 2);
        for(List<Integer> l: res){
            System.out.println(l);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n<k||n==0||k==0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        generateCombinations2(n, k, 1, new ArrayList<>(), res);
        return res;
    }
    /*
    Times and space: O(k * combination of k over n)
     */
    void generateCombinations(int n, int k, int cur, List<Integer> buff, List<List<Integer>> res){
        if (buff.size() == k){
            res.add(new ArrayList<>(buff));//deep copy
            return;
        }
        if (buff.size()>k || cur > n){//not exploring these combinations
            return;
        }

        //generate further combinations
        buff.add(cur);
        generateCombinations(n, k, cur+1, buff, res);
        buff.remove(buff.size()-1);//remove the last element
        generateCombinations(n, k, cur+1, buff, res);
    }
    void generateCombinations2(int n, int k, int cur, List<Integer> buff, List<List<Integer>> res) {//THIS PRINTS THE OUTPUT IN LEXICAL ORDER
        if (buff.size() == k) {
            res.add(new ArrayList<>(buff));//deep copy
            return;
        }

        for (int i = cur; i <= n; i++) {
            buff.add(i);
            generateCombinations2(n, k, i + 1, buff, res);
            buff.remove(buff.size() - 1);//remove the last element
        }
    }

}
