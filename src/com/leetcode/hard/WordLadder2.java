package com.leetcode.hard;

import com.leetcode.medium.WordLadder;

import java.util.*;

/*
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
 */
public class WordLadder2 {

    public static void main(String[] args){
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        ArrayList<String> words = new ArrayList(Arrays.asList(wordList));
        List<List<String>> paths = new WordLadder2().findLadders("hit", "cog", words);
        for (List<String> path: paths){
            System.out.println(path);
        }

    }

    class WordAndDist{
        String curWord;
        int curDis;
        List<String> path = new ArrayList<>();
        public WordAndDist(String curWord, int curDis){
            this.curWord = curWord;
            this.curDis = curDis;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();
        if (beginWord==null||endWord==null||beginWord.equals(endWord)||wordList.size()==0){
            return paths;
        }
        Map<String, List<String>> graph = new HashMap<>();
        Queue<WordAndDist> bfs = new LinkedList<>();
        int minDis = Integer.MAX_VALUE;
        Set<String> visted = new HashSet<>();
        for (String word:wordList){
            //find all the variation/transformation of the words by changing a char. Ex: hot -> *ot, h*t, ho*
            //each of these variations/transformation will be a key in the graph, this implies that a letter dot is on edit away from hot, as dot's variation would be *ot
            for (int i=0; i<word.length(); i++){
                String variation = word.substring(0,i) + "*" + word.substring(i+1, word.length());
                List<String> adj =graph.getOrDefault(variation, new ArrayList<>());
                adj.add(word);
                graph.put(variation, adj);
            }
        }

        //use a queue to do a bfs
        WordAndDist wd = new WordAndDist(beginWord, 1);
        wd.path.add(beginWord);
        bfs.add(wd);
        while (!bfs.isEmpty()){
            WordAndDist curWrdDis = bfs.poll();
            visted.add(curWrdDis.curWord);

            for (int i=0; i<curWrdDis.curWord.length(); i++) {
                String variation = curWrdDis.curWord.substring(0, i) + "*" + curWrdDis.curWord.substring(i + 1, curWrdDis.curWord.length());

                List<String> adjs = graph.getOrDefault(variation, new ArrayList<>());//variation is one edit distance away for the current word
                for (String adjWord: adjs){//these are the adjacent words
                    if (adjWord.equals(endWord)){//deep copy the path
                        if (minDis == Integer.MAX_VALUE){
                            minDis = curWrdDis.curDis;
                        }
                        if (curWrdDis.curDis == minDis){//so that we add the shortest paths only
                            curWrdDis.path.add(endWord);//add end word
                            paths.add(curWrdDis.path);//no need to deep copy
                        }
                    }else if(!visted.contains(adjWord)){//explore other paths if it's not already explored
                        WordAndDist nextWd = new WordAndDist(adjWord, curWrdDis.curDis+1);
                        List<String> newPath = new ArrayList<>(curWrdDis.path);//deep copy
                        newPath.add(adjWord);
                        nextWd.path = newPath;
                        bfs.add(nextWd);
                    }
                }

            }
        }
    return paths;
    }
}