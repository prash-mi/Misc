package com.leetcode.medium;

public class LCA4 {
    class LCARetType{
        boolean[] found;
        TreeNode lca;
        public LCARetType(int len){
            found = new boolean[len];
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        LCARetType lcaRet = findLCA(root, nodes);
        return lcaRet.lca;
    }

    private LCARetType findLCA(TreeNode cur, TreeNode[] nodes) {
        if (cur==null){
            return new LCARetType(nodes.length);
        }
        LCARetType left = findLCA(cur.left, nodes);
        LCARetType right = findLCA(cur.right, nodes);
        if (left.lca!=null||right.lca!=null){
            return left.lca!=null?left:right;
        }

        LCARetType curRet = new LCARetType(nodes.length);
        //check the nodes which are already found
        boolean foundAll = true;
        for (int i = 0; i<nodes.length; i++){
            curRet.found[i] = left.found[i] || right.found[i] || cur.val == nodes[i].val;//if ith node was found at the left, right or the current node is the ith node
            foundAll = foundAll & curRet.found[i];
        }
        if (foundAll){
            curRet.lca = cur;
        }
    return curRet;
    }
}
