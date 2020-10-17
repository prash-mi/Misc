package com.leetcode.medium;

import java.util.*;

public class Itinerary {

    /*
    The solution is similar to Eulerian Path
    Algo:

    1> Visit the vertices in lexical order and maintain the order in a callStack
    2> If you hit a dead end then put it in the resultRevOrder, as it will be the last element to visit
    3> Keep popping the elements from callStack and put all the vertices with no new outgoing node in resultRevOrder. Visit the ones with outgoing edges as mentioned in step 1.

     */

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> resultRevOrder = new ArrayList<>();
        Map<String, PriorityQueue<String>> itrGraph = new HashMap<>();
        Stack<String> callStack = new Stack<>();
        if (tickets==null||tickets.size()==0){
            return resultRevOrder;
        }
        for (List<String> ticket:tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (itrGraph.containsKey(from)){//need to store the lexographically sorted one
                itrGraph.get(from).add(to);
            }else{
                PriorityQueue<String> destinations = new PriorityQueue<>((d1,d2) -> d1.compareTo(d2)); //lexographically sorted
                destinations.add(to);
                itrGraph.put(from, destinations);
            }
        }
        // now we have the graph populated, start DFS traversal
        String cur = itrGraph.containsKey("JFK")?"JFK":null;
        while (cur!=null){
            callStack.push(cur);
            PriorityQueue<String> adj = itrGraph.getOrDefault(cur, null);
            if (adj == null){//its a dead end, add it to resultRevOrder and pop it from the stack
                resultRevOrder.add(cur);
                callStack.pop();//cur was the top most element
                cur = callStack.isEmpty()?null:callStack.pop();//start iterating it from the previous value in the stack
            }else {//has adjacent edges, simply get the min value and remove the entry from the map if all the Adj destinations are explored
                String temp = cur;
                cur = adj.poll();//min value in lexical order
                if (adj.isEmpty()){//remove the vertex from the graph as all the adj vertices are traversed
                    itrGraph.remove(temp);
                }
            }
        }
        Collections.reverse(resultRevOrder);
        return resultRevOrder;
    }

}
