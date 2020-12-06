package com.leetcode.easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed ==null || flowerbed.length == 0){
            return false;
        }
        if (n==0){
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++){
            if (flowerbed[i] == 1){//can't place the flower here or in the next position to skip right
                i++;
            }else if ( ( (i-1>=0 && flowerbed[i-1] == 0) || (i==0 && flowerbed[i] == 0)) &&
                    ((i+1 <flowerbed.length && flowerbed[i+1] == 0) || ((i==flowerbed.length-1 && flowerbed[i] == 0)))){//can place the flower here
                    flowerbed[i++] = 1;//i++ because we can not place the flower at the next step now, so skip that
                    n--;
            }
            if (n==0){
                return true;
            }
        }

        return false;
    }
}
