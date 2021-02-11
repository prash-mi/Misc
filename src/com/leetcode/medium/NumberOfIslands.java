package com.leetcode.medium;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandCnt = 0;
        if (grid==null||grid.length==0){
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r< grid.length; r++){
            for (int c = 0; c<grid[0].length; c++){
                if (!visited[r][c] && grid[r][c] == '1'){
                    islandCnt++;//we have a new island
                    markVisited(grid, r, c, visited);//DFS and mark the connecting 1s visited
                }
            }
        }
        return islandCnt;
    }

    int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    private void markVisited(char[][] grid, int r, int c, boolean[][] visited) {

        if ( (r<0||r>=grid.length || c<0||c>=grid[0].length) || visited[r][c] || grid[r][c] != '1'){//if it's a valid unvisited coordinate
            return;
        }
        visited[r][c] =true;
        for (int[] move: moves){//visit neighbours
            markVisited(grid, r+move[0], c+move[1], visited);
        }
    }
}