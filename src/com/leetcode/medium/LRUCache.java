package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//LRU Cache get and put operations in O(1) Time
public class LRUCache {
    public static void main(String[] args){
        //["LRUCache","put","get","put","get","get"]
        //[[1],[2,1],[2],[3,2],[2],[3]]
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1);
        System.out.println(lRUCache.get(2));//1
        lRUCache.put(3, 2);
        System.out.println(lRUCache.get(2));//-1
        System.out.println(lRUCache.get(3));//2
    }

    class DoublyLinkedListNode{
        DoublyLinkedListNode prev, next;
        int key, val;
        DoublyLinkedListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private final int capacity;
    private int curCapacity = 0;
    private Map<Integer, DoublyLinkedListNode> values = new HashMap<>();
    DoublyLinkedListNode head = new DoublyLinkedListNode(-1, -1), tail = new DoublyLinkedListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if (!values.containsKey(key)){
            return -1;
        }
        //move the value to the top of the Dequeue
        DoublyLinkedListNode cur = values.get(key);
        remove(cur);
        addFirst(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (values.containsKey(key)){//update it
            DoublyLinkedListNode cur = values.get(key);
            remove(cur);
            cur.val=value;//updated value
            addFirst(cur);
            values.put(key, cur);
        }else {//check if we are hitting the capacity
            if (curCapacity == capacity){//we will remove the least recently used element and the current element. so that capacity doesn't change
                int lastKey =  getLastKeyAndRemoveLast();
                values.remove(lastKey);
                DoublyLinkedListNode cur = new DoublyLinkedListNode(key, value);
                addFirst(cur);
                values.put(key, cur);
            }else {//simply add it.
                DoublyLinkedListNode cur = new DoublyLinkedListNode(key, value);
                addFirst(cur);
                values.put(key, cur);
                curCapacity++;
            }

        }
    }

    private int getLastKeyAndRemoveLast() {
        int lastKey = tail.prev == null?-1: tail.prev.key;
        if(tail.prev!= null){
            remove(tail.prev);
        }
        return lastKey;
    }

    private void addFirst(DoublyLinkedListNode cur){
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
    private void remove(DoublyLinkedListNode cur){
        cur.prev.next=cur.next;
        cur.next.prev = cur.prev;
        cur.next=null;
        cur.prev=null;
    }
}