package com.leetcode.medium;

import java.util.*;

public class WordLadder {
    public static void main(String[] args){
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        ArrayList<String> words = new ArrayList(Arrays.asList(wordList));
        System.out.println(new WordLadder().ladderLength("hit", "cog", words));
    }
    class WordAndDist{
        String curWord;
        int curDis;
        public WordAndDist(String curWord, int curDis){
            this.curWord = curWord;
            this.curDis = curDis;
        }
    }

    //Time - O(n^2 * m) ; n is size of the list and m is the length of the word
    //A BETTER O(m^2 * n) solution is possible (as m << n)) - https://leetcode.com/problems/word-ladder/solution/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord==null||endWord==null||beginWord.equals(endWord)||wordList.size()==0){
            return 0;
        }
        //create a graph out of word list, that is find the list of the words which can be reached from a given word
        Map<String, List<String>> wordGraph = new HashMap<>();
        Set<String> seen = new HashSet<>();
        Queue<WordAndDist> bfs = new LinkedList<>();
        //preprocess and get the graph populated
        for (int i = 0; i < wordList.size(); i++){
            populateGraph(wordList.get(i), wordList, wordGraph);//populate the adjacencies of the current word
        }
        if (!wordGraph.containsKey(beginWord)){//as it's not mentioned that the starting word will be in the dictionary, if it's not then we explicitly add it's adjacencies in the graph
            populateGraph(beginWord, wordList, wordGraph);
        }

        bfs.add(new WordAndDist(beginWord, 1));//starting point
        //start bfs
        while (!bfs.isEmpty()){
            WordAndDist curWrdDis = bfs.poll();
            if (curWrdDis.curWord.equals(endWord)){//found the word
                return curWrdDis.curDis;
            }
            seen.add(curWrdDis.curWord);
            //else explore the adjacencies
            List<String> adj = wordGraph.getOrDefault(curWrdDis.curWord, null);
            if (adj==null){
                continue;//skip this iteration
            }

            for (String next:adj){
                if (!seen.contains(next)){//path from this word isn't explored yet
                    bfs.add(new WordAndDist(next, curWrdDis.curDis+1));//add next word and it's distance from the starting word
                }

            }

        }
        return 0;//endword not found
    }

    void populateGraph(String curWord, List<String> wordList, Map<String, List<String>> wordGraph){//populate the adjacencies of the current word
        for (int j=0; j< wordList.size(); j++){
            if (curWord.equals(wordList.get(j))){//same word
                continue;
            }
            if(hasOneEditDistance(curWord, wordList.get(j))){//the ith word can be changed to jth word by altering on char
                List<String> adjacency = wordGraph.getOrDefault(curWord, new ArrayList<>());
                adjacency.add(wordList.get(j));
                wordGraph.put(curWord, adjacency);
            }
        }
    }

    private boolean hasOneEditDistance(String w1, String w2) {
        if (w1.length()!=w2.length()){
            return false;
        }
        int dis = 0;
        for (int i = 0;i < w1.length(); i++){
            if (w1.charAt(i)!=w2.charAt(i)){
                dis++;
            }
            if (dis>1){
                return false;
            }
        }
        return dis ==1;
    }

}
