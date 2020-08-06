package com.leetcode.aug;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordDictionary {

    public static void main(String[] args){

        WordDictionary wd = new WordDictionary();
        wd.addWord("ran");
        wd.addWord("rune");
        wd.addWord("runner");
        wd.addWord("runs");
        wd.addWord("add");
        wd.addWord("adds");
        wd.addWord("adder");
        wd.addWord("addee");

        System.out.println(wd.search("......."));
 /*       System.out.println(wd.search("bas"));
        System.out.println(wd.search("nad"));
       System.out.println(wd.search("ba."));
       System.out.println(wd.search("d.."));
        System.out.println(wd.search("..."));
        System.out.println(wd.search("...."));
        System.out.println(wd.search("..d"));
       System.out.println(wd.search("..k"));*/




    }


    /** Initialize your data structure here. */
    TrieNode root = new TrieNode('\0');
    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
        }
        cur.isComplete = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null||word.length()==0){
            return false;
        }
        return searchHelper(root, word, 0);
    }


 public boolean searchHelper(TrieNode cur, String word, int index) {

        for(int i = index ; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == '.'){//wildcard , try all the children recursively
                Set<Character> children = cur.children.keySet();
                if (children.size() == 0){//word has a wildcard char but we have run out of characters in the Trie.
                    return false;
                }
                for(Character ch: children){
                    if (searchHelper(cur.children.get(ch), word, i+1)){
                        return true;
                    }

                }
                return cur.isComplete && index+1 == word.length();
            }else{
                if (cur.children.containsKey(c)){
                    cur = cur.children.get(c);
                }else{
                    return false;
                }
            }
        }

        return cur.isComplete;//did the word finish here
    }
}

 class TrieNode{
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isComplete= false;
    TrieNode(char c){
        this.c = c;
    }
}