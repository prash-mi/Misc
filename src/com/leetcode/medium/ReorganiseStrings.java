package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseStrings {
    /*
    Input: S = "aab"
    Output: "aba"
     */

    public String reorganizeString(String str) {
        if (str==null|| str.length()<=1){
            return str;
        }
        StringBuffer res = new StringBuffer();
        PriorityQueue<CharAndCnt> chrCnt = new PriorityQueue<>((o1, o2) -> o2.cnt-o1.cnt);// max priority queue, element with most occurence should be at top
        Map<Character, Integer> cmap = new HashMap<>();
        for (int i=0; i < str.length(); i++){
            cmap.put(str.charAt(i), (cmap.getOrDefault(str.charAt(i), 0)+1));
        }
        //populate priority queue
        for (Character c: cmap.keySet()){
            chrCnt.add(new CharAndCnt(c, cmap.get(c)));
        }

        while (!chrCnt.isEmpty()){
            CharAndCnt c1 = chrCnt.poll();
            CharAndCnt c2 = chrCnt.isEmpty()?null:chrCnt.poll();

            res.append(c1.c);

            if (c2==null){//then this should be the last occurence of c1, otherwise c1 will repeat in the next iteration
                if (c1.cnt!=1){
                    return "";//no solution is possible
                }
            }else{//append c2
                res.append(c2.c);
            }

            if (c1.cnt>1){//append the remaining occurences of c1 and c2
                c1.cnt--;
                chrCnt.add(c1);
            }
            if (c2!=null && c2.cnt>1){
                c2.cnt--;
                chrCnt.add(c2);
            }
        }

        return res.toString();
    }

    class CharAndCnt{
        char c;
        int cnt;
        CharAndCnt(char c, int cnt){
            this.cnt=cnt;
            this.c=c;
        }
    }
}
