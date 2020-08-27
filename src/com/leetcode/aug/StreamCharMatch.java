package com.leetcode.aug;

import java.util.HashMap;
import java.util.Map;

public class StreamCharMatch {
}

class StreamChecker {
    STNode root = new STNode();
    public StreamChecker(String[] words) {

    }

    public boolean query(char letter) {

        return false;
    }
}

class STNode{
    Map<Character, STNode> chars = new HashMap<>();
    boolean wordEnds = false;
}