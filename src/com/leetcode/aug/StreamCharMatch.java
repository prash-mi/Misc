package com.leetcode.aug;

import java.util.*;

public class StreamCharMatch {
    public static void main(String[] args){
        String[] words = {"ab","ba","aaab","abab","baa"};
        char[] stream = {'a','a','a','a','a','b','a','b','a','b','b','b','a','b','a','b','b','b','b','a','b','a','b','a','a','a','b','a','a','a'};

        StreamChecker streamChecker = new StreamChecker(words); // init the dictionary.
        for (char c : stream){
            System.out.print( streamChecker.query(c)+",");
        }
    }
}

class StreamChecker {
    final STNode root = new STNode();//this is a Trie in the reverse order
    StringBuffer stream = new StringBuffer();

    public StreamChecker(String[] words) {//add the words in Trie
        for (String word:words){
            STNode cur = root;
            for (int i = word.length()-1; i >= 0; i--){
                if(!cur.chars.containsKey(word.charAt(i))){
                    cur.chars.put(word.charAt(i), new STNode());
                }
                cur = cur.chars.get(word.charAt(i));
            }
            cur.wordEnds = true;//it's actually the starting char, but we are marking it as wordEnd because we will be matching in reverse
        }
    }

    public boolean query(char letter) {
        stream.append(letter);
        //match in the revese order. for example word CAT is stored as TAC and say the stream is AACAT, then the last index of stream should match with the first index of Trie
        STNode cur = root;
      for (int i = stream.length()-1; i >= 0; i--){
          if (cur.chars.containsKey(stream.charAt(i))){
              cur = cur.chars.get(stream.charAt(i));//advance hhe cursor
              if (cur.wordEnds){
                  return true;
              }
          }else {
              return false;
          }
      }
        return false;
    }
}
/*
//this logic of standard trie while maintaining pointers doesn't work
class StreamChecker {
    final STNode root = new STNode();
    List<STNode> curPtrs = new LinkedList<>();
    public StreamChecker(String[] words) {//add the words in Trie
        for (String word:words){
            STNode cur = root;
            for (int i = 0; i < word.length(); i++){
                if(!cur.chars.containsKey(word.charAt(i))){
                    cur.chars.put(word.charAt(i), new STNode());
                }
                cur = cur.chars.get(word.charAt(i));
            }
            cur.wordEnds = true;//cur word ended
        }
    curPtrs.add(root);//there will be a pointer always at root.
    }

    public boolean query(char letter) {
        *//*
        Start searching (dfs) from root and curPointers and see if we reached a wordEnd
         *//*
        boolean wordEnded = false;
        List<STNode> toDel = new LinkedList<>();
        List<STNode> toAdd = new LinkedList<>();
        for (STNode curPtr: curPtrs){
            if (curPtr.chars.containsKey(letter)){
                STNode nextPtr = curPtr.chars.get(letter);
                if(!wordEnded && nextPtr.wordEnds){//do not set it false if it was already set true. for the cases like "cat" and "cats"//even cats pointer need to advance
                    wordEnded = true;
                }
                //advance the pointer
                if (!curPtr.equals(root)){//we dont need to remove root as search should always include root
                    toDel.add(curPtr);
                   // curPtrs.remove(curPtr); Cant delete the list while iterating
                }
                toAdd.add(nextPtr);
                //curPtrs.add(nextPtr);
            }
        }
        for (STNode del: toDel){
            curPtrs.remove(del);
        }
        for (STNode add: toAdd){
            curPtrs.add(add);
        }
        return wordEnded;
    }
}*/

class STNode{
    Map<Character, STNode> chars = new HashMap<>();
    boolean wordEnds = false;
}