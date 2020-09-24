package com.leetcode.hard;

public class MinEditDistance {
    public int minDistance(String word1, String word2) {

        if(word1==null&&word2==null){
            return 0;
        }
        if (word1==null||word2==null){
            return word1==null?word2.length():word1.length();
        }

        int[][] aux = new int[word2.length()+1][word1.length()+1];
        for (int i=0; i < aux.length; i++){//initialized the first column, signifying the edit distance of the current char from null
            aux[i][0] = i;
        }
        for (int i = 0 ; i< aux[0].length; i++){
            aux[0][i]=i;
        }

        for (int r=1; r < aux.length; r++){
            for (int c=1; c < aux[0].length; c++){
                if (word2.charAt(r-1) == word1.charAt(c-1)){//get the diagonal value, signifying that the current char doesn't add any additonal cost.
                    aux[r][c] = aux[r-1][c-1];
                }else {//current chars are different, take min of top, diagonally top and left, then add 1
                    aux[r][c] = (Math.min(aux[r-1][c-1], Math.min(aux[r][c-1], aux[r-1][c])))+1;
                }
            }
        }

        return aux[aux.length-1][aux[0].length-1];
    }
}
