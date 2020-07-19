package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/*
Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
ignore everything after +
 */
public class EmailList {
    public static void main(String[] args){
        String[] ip = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(ip));
    }
    public static int numUniqueEmails(String[] emails) {

        if(emails == null || emails.length == 0){
            return 0;
        }

        Set<String> uniqueEmail = new HashSet<>();

        for (String email:emails){

            String[] nameDomain = email.split("@");
            String name = "";
            for(int i = 0; i< nameDomain[0].length(); i++){
                if(nameDomain[0].charAt(i) == '.'){//ignore this
                    continue;
                }
                if(nameDomain[0].charAt(i) == '+'){//ignore later chars
                    break;
                }

                name += nameDomain[0].charAt(i);
            }

            String cleanedEmail = name+"@"+nameDomain[1];

            if(!uniqueEmail.contains(uniqueEmail)){
                uniqueEmail.add(cleanedEmail);
            }

        }

        return uniqueEmail.size();
    }

    public static int numUniqueEmails2(String[] emails) {

        if(emails == null || emails.length == 0){
            return 0;
        }

        Set<String> uniqueEmail = new HashSet<>();

        for (String email:emails){

            String[] nameDomain = email.split("@");
            String name = "";
            for(int i = 0; i< nameDomain[0].length(); i++){
                if(nameDomain[0].charAt(i) == '.'){//ignore this
                    continue;
                }
                if(nameDomain[0].charAt(i) == '+'){//ignore later chars
                    break;
                }

                name += nameDomain[0].charAt(i);
            }

            String cleanedEmail = name+"@"+nameDomain[1];

            if(!uniqueEmail.contains(uniqueEmail)){
                uniqueEmail.add(cleanedEmail);
            }

        }

        return uniqueEmail.size();
    }
}
