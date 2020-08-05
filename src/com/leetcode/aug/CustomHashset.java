package com.leetcode.aug;

public class CustomHashset{

    public static void main(String[] args){
/*
["add","add","contains","contains","add","contains","remove","contains"]
  [1],  [2],  [1],       [3],       [2],  [2],       [2],     [2]]

  null, null, true,      false,     null,  true,     null,      false]

 */

        MyHashSet hs = new MyHashSet();
        hs.add(1);
        hs.add(2);
        System.out.println(hs.contains(1));
        System.out.println(hs.contains(3));
        hs.add(2);
        System.out.println(hs.contains(2));
        hs.remove(2);
        System.out.println(hs.contains(2));

    }

}
//Uses Binary Tree to store data in case of collision
 class MyHashSet {
    final int SIZE = 1001;//a reasonabaly large prime number
    private TNode[] buckets = new TNode[SIZE];
    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {

        int bucketInd = key%SIZE;
        if(buckets[bucketInd] == null){
            buckets[bucketInd] = new TNode(key);
        }else {
            if(!find(buckets[bucketInd], key)){//do not allow duplicates in the set
                addChild(buckets[bucketInd], key);
            }
        }
    }

    public void remove(int key) {
        int bucketInd = key%SIZE;
        if(buckets[bucketInd] == null){
            return;
        }

        buckets[bucketInd] =  deleteNode(buckets[bucketInd], key);

    }

     public TNode deleteNode(TNode cur, int val) {
         if (cur == null){
             return null;
         }//we reached a dead end, nothing to delete
         if (cur.val == val){//delete it
             if (cur.left == null && cur.right == null){//both children are null, attach parent to null
                 return null;
             }

             //if right children is not null then replace cur with inorder successor, then delete the successor recursively[same logic applies when both the children aren't null]
             if(cur.right!= null){
                 TNode suc = findInorderSuccessor(cur.right);
                 cur.val = suc.val;
                 cur.right = deleteNode(cur.right, suc.val);
                 return cur;
             }else{
                 TNode pre = findInorderPredecessor(cur.left);
                 cur.val = pre.val;
                 cur.left = deleteNode(cur.left, pre.val);
                 return cur;
             }

         }
         if (cur.val<val){//go right
             cur.right = deleteNode(cur.right, val);
         }else {
             cur.left = deleteNode(cur.left, val);
         }
         return cur;
     }

     private TNode findInorderSuccessor(TNode cur){
         if (cur.left == null){
             return cur;
         }
         return findInorderSuccessor(cur.left);
     }

     private TNode findInorderPredecessor(TNode cur){
         if (cur.right == null){
             return cur;
         }
         return findInorderPredecessor(cur.right);
     }


    private TNode findInorderSucessor(TNode cur){
        if (cur.left == null){
            return cur;
        }
        return findInorderSucessor(cur.left);
     }

    //returns the node to be deleted
     private TNode findNode(TNode cur, int val){
         if (cur == null){
             return null;
         }
         if (cur.val == val){
             return cur;
         }
         if (cur.val< val){//go right
             return findNode(cur.right, val);
         }else{//go left
             return findNode(cur.left, val);
         }
     }


    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketInd = key%SIZE;
        if(buckets[bucketInd] == null){
            return false;//bucket is null
        }else{
            return find(buckets[bucketInd], key);//binary search it
        }
    }

    private TNode addChild(TNode cur, int val){

        if (cur == null){
            return new TNode(val);
        }
        if (cur.val< val){//go right
            cur.right = addChild(cur.right, val);
        }else {
            cur.left = addChild(cur.left, val);
        }

        return cur;
    }

    private boolean find(TNode cur, int val){
          if (cur == null){
              return false;
          }
        if (cur.val == val){
            return true;
        }
        if (cur.val< val){//go right
            return find(cur.right, val);
        }else{//go left
            return find(cur.left, val);
        }
    }
}

class TNode{
    TNode left, right;
    int val;
    TNode(int val){
        this.val = val;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */