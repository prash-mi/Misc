package com.leetcode.medium;

import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args){
        System.out.println(new BasicCalculator2().calculate("3 + 2 * 2/2 - 3"));
        System.out.println(new BasicCalculator2().calculate("3/2 "));
    }
    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        int num = 0;
        char previousOperation = '+';
        int result = 0;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if (Character.isDigit(c)){//computer the number
                num = (num*10) + (c-'0');
            }

            if (isOperand(c) || i == s.length()-1){//ignore whitespaces
                if (previousOperation == '+' || previousOperation =='-') {
                    operands.push(previousOperation == '-' ? -1 * num : num);//add the number in the stack

                }
                if (previousOperation == '/' || previousOperation =='*'){
                    //pop the previous number from the stack, perform the operation and push it back
                    int tmp = operands.pop();
                    if (previousOperation=='/'){
                        tmp = tmp/num;
                    }else{
                        tmp = tmp*num;
                    }
                    operands.push(tmp);
                }
                num = 0;
                previousOperation = c;
            }
        }
        while (!operands.isEmpty()){
            result += operands.pop();
        }
        return result;
    }

    private boolean isOperand(char c) {
        return c=='+' || c=='-' || c=='/' || c=='*';
    }

}
