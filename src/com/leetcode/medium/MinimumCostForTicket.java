package com.leetcode.medium;

public class MinimumCostForTicket {
/*
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation:
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.


Time - O(days * cost) using memoization. Otherwise it would be O(days^cost)
Space - O(days)
 */
    public static void main(String[] args){
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        int[] days2 = {1,2,3,4,5,6,7,8,9,10,30,31}, costs2 = {2,7,15};
        int[] days3 = {1,4,6,7}, costs3 = {2,7,15};

        System.out.println(new MinimumCostForTicket().mincostTickets(days, costs));
        System.out.println(new MinimumCostForTicket().mincostTickets(days2, costs2));
        System.out.println(new MinimumCostForTicket().mincostTickets(days3, costs3));
    }



    int[] ticketValidity = new int[]{1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        if(days== null || days.length == 0){
            return 0;
        }
        int[] memoCache = new int[days.length];// used for memoization
        return minCostTicketsHelper(days, costs, 0, memoCache);
    }

    public int minCostTicketsHelper(int[] days, int[] costs, int startIndex, int[] memoCache) {
        if (startIndex >= days.length){//we have covered all the days (passvalidity reached beyong the last day)
            return 0;//no cost after the last day
        }

        if (memoCache[startIndex] > 0){//this subtree has already been solved
            return memoCache[startIndex];
        }

        int minCost = Integer.MAX_VALUE;
        for (int i=0; i<costs.length; i++){//iterate through the costs
            int nextStart = getNextStart(days, startIndex, ticketValidity[i]);//find the next day when the ticket purchase is required
            int curCost = costs[i] + minCostTicketsHelper(days, costs, nextStart, memoCache);//add the current cost and go DFS
            minCost = Math.min(minCost, curCost);//find min
        }
        memoCache[startIndex] = minCost;
        return minCost;

    }

    //find the next day when the ticket purchase is required
    private int getNextStart(int[] days, int startIndex, int validity) {
        int i = startIndex;
        while (i<days.length){
            if (days[i] > days[startIndex] + validity-1){//this is the day we need to purchase the ticket again
                break;
            }
            i++;
        }
    return i;
    }

}
