package com.leetcode.medium;

import java.util.*;

public class VerticalTraversal {
//does vannilla vertical order traversal. the nodes at the same vertical line will come in the order as discovered by DFS
    public static void main(String[] args){



    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalTraversal = new ArrayList<>();
        Map<Integer, List<Integer>> vMap = new HashMap<>();
        MinMax minMax = new MinMax();
        verticalTraversalHelper(root,0, vMap, minMax );
        for (int i=minMax.min; i <= minMax.max; i++){
            if(vMap.containsKey(i)){
                verticalTraversal.add(vMap.get(i));
            }
        }
        return verticalTraversal;
    }

    private void  verticalTraversalHelper(TreeNode cur, int vDistance, Map<Integer, List<Integer>> vMap, MinMax minMax ){
        if (cur==null){
            return;
        }
        //put the current item in vLists
        if(vMap.containsKey(vDistance)){
            vMap.get(vDistance).add(cur.val);
        }else{
            List<Integer> ls = new ArrayList<>();
            ls.add(cur.val);
            vMap.put(vDistance, ls);
        }

        minMax.min = Math.min(minMax.min, vDistance);
        minMax.max = Math.max(minMax.max, vDistance);
        verticalTraversalHelper(cur.left, vDistance-1, vMap, minMax);
        verticalTraversalHelper(cur.right, vDistance+1, vMap, minMax);
    }

}
class MinMax{
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
}



