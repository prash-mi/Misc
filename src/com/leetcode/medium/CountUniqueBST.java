package com.leetcode.medium;

//O(n^2) time and O(n) space
public class CountUniqueBST {
    public static void main(String[] args){
        System.out.println(new CountUniqueBST().numTrees(5));
    }
    public int numTrees(int n) {
        if (n<1){
            return 0;
        }

        int[] aux = new int[n+1];
        aux[0]= 1;//1 as a multiplyer if there are 0 nodes on a side
        aux[1]= 1; // 1 tree with 1 node
      //  aux[2]= 2;//2 trees with 2 nodes
      //  aux[3]= 5;//5 trees with 3 nodes

        for (int i = 2; i<=n; i++){
            for (int j = 0; j<i; j++){
                //there will be j nodes on one side and i - j - 1 on the other (this is also called CatalanNumber)
                aux[i] += (aux[j]*aux[i-j-1]);
            }
        }

        return aux[n];
    }
}
