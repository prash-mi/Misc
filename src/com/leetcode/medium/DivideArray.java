package com.leetcode.medium;

import java.util.TreeMap;

public class DivideArray {
    //rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
    //Time O(N Log N) space O(N)
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand==null||hand.length==0){
            return false;
        }
        //create a treemap if number::count
        TreeMap<Integer, Integer> numToCnt = new TreeMap<>();//Use TreeMap as firstKey() will give the smallest int
        for (int n: hand){
            numToCnt.put(n, numToCnt.getOrDefault(n, 0)+1);
        }
        while (numToCnt.size()!=0){
            int start = numToCnt.firstKey();//smallest
            //now see if we can get w consecutive numbers starting start
            for (int i = start; i < start+W; i++){
                Integer cnt = numToCnt.getOrDefault(i, null);
                if (cnt==null){//number i isn't found, the consecutive sequence isn't possible
                    return false;
                }

                if (cnt==1){//remove this from the TreeMap
                    numToCnt.remove(i);
                }else {
                    numToCnt.replace(i, cnt-1);
                }
            }
        }
        return true;
    }
}
