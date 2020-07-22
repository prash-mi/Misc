package com.leetcode.july;

public class WordSearch {
/*
Time Complexity: O(N * 4 ^ wordlength) ; Where N = number of cells

Space: O(wordlength) for call stack


 */
    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word =  "ABCCED";

        char[][] board2 =    {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word2 = "ABCB";

        char[][] board3 =  {{'a'}};
        String word3 = "a";

        System.out.println(new WordSearch().exist(board, word));
        System.out.println(new WordSearch().exist(board2, word2));
        System.out.println(new WordSearch().exist(board3, word3));
    }

    int[][] pos = {{0,-1}, {0,1}, {-1,0}, {1,0}};//left, right. up, down
    public boolean exist(char[][] board, String word) {

        if(board == null || word == null || word.equals("")){
            return false;
        }
            for(int row=0; row< board.length; row++){
                for(int col=0; col< board[0].length; col++){
                    if(searchDFS(board, word, row, col, 0)){
                        return true;
                    }
                }
            }

        return false;
    }

    public boolean searchDFS(char[][] board,  String word, int row, int col, int in){
        if(board[row][col]!= word.charAt(in)){//backtrack
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';//assuming input wont have #
        if(in +1 >= word.length()){//i +1 th char has matched
            return true;
        }
        for (int[] mov:pos){
            int nexX = row+mov[0];
            int nexY = col+mov[1];

            if(isValid(board, nexX, nexY) && searchDFS(board,  word, nexX, nexY, in+1)){
                return true;
            }//else try the other positions
        }
        board[row][col] = temp;//backtracking and marking it unvisited
        return false;
    }

    /******** approach with visited aus array, has bad space complexity*********/

    public boolean searchDFS2(char[][] board,boolean[][] visited,  String word, int row, int col, int in){
        if(board[row][col]!= word.charAt(in)){//backtrack
            return false;
        }
        visited[row][col] = true;
        if(in +1 >= word.length()){//i +1 th char has matched
            return true;
        }
        for (int[] mov:pos){
            int nexX = row+mov[0];
            int nexY = col+mov[1];

            if(isValid(board, nexX, nexY) && !visited[nexX][nexY] && searchDFS2(board,visited,  word, nexX, nexY, in+1)){
                return true;
            }//else try the other positions
        }
        visited[row][col] = false;//there is no path possible from the current cell, mark is unvisited so that we can visit it in any other flow
        return false;
    }

    public boolean isValid(char[][] board, int row, int col){
        return (row>=0 && row <board.length) && (col>=0 && col < board[0].length);
    }
}
