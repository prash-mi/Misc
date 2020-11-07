package com.leetcode.easy;
/*
We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.
 */
public class MinCost {
    public int minCostToMoveChips(int[] positions) {
        if (positions==null||positions.length==0){
            return 0;
        }
        int evenChipCnt = 0, oddChipCnt=0;
        for (int pos: positions){//if a chip is at even place then it can be moved to place 0 at 0 cost, if it is at a odd location then it can move to place 1 at zero cost
                                    // then the place 0 or 1, which ever has the min number of chips will be moved over the other, costing 1 per chip
            if (pos%2 == 0){
                evenChipCnt++;
            }else{
                oddChipCnt++;
            }
        }
        return Math.min(evenChipCnt, oddChipCnt);
    }
}
