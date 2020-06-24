package com.leetcode.array;

public class LongestDuplicate {
    static int prime = 11;
    public static void main(String[] args){

        String in = "banana";
        String pat = "ana";

        System.out.println(findStringRabinKarp(in.toCharArray(), pat.toCharArray()));
    }

    public static int findStringRabinKarp(char[] in, char[] pat ){//find 'pat' in 'in'
        //BANANA ANA
        int patHash = getHash(pat);
        int rolloingHash = 0;
        for(int i = 0; i < in.length; i++){

            if(i < pat.length){//initial rolling hash calculation
                rolloingHash += (in[i] * Math.pow(prime, i));
                if(i < pat.length-1) {//we havent yet seen a sequence equal to pat's length
                    continue;
                }
            }else{//calculate rolling hash
                rolloingHash -= in[i-pat.length];
                rolloingHash /= prime;
                rolloingHash += (in[i] * Math.pow(prime, (pat.length-1)));
            }


            if (rolloingHash == patHash &&
                    charCmp(in, i- pat.length+1 ,pat)){// we found a match

                return i- pat.length-1;

            }


        }


        return -1;
    }

    public static boolean charCmp(char[] in, int start, char[] pat){
        for(int i = start; i < start + pat.length; i++){
            if (in[start] != pat[i-start]){
                return false;
            }
        }
        return true;
    }
    public static int getHash(char[] sub){
        int hash = 0;

        for(int i = 0; i < sub.length; i++){
            hash += (sub[i] * Math.pow(prime, i));
        }

        return hash;
    }
}

