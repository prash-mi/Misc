package com.leetcode.medium;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args){
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        new SurroundedRegions().solve(board);
        for (int r= 0 ; r<board.length; r++) {
            System.out.println(Arrays.toString(board[r]));
        }

    }
    //O(row * col) time and space
    public void solve(char[][] board) {
        if (board==null||board.length==0){
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int c = 0; c<board[0].length; c++){//we will start from the first and the last row
            dfsVisit(board, visited, 0, c);//first row
            dfsVisit(board, visited, board.length-1, c);//last row
        }
        for (int r = 0; r<board.length; r++){//we will start from the first and the last column
            dfsVisit(board, visited, r, 0);//first column
            dfsVisit(board, visited, r, board[0].length-1);//last column
        }

        for (int r= 0 ; r<board.length; r++){
            for (int c= 0 ; c<board[0].length; c++){
                if (!visited[r][c] && board[r][c] == 'O'){//now unvisited Os aren't surrounded
                    board[r][c] = 'X';
                }
            }
        }
    }

    int[][] moves = {{1,0}, {-1, 0}, {0,1}, {0,-1}};//horizontal and vertical moves
    private void dfsVisit(char[][] board, boolean[][] visited, int curR, int curC) {
        if (visited[curR][curC] || board[curR][curC] == 'X'){//wont visit X and already visited Os
            return;
        }
        visited[curR][curC] = true;
        for (int[] move: moves){
            int nextR = curR+move[0];
            int nextC = curC+move[1];
            if (canVisit(nextR, nextC, board, visited)){
                dfsVisit(board, visited, nextR, nextC);
            }
        }
    }

    private boolean canVisit(int nextR, int nextC, char[][] board, boolean[][] visited) {
        return nextR>=0 && nextR< board.length && nextC>= 0 && nextC < board[0].length && !visited[nextR][nextC] && board[nextR][nextC] == 'O';
    }
}
