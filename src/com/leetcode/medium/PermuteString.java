package com.leetcode.medium;

public class PermuteString {
    public static void main(String[] args){
        new PermuteString().permute("ABC".toCharArray(), 0);
    }

    void permute(char[] ip, int fix){
        if (fix> ip.length-1){
            System.out.println(ip);
            return;
        }

        for (int i = fix; i < ip.length; i++){
            //swap fix and i
            swap(ip, fix, i);
            permute(ip, fix+1);
            swap(ip, fix, i);//undo the swap
        }
    }

    private void swap(char[] ip, int x, int y){
        char temp = ip[x];
        ip[x] = ip[y];
        ip[y] = temp;
    }
}
