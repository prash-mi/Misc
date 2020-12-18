package com.leetcode.medium;

public class LCABinaryTree {
    class LCARetType{
        boolean foundP, foundQ;
        TreeNode lca;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCARetType lcaRet = findLCADfs(root, p, q);
        return lcaRet.lca;
    }

    private LCARetType findLCADfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur==null){
            return new LCARetType();
        }
        LCARetType left = findLCADfs(cur.left, p, q);
        LCARetType right = findLCADfs(cur.right, p, q);
        if (left.lca!=null || right.lca != null){//lca is already found, return it
            return left.lca!=null?left:right;
        }

        //see if we have found atleast one of these
        LCARetType ret = new LCARetType();
        ret.foundP = left.foundP || right.foundP;
        ret.foundQ = left.foundQ || right.foundQ;

        if (cur==p){
            ret.foundP = true;
        }
        if (cur==q){
            ret.foundQ=true;
        }
        if (ret.foundP && ret.foundQ){//both the nodes are now found
            ret.lca=cur;
        }
        return ret;
    }
}
