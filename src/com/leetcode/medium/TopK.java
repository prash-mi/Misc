package com.leetcode.medium;


import java.util.*;

public class TopK {
    public static void main(String[] args){
        String[] ip = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> top = new TopK().topKFrequent(ip, 4);
        System.out.println(top);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<Pair> topK = new PriorityQueue<>(k);
        List<String> topKWords = new ArrayList<>();
        for(String word: words){
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }
        for (String word: freq.keySet()){
            topK.add(new Pair(word, freq.get(word)));
            if (topK.size() > k){
                topK.poll();
            }
        }
        while (!topK.isEmpty()){
            topKWords.add(topK.poll().word);
        }
       Collections.reverse(topKWords);
    return topKWords;
    }
}

class Pair implements Comparable<Pair>{
    String word; int cnt;
    Pair(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Pair obj) {
            return this.cnt == obj.cnt?obj.word.compareTo(this.word):this.cnt - obj.cnt;
    }
}