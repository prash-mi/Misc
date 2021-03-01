package com.leetcode.medium;

public class PseudoPalindromicPaths {
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root==null){
            return 0;
        }
        int[] pathCnt = {0};
        int[] map = new int[9]; //value of the path is in the range 1 - 9
        countPalinDromicPaths(root, map, pathCnt);
        return pathCnt[0];
    }

    private void countPalinDromicPaths(TreeNode cur, int[] map, int[] pathCnt) {
        if (cur==null){
            return;
        }
        if (cur.left==null&&cur.right==null){
            map[cur.val-1]++;;//add the leaf node value
            if (isPalindrom(map)){
                pathCnt[0]++;
            }
            map[cur.val-1]--;//backtrack
            return;
        }
        map[cur.val-1]++;
        countPalinDromicPaths(cur.left, map, pathCnt);
        countPalinDromicPaths(cur.right, map, pathCnt);
        map[cur.val-1]--;//backtrack
    }

    private boolean isPalindrom(int[] map) {//check if a permutation of path is palindromic
        //value of the path is in the range 1 - 9
        //now check that atmost one value in the map should be odd
        int odd = 0;
        for (int occurence:map){
            if (occurence==0){
                continue;
            }
            if (occurence%2==1){
                odd++;
            }
        }
        return odd<=1;
    }

    /* //This gave time limit exceed, as we computed the path first and then check if it's palindromic
       public int pseudoPalindromicPaths (TreeNode root) {
        if (root==null){
            return 0;
        }
        int[] pathCnt = {0};
        countPalinDromicPaths(root, new ArrayList<Integer>(), pathCnt);
        return pathCnt[0];
    }

    private void countPalinDromicPaths(TreeNode cur, ArrayList<Integer> path, int[] pathCnt) {
        if (cur==null){
            return;
        }
        if (cur.left==null&&cur.right==null){
            path.add(cur.val);//add the leaf node value
            if (isPalindrom(path)){
                pathCnt[0]++;
            }
            path.remove(path.size()-1);//backtrack
            return;
        }
        path.add(cur.val);
        countPalinDromicPaths(cur.left, path, pathCnt);
        countPalinDromicPaths(cur.right, path, pathCnt);
        path.remove(path.size()-1);//backtrack
    }

    private boolean isPalindrom(ArrayList<Integer> path) {//check if a permutation of path is palindromic
        //value of the path is in the range 1 - 9
        int[] map = new int[9];
        for (int v: path){
            map[v-1]++;
        }
        //now check that atmost one value in the map should be odd
        int odd = 0;
        for (int occurence:map){
            if (occurence==0){
                continue;
            }
            if (occurence%2==1){
                odd++;
            }
        }
        return odd<=1;
    }
     */
}
