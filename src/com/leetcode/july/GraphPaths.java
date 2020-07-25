package com.leetcode.july;

import java.util.LinkedList;
import java.util.List;

public class GraphPaths {
    public static void main(String[] args){
    int[][] graph = {{1,2}, {3}, {3}, {}};

        List<List<Integer>> result = new GraphPaths().allPathsSourceTarget(graph);

        for(List<Integer> path: result){
            for (int i: path){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        temp.add(0);

        findPaths(graph, temp, result, 0);
        return result;
    }

    void findPaths(int[][] graph, List<Integer> temp, List<List<Integer>> result, int cur){
        if(cur == graph.length-1){//reached the last node
            result.add(new LinkedList<>(temp));
            return ;
        }
        //explore the neighbours of cur
        int[] neighbours = graph[cur];
        if (neighbours == null || neighbours.length == 0){
            return;
        }
        for (Integer neighbour: neighbours){
            temp.add(neighbour);
            findPaths(graph, temp, result, neighbour);
            temp.remove(neighbour);//backtrack
        }
    }
}


