package com.leetcode.medium;

import java.util.*;

public class MinGeneticMutation {
    class GeneAndDist{
        String curGene;
        int curDis;
        public GeneAndDist(String curGene, int curDis){
            this.curGene = curGene;
            this.curDis = curDis;
        }
    }
    //O(n * m^2)
    public int minMutation(String start, String end, String[] bank) {
        Map<String, List<String>> graph = new HashMap<>();
        Queue<GeneAndDist> bfs= new LinkedList<>();
        Set<String> visitedGenes = new HashSet<>();
        //Time for this loop (numberOfWords * lengthOfWord * lengthOfWord) //two loops and one nexted substring operation
        for (String word:bank){
            for (int i=0; i<word.length(); i++){
                String mut = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> genes = graph.getOrDefault(mut, new ArrayList<>());
                genes.add(word);
                graph.put(mut, genes);//1 char mutation to valid genes map
            }
        }

        bfs.add(new GeneAndDist(start, 0));
    //    Time for this loop (numberOfWords * lengthOfWord * lengthOfWord) or O(n * m^2). As BFS search will go to n words at most, for each of those words there can be at max m mutations, with a nested substring operation
        while (!bfs.isEmpty()){
            GeneAndDist curGeneDis = bfs.poll();
            String gene = curGeneDis.curGene;
            visitedGenes.add(gene);
            if (gene.equals(end)){
                return curGeneDis.curDis;//these many mutation at min
            }

            //else mutate each char at a time
            for (int i=0; i<gene.length(); i++){
                String mut = gene.substring(0, i) + "*" + gene.substring(i+1);
                List<String> adjs = graph.getOrDefault(mut, new ArrayList<>());
                for (String nextGene: adjs){
                    if (!visitedGenes.contains(nextGene)){
                        bfs.add(new GeneAndDist(nextGene, curGeneDis.curDis+1));
                    }
                }
            }
        }
        return -1;
    }
}
