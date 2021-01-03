package com.leetcode.medium;

import java.util.*;

public class NodesAtKdistance {
class NodeAndDis{
    int dist;
    TreeNode node;
    NodeAndDis(int dist, TreeNode node){
        this.dist = dist;
        this.node = node;
    }
}
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        createNodeToParentMapDFS(root, null, nodeToParentMap);
        return getNodeAtKDisBFS(target, nodeToParentMap, K);//start BFS from target and find nodes at distance K
    }
    private List<Integer> getNodeAtKDisBFS(TreeNode target, Map<TreeNode, TreeNode> nodeToParentMap, int K) {
        List<Integer> res = new ArrayList<>();
        Queue<NodeAndDis> bfs = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        bfs.add(new NodeAndDis(0, target));

        while (!bfs.isEmpty()){
            NodeAndDis cur = bfs.poll();

            if (seen.contains(cur.node)){
                continue;
            }else {
                seen.add(cur.node);
            }

            if (cur.dist == K){//these are the required nodes
                res.add(cur.node.val);
            }
            if (cur.dist > K){//break as we have processed nodes till the distance K
                break;
            }
            //add left, right and parent nodes
            if (cur.node.left!=null && !seen.contains(cur.node.left)){
                bfs.add(new NodeAndDis(cur.dist+1, cur.node.left));
            }
            if (cur.node.right!=null && !seen.contains(cur.node.right)){
                bfs.add(new NodeAndDis(cur.dist+1, cur.node.right));
            }
            TreeNode curPar = nodeToParentMap.getOrDefault(cur.node, null);
            if (curPar!= null && !seen.contains(curPar)){
                bfs.add(new NodeAndDis(cur.dist+1, curPar));
            }
        }
        return res;
    }

    private void createNodeToParentMapDFS(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> nodeToParentMap) {
        if (cur == null){
            return;
        }
        nodeToParentMap.put(cur, parent);
        createNodeToParentMapDFS(cur.left, cur, nodeToParentMap);
        createNodeToParentMapDFS(cur.right, cur, nodeToParentMap);
    }




/*    class Node{
        int val, x, y;
        public Node(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) { // this logic of finding the distance is tricky
        List<Node> nodes = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Node targetNode = dfs(root, 0, 0, nodes, target);
        for (Node node: nodes){
            int xDist = Math.abs(node.x - targetNode.x);
            int yDist = Math.abs(node.y - targetNode.y);
            if (Math.max(xDist, yDist) == K){
                res.add(node.val);
            }
        }
        return res;
    }

    Node dfs(TreeNode cur, int x, int y, List<Node> nodes, TreeNode target){
        if (cur == null){
            return null;
        }
        nodes.add(new Node(cur.val, x, y));

        Node left = dfs(cur.left, x-1, y-1, nodes, target);
        Node right = dfs(cur.right, x+1, y-1, nodes, target);

        if (left !=null|| right!=null){
            return left!=null?left:right;
        }else if (cur.val == target.val){
            return new Node(cur.val, x, y);
        }else {
            return null;
        }
    }*/

}
