package com.leetcode.medium;

public class KokoEatingBananas {
    /*
    Input: piles = [3,6,7,11], H = 8
Output: 4
     */

    public static void main(String[] args){
        int[] piles = {3,6,7,11};
        System.out.println(new KokoEatingBananas().minEatingSpeed(piles, 8));
    }

    //Time complexity O(n * log(max)); n=piles.length and max = max number of banana in piles
    public int minEatingSpeed(int[] piles, int H) {
        int minSpeed = 1, maxSpeed = Integer.MIN_VALUE;
        for (int i: piles){
            maxSpeed = Math.max(maxSpeed, i);
        }
        //binary search eating speed, it will be between minSpeed and maxSpeed
        int eatingSpeed = maxSpeed;
        int left = minSpeed, right=maxSpeed;
        while (left<right){
            int mid = (left+right)/2;
            if(canEatPile(piles, mid, H)){
                right = mid;//go left and try to search for a lower value
                eatingSpeed = Math.min(eatingSpeed, mid);
            }else {
                left=mid;//+1;//go right
            }
        }
        return eatingSpeed;
    }


    private boolean canEatPile(int[] piles, int curSpeed, int totalTime){
        int time = 0;
        for (int pile: piles){

            int div = pile/curSpeed;
            int mod = pile%curSpeed;
            time += (div+(mod==0?0:1));

        }
        return time <=totalTime;
    }
}
