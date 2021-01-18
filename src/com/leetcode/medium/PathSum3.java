package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    class CountAndRunningSum{
        int cnt = 0, runningSum = 0;
    }
    //O(1) time and space
    public int pathSum(TreeNode root, int sum) {
        CountAndRunningSum c = new CountAndRunningSum();
        Map<Integer, Integer> sumOccurrence = new HashMap<>();
      //  sumOccurrence.put(0, 1);//implies we have seen sum of 0 once
        pathSum(root, sum, sumOccurrence, c);
        return c.cnt;

    }

     void pathSum(TreeNode cur, int sum, Map<Integer, Integer> sumOccurrence, CountAndRunningSum c) {
        if (cur == null){
            return;
        }

        c.runningSum += cur.val;//add the current value to the running sum

         if (c.runningSum == sum){
             c.cnt++;
         }

        c.cnt += sumOccurrence.getOrDefault((c.runningSum-sum), 0);
        sumOccurrence.put(c.runningSum, sumOccurrence.getOrDefault(c.runningSum, 0) + 1);//if we have seen this runningSum before than add 1 to the occurence count,
         // this implies that the sum of numbers between the previous occurence of runningSum and this occurence of runningSum is 0.

        pathSum(cur.left, sum, sumOccurrence, c);
        pathSum(cur.right, sum, sumOccurrence, c);

        sumOccurrence.put(c.runningSum, sumOccurrence.get(c.runningSum)-1);//remove this occurence of  runningSum
        c.runningSum -= cur.val;//backtracking from the current level, substracting this value

    }
}
