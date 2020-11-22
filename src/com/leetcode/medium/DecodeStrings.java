package com.leetcode.medium;

import java.util.Stack;

//Time: O(maxK * n) , space (K + n); where k is the number and n is the number of chars a-z
public class DecodeStrings {
    public static void main(String[] args){
        System.out.println(new DecodeStrings().decodeString("10[a]2[bc]"));
        System.out.println(new DecodeStrings().decodeString("3[a2[c]]"));
        System.out.println(new DecodeStrings().decodeString("3[a]2[bc]"));
    }
    public String decodeString(String s) {
        StringBuffer decodedBuffer = new StringBuffer();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String num = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){//prepend the digit in the buffer
                num = num + c;
            }else if(c == '['){//add the digit in numStack and decodedBuffer in strStack
                    numStack.push(Integer.parseInt(num));
                    num = "";
                    strStack.push(decodedBuffer.toString());
                    decodedBuffer = new StringBuffer();
            }else if (c == ']'){//decode, get the number from numStack and duplicate decodedBuffer that many times
                                // the pop the value from the stack like 'a' in "3[a2[c]]" and append the multiplied string that many times
                                //this value becomes the new decodedBuffer

                int mulCnt = numStack.pop();
                StringBuffer tmp = new StringBuffer();
                while(mulCnt>0){
                    tmp.append(decodedBuffer);
                    mulCnt--;
                }
                StringBuffer prevStr = new StringBuffer(strStack.pop());
                prevStr.append(tmp);
                decodedBuffer = prevStr;

            }else{//append it in the buffer
                decodedBuffer.append(c);
            }
        }
        return decodedBuffer.toString();
    }
}
