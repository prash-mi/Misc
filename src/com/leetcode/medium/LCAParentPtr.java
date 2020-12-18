package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LCAParentPtr {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node cur1 = p, cur2 = q;
        Set<Node> seen = new HashSet<>();
        while (cur1!=null || cur2!= null){
            if (cur1!=null){
                if (seen.contains(cur1)){
                    return cur1;
                }
                seen.add(cur1);
                cur1 = cur1.parent;
            }

            if (cur2!=null){
                if (seen.contains(cur2)){
                    return cur2;
                }
                seen.add(cur2);
                cur2 = cur2.parent;
            }
        }
        return null;
    }
}
