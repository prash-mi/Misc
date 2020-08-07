package com.leetcode.aug;

//WIP Code [Has bugs]
import java.util.*;

public class VerticalTraversal {

    public static void main(String[] args){



    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalTraversalRes = new ArrayList<>();
        Map<Integer, List<NodeXY>> vMap = new HashMap<>();
        MinMax minMax = new MinMax();
        verticalTraversalHelper(root,0,0, vMap, minMax );
        for (int i=minMax.min; i <= minMax.max; i++){
            if(vMap.containsKey(i)){
                List<NodeXY> verLine =    vMap.get(i);

                Collections.sort(verLine, (Comparator) (o1, o2) -> {
                NodeXY n1 = (NodeXY)o1;
                NodeXY n2 = (NodeXY)o2;
         if(n1.y != n2.y){//different Y values, sort by this
                            return n1.y - n2.y;
                        }else {
                            //order by value
                            if(n1.x!= n2.x){
                                return n1.x-n2.x;
                            }else {//order by
                                return n1.val-n2.val;
                            }
                        }
                    });
                //now verLine is sorted, put it verticalTraversalRes
                List<Integer> ver = new ArrayList<>();
                for(NodeXY n: verLine){
                    ver.add(n.val);
                }
                verticalTraversalRes.add(ver);
            }
        }
        return verticalTraversalRes;
    }

  private void  verticalTraversalHelper(TreeNode cur,int x,  int y,
                                        Map<Integer, List<NodeXY>> vMap, MinMax minMax ){
        if (cur==null){
            return;
        }
        if(vMap.containsKey(x)){
         vMap.get(x).add(new NodeXY(x, y, cur.val));
     }else{
         List<NodeXY> ls = new ArrayList<>();
         ls.add(new NodeXY(x, y, cur.val));
         vMap.put(x, ls);
     }

      minMax.min = Math.min(minMax.min, x);
      minMax.max = Math.max(minMax.max, x);
      verticalTraversalHelper(cur.left, x-1, y-1, vMap, minMax);//left is at x-1, y-1
      verticalTraversalHelper(cur.right, x+1, y-1, vMap, minMax);//right is at x+1, y-1
  }

}
class MinMax{
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
}
class NodeXY{
    int x, y, val;
    NodeXY(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
          this.right = right;
      }
  }

