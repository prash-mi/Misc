package com.leetcode.aug;

import java.util.LinkedList;
import java.util.Queue;

/*
0 - Unset
1 - Fresh
2 - Rotten
 */
public class RottingOranges {

    public static void main(String[] args){

int[][] grid = {{2,1,1},
                {1,1,0},
                {0,1,1}};
System.out.println(new RottingOranges().orangesRotting(grid));



    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length==0){
            return 0;
        }
     int minutes = 0;

        Queue<OrangePos> neighbours = new LinkedList<>(), nextNeighbours = new LinkedList<>();

    for (int i = 0; i < grid.length; i++){
        for (int j= 0; j < grid[0].length; j++){
            if (grid[i][j] == 2){//rotten
                neighbours.add(new OrangePos(i, j));
            }
        }
    }

   // boolean setNeighbour = false;//will be used for setting up the minute counter
    int[][] moves = {{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    while (!neighbours.isEmpty()){

        OrangePos cur = neighbours.poll();
        for (int[] mov: moves){
            int nextX = cur.x + mov[0];
            int nextY = cur.y + mov[1];
            if(isValid(nextX, nextY, grid) &&  grid[nextX][nextY]== 1){
                grid[nextX][nextY] = 2;//got rotten
                nextNeighbours.add(new OrangePos(nextX, nextY));

            }

        }
        if (neighbours.isEmpty() && !nextNeighbours.isEmpty()){//explored all the neighbours at the current breath
            minutes++;
            neighbours = nextNeighbours;
            nextNeighbours = new LinkedList<>();
        }
    }

//check if there are no fresh cell (1)
        for (int i = 0; i < grid.length; i++){
            for (int j= 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){//fresh
                    return -1;
                }
            }
        }

    return minutes;
    }

    private boolean isValid(int x, int y, int[][] grid){
        return x>= 0 && x < grid.length && y >=0 && y< grid[0].length;
    }
}

class OrangePos{
    int x, y;
    OrangePos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
