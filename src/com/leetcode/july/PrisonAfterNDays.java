package com.leetcode.july;

import java.util.HashSet;
import java.util.Set;

/*

There are 8 prison cells in a row, and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:
If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation:
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 */
public class PrisonAfterNDays {

    public static void main(String[] args){
        int[] cells = {0,1,0,1,1,0,0,1};

        int N = Integer.MAX_VALUE;
      //  cells = prisonAfterNDays(cells, N);

       // for (int i: cells) {
       //     System.out.print(i+", ");
      //  }
      //  System.out.println(cellsToBitmap(cells));


       cells  =new int[] {1,0,0,1,0,0,1,0};
       N= 1000000000;
        cells = prisonAfterNDays(cells, N);
        for (int i: cells) {
            System.out.print(i+", ");
        }
        System.out.println(cellsToBitmap(cells));
//Expected [0,0,1,1,1,1,1,0]
    }

    static int cellsToBitmap(int[] cells) {
        int stateBitmap = 0x0;
        for (int cell : cells) {
            stateBitmap <<= 1;
            stateBitmap = (stateBitmap | cell);
        }
      //  System.out.println(stateBitmap);
        return stateBitmap;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        Set<Integer> seenCell = new HashSet<>();
        boolean foundRepeatation = false;

        for(int i = 0; i < N; i++){

            if(foundRepeatation){
                cells = nextDay(cells);
                continue;
            }

            if (seenCell.contains(cellsToBitmap(cells))){
                // we have found a repeatation
                int k = seenCell.size();
                int per = N % k;


                i=0;
                N = per;//we just have to permute the current patten K times
                foundRepeatation = true;
            }else{
                seenCell.add(cellsToBitmap(cells));
                cells = nextDay(cells);
            }


        }

        return cells;
    }
static int[] nextDay(int[] cells) {
    int[] newCells = new int[cells.length];
    newCells[0] = 0;
    for (int i = 1; i < cells.length - 1; i++)
        newCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
    newCells[cells.length - 1] = 0;
    return newCells;
}
/*
    static int[] nextDay(int[] cells){
        int[] newCells = new int[cells.length];
        newCells[0] = 0;
        newCells[cells.length-1] = 0;
        for(int i=1; i < cells.length-1; i++){
            if(cells[i-1] == cells[i+1] ){
                newCells[i] = 1;
            }else {
                newCells[i] = 0;
            }
        }
        return newCells;
    }

 */
}


