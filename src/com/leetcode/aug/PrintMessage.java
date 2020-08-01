package com.leetcode.aug;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PrintMessage {
    public static void main(String[] args){
        Logger logger = new Logger();

// logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true;

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar"));// returns true;

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
    }
}
class Logger {


    PriorityQueue<Message> pq = new PriorityQueue<Message>();
    public boolean shouldPrintMessage(int timestamp, String message) {
        //clean the pq first;

        while (!pq.isEmpty()){
            Message top = pq.peek();
            if(timestamp - top.timestamp>=10){
                pq.poll();//remove it, we need not remember it
            }else{
                break;
            }
        }

        Message msg = new Message(message, timestamp);
        if(pq.contains(msg)){//we have seen it in last 10 seconds
            return false;
        }else {
            pq.add(msg);//going to print it, so added it
            return true;
        }

    }

    Map<String, Integer> lastSeen = new HashMap<>();
    public boolean shouldPrintMessage2(int timestamp, String message) {
        if (lastSeen.containsKey(message)){
            int lastTime = lastSeen.get(message);
            boolean print =  (timestamp-lastTime) < 10? false: true;
            if(print){
                lastSeen.put(message, timestamp);
            }
            return print;
        }else {
            lastSeen.put(message, timestamp);
            return true;
        }
    }


}

class Message implements Comparable<Message>{
    String message;
    int timestamp;
    Message(String message, int timestamp){
        this.message = message;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Message o) {
       return  (this.timestamp - o.timestamp);
    }

    public int hashCode()  {
        return this.message.length();
    }

    public boolean equals(Object obj)  {
        return ((Message)obj).message.equals(this.message);
    }
    }
