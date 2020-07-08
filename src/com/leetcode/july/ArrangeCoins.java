package com.leetcode.july;

public class ArrangeCoins {


    public static void main(String[] args){
    //    System.out.println(arrangeCoins(1));
    //    System.out.println(arrangeCoins(5));
     //   System.out.println(arrangeCoins(8));
    //    int x = 65535;
        //long total = (x * (x+1))/2;
        //System.out.println(total);
        System.out.println(arrangeCoins(2147483647));
    }

//65535

    public static int arrangeCoins(int n) {
    long left=0, right =n  ;
    long mid = 0;

    while(left<=right){
        mid = (left+right)/2;

        long totalCoins = (mid * (mid + 1))/2;
        long nextTotalCoins = ((mid+1) * (mid + 2))/2;

        if (totalCoins<=n && nextTotalCoins >n){
            return (int)mid;
        }

        if(totalCoins > n){//go left
            right = mid -1;
        }else{//go right
            left = mid +1;
        }

    }

    return 0;
    }
    public static int arrangeCoinsLinear(int n) {
        if(n<1){return 0;}
        int height = 0,  totalUsed = 0;
        while(totalUsed + height + 1 >0 && totalUsed + height + 1 <= n){//totalUsed + height + 1 >0 condition is required for avoiding overflow
                height++;
                totalUsed += (height);
        }
        return height;
    }
}
