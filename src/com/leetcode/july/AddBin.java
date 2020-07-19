package com.leetcode.july;
/*
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBin {
    public static void main(String[] args){

        System.out.println(new AddBin().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() -1, j = b.length()-1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0){
            int a1 = i >= 0? a.charAt(i) - '0':0;
            int a2 = j >= 0? b.charAt(j) - '0':0;
            i--;j--;
            int sum = a1+a2+carry;
            int currentDigit;
/*
Bin 1 + 1 = 10
    1 +0 = 1
    0 + 1 = 1
    0 + 0 = 0
    1 + 1 + 1 = 11
 */
            if (sum==3){
                carry = 1;
                currentDigit = 1;
            }else if(sum == 2){
                carry = 1;
                currentDigit = 0;
            }
            else if(sum == 1){
                carry = 0;
                currentDigit = 1;
            }else{
                carry = 0;
                currentDigit=0;
            }

            sb.append(currentDigit);

        }
        if (carry == 1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {

        char carry = '0';
        String res = "";

      int i = a.length() -1, j = b.length()-1;
      while (i >= 0 || j >= 0){

          char a1 = i >= 0?a.charAt(i):'0';
          char b1 = j >= 0?b.charAt(j):'0';
          i--;
          j--;

          char[] res1 = addBits(carry, a1);
          char[] res2 = addBits(res1[1], b1);
          res = res2[1]+res;
          carry = (res1[0] == '1' || res2[0] == '1')? '1':'0';

      }

      if(carry=='1'){
          res = carry+res;
      }
      return res;

    }

    public char[] addBits(char x, char y){
        char[] res = new char[2];//index 0 has carry, 1 has the num
        res[0] = '0';
        res[1] = '0';
        if(x =='0' && y =='0'){
            return res;
        }

        if(x =='1' && y =='1'){
            res[0] = '1';
            return res;
        }

        //just one of the bits are 0
        res[1] = '1';
        return res;
    }
}
