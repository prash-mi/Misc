package com.leetcode.july;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTreeTraversal {
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.left =n9;
        n6.right = n10;

        List<List<Integer>> zigZag = new ZigZagTreeTraversal().zigzagLevelOrder(n1);
        for (List<Integer> lst: zigZag){
            for (int i: lst){
                System.out.print(i+" ");

            }
            System.out.println();
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag = new LinkedList<>();
        Deque<TreeNode> curLvl = new LinkedList<>();
        Deque<TreeNode> nxtLvl = new LinkedList<>();
        boolean leftToRight = true;
        List<Integer> curLvlInt = new LinkedList<>();
        if (root!=null){
            curLvl.add(root);
        }

        while (!curLvl.isEmpty()){
            TreeNode cur = curLvl.pollFirst();
            curLvlInt.add(cur.val);
            if (leftToRight){
                if(cur.left!= null){
                    nxtLvl.addFirst(cur.left);
                }
                if(cur.right!= null){
                    nxtLvl.addFirst(cur.right);
                }

            }else {//right to left
                //add right then left towards the front of the list
                if(cur.right!= null){
                    nxtLvl.addFirst(cur.right);
                }
                if(cur.left!= null){
                    nxtLvl.addFirst(cur.left);
                }
            }

            if (curLvl.isEmpty()){
                curLvl = nxtLvl;
                nxtLvl = new LinkedList<>();
                zigZag.add(curLvlInt);
                curLvlInt = new LinkedList<>();
                leftToRight = !leftToRight;//change the order
            }
        }

        return zigZag;
    }
}
