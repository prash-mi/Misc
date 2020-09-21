package com.leetcode.medium;

public class BrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println( browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println( browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }


    class DQueue{
        String curUrl;
        DQueue next, prev;
        DQueue(String curUrl){
            this.curUrl=curUrl;
        }
    }

    private DQueue cur=null;//, last=null;
    public BrowserHistory(String homepage) {
       cur = new DQueue(homepage);
      // last=cur;
    }

    public void visit(String url) {
        //delete the forward history
        cur.next = new DQueue(url);
        cur.next.prev=cur;
        cur = cur.next;
       // last = cur;
    }

    public String back(int steps) {
        while (cur.prev!=null && steps>0){
                cur=cur.prev;
                steps--;
        }
        return cur.curUrl;
    }

    public String forward(int steps) {
        while (cur.next!=null&&steps>0){
            cur=cur.next;
            steps--;
        }
        return cur.curUrl;
    }
}