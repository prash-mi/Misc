package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinTimeToCollectApple {

    public static void main(String[] args){
        int n = 4;
        int[][] edges = {{0,2},{0,3},{1,2}};
        List<Boolean> hasApple = new ArrayList();
        hasApple.add(false);hasApple.add(true);hasApple.add(false);hasApple.add(false);
        System.out.println(new MinTimeToCollectApple().minTime(4, edges, hasApple));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = createGraph(edges);
        return getMinCostDFS(graph, -1,0, hasApple);
    }

    private int getMinCostDFS(Map<Integer, List<Integer>> graph, int prev, int cur, List<Boolean> hasApple) {
    //A base case isn't required for recursion, the function always returns the cost
        int cost = 0;
        for (int next: graph.getOrDefault(cur, new ArrayList<>())){
            if (next != prev){//no need to maintain the visited set, we just need to make sure that we donot go back to the previous node
                cost += (getMinCostDFS(graph, cur, next, hasApple));//recurse for one or both children
            }
        }

        if (cur == 0){//need not add cost for the root node
            return cost;
        }else if (cost == 0 && hasApple.get(cur)){//if the cost is 0 then we havent found any apple below, return 2 if the current node has apple
            return 2;
        }else if (cost!=0){//already found apple, add 2 to the cost while returning to the parent
            cost +=2;
        }
     /*   if (cur!=0 && (cost!=0 || hasApple.get(cur))){// this check has the same outcome
            cost += 2;
        }*/

        return cost;

    }

    private Map<Integer, List<Integer>> createGraph(int[][] edges) {//created undirected graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            List<Integer> adjs = graph.getOrDefault(edge[0], new ArrayList<Integer>());
            adjs.add(edge[1]);
            graph.put(edge[0], adjs);

            List<Integer> adjs2 = graph.getOrDefault(edge[1], new ArrayList<Integer>());
            adjs2.add(edge[0]);
            graph.put(edge[1], adjs2);
        }
        return graph;
    }
}
