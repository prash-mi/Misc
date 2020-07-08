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
public class PrisonAfterN {

    public static void main(String[] args){
        int[] cells = {0,1,0,1,1,0,0,1};

        int N = Integer.MAX_VALUE;
        cells  =new int[] {1,0,0,1,0,0,1,0};
        N= 1000000000;
        cells = prisonAfterNDays(cells, N);
        for (int i: cells) {
            System.out.print(i+", ");
        }
        System.out.println(cellsToStr(cells));
        //Expected [0,0,1,1,1,1,1,0]
    }

    static String cellsToStr(int[] cells) {
        String str = "";
        for (int cell : cells) {
            str += cell;
        }
        return str;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        Set<String> seenCell = new HashSet<>();
        boolean foundFirstRepeating = false;

        for(int i = 0; i < N; i++){
            seenCell.add(cellsToStr(cells));
            cells = nextDay(cells);
            if (seenCell.contains(cellsToStr(cells)) && !foundFirstRepeating){  // we have found a repeatation
                int cycle = seenCell.size();
                int remainingCycles  = N % cycle-1;

                i=0;
                N = remainingCycles;//we just have to permute the current patten K times
                foundFirstRepeating = true;

            }

        }
        return cells;
    }


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


}


