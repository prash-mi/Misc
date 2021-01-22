package com.leetcode.easy;

public class LongestConsecutiveSequence2 {

    public static void main(String[] args){
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left=n1;
        n2.right=n3;
        System.out.println(new LongestConsecutiveSequence2().longestConsecutive(n2));
    }

    class IncDecMax{
        int inc = 1, dec = 1, max = 1;
       IncDecMax(int inc, int dec){
           this.inc = inc;
           this.dec = dec;
       }
    }

//Time O(n) Space O(n)

    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        return getLongest(root).max;
    }

    IncDecMax getLongest(TreeNode cur){
        if (cur == null){
            return new IncDecMax(0,0);
        }
        IncDecMax left = getLongest(cur.left);
        IncDecMax right = getLongest(cur.right);

        IncDecMax curLen = new IncDecMax(1,1);//1 is the min length for any node
        if (cur.left!= null){
            if (cur.left.val +1 == cur.val){//decr seq from the current node
                curLen.dec = left.dec+1;
            }else if(cur.left.val -1 == cur.val){//incr seq from the current node
                curLen.inc = left.inc+1;//the length of increasing sequence will be the length of incr seq at left plus 1
            }
        }

        if (cur.right!=null){
            if (cur.right.val+1 == cur.val){//decr seq
                curLen.dec = Math.max(right.dec+1, curLen.dec);//IMP: taking max as we would have found an even bigger value in the left
            }else if (cur.right.val -1 == cur.val){//incr value
                curLen.inc = Math.max(right.inc+1, curLen.inc);
            }
        }

        int maxSeqLenSubTree = Math.max(left.max, right.max);
        int curSubSeqLen = curLen.inc+curLen.dec-1;//or it could be curLen.dec+curLen.inc-1, with will produce the same value
        curLen.max = Math.max(maxSeqLenSubTree, curSubSeqLen);
        return curLen;
    }






/*
  //This solution works when the sequence is increasing or decreasing, but doesnt span across the root node
  class LongestLen{
        int len = 1;
    }
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        LongestLen l = new LongestLen();
        getLongCons(root, l, Integer.MIN_VALUE, 1, true);
        return l.len;
    }

    void getLongCons(TreeNode cur, LongestLen l, int prev, int consSeqLen, boolean isIncreasing){
        if (cur == null){
            return;
        }

        if ((isIncreasing && cur.val == prev + 1) ||
                (!isIncreasing && cur.val == prev - 1)){//increasing or decreasing sequence
            consSeqLen++;
            l.len = Math.max(l.len, consSeqLen);
        }else if( (isIncreasing && cur.val == prev-1) ||//was increasing and now started decreasing
                (!isIncreasing && cur.val == prev+1) ){//, or vice versa
            consSeqLen = 2;//the previous value and the current value
            isIncreasing = !isIncreasing;
        }else{//neither consecutively increasing or decreasing
            consSeqLen = 1;//reset
        }

        getLongCons(cur.left, l, cur.val, consSeqLen, isIncreasing);
        getLongCons(cur.right, l, cur.val, consSeqLen, isIncreasing);
    }*/


}
