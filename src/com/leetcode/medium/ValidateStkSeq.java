package com.leetcode.medium;

import java.util.Stack;

public class ValidateStkSeq {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null||popped==null||pushed.length!=popped.length){
            return false;
        }

        Stack<Integer> st = new Stack<>();
        int j=0;

        for (int i = 0; i < pushed.length; i++){
            st.push(pushed[i]);
            while (!st.isEmpty() && j< popped.length && st.peek()==popped[j]){
                j++;
                st.pop();
            }
        }
        return st.empty();//all the elements were popped, to this is a valid sequence
    }
}
