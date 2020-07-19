package com.leetcode.july;

import java.util.*;

/*

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
             Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 */
public class CourseScheduler2 {
    public static void main(String[] args){
    int[][] ip = {{1,0},{2,0},{3,1},{3,2}};
        int[][] ip2 = {{1,0},{2,1},{3,2}};// 0 <- 1 <- 2 <- 3
   int[] topSort =  new CourseScheduler2().findOrder(4, ip2);

   for (int i: topSort){
       System.out.print(i+" ");
   }
    }

    
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        Map<Integer, GNode> vertices= new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            vertices.put(i, new GNode(i));
        }
        //create a graph first
        for(int[] course:prerequisites){
            GNode c1, c2;
            if(vertices.containsKey(course[0])){
                c1 = vertices.get(course[0]);
            }else{
                c1 = new GNode(course[0]);
                vertices.put(course[0], c1);
            }

            if(vertices.containsKey(course[1])){
                c2 = vertices.get(course[1]);
            }else{
                c2 = new GNode(course[1]);
                vertices.put(course[1], c2);
            }

            c1.dependences.add(c2);// for the pair [c1, c2] c2 should be complete before C1
        }

        //start from any node in the graph and do a DFS to get a topological sort, break if a cycle is found

        List<Integer> topOrder = new ArrayList<Integer>();
        Set<GNode> seen = new HashSet<>();
        int[] courseOrder = {};
        for(Integer courseId: vertices.keySet()){
            if(!findOrderDFS(topOrder, vertices.get(courseId),seen, new HashSet<>())){//found cycle
                return courseOrder;//returning empty order
            }
        }

        if(topOrder.size() == vertices.size()){//got a topological sort
            courseOrder = new int[topOrder.size()];
            for (int i= 0; i< courseOrder.length; i++){
                courseOrder[i] = topOrder.get(i);
            }
            return courseOrder;
        }else{
            return courseOrder;
        }
    }

    boolean findOrderDFS(List<Integer> topOrder,GNode cur, Set<GNode> seen,  Set<GNode> graySet){

        if (graySet.contains(cur)){//graph has a cycle
            return false;//has cycle
        }

        if(seen.contains(cur)){
            return true;
        }else{
            seen.add(cur);
        }

        graySet.add(cur);//cur is being explored
        for(GNode child: cur.dependences){
           if(!findOrderDFS(topOrder, child, seen, graySet)){//found cycle
               return false;
           }
        }
        graySet.remove(cur);
        //all the children of cur are now explored, add cur to the stack
        topOrder.add(cur.courseId); // it's dependences are explored add this
        return true;
    }

}

class GNode{
    int courseId;
    List<GNode> dependences = new ArrayList<>();

    GNode(int courseId){
        this.courseId = courseId;
    }
    @Override
    public int hashCode() {
        return this.courseId;
    }
    @Override
    public boolean equals(Object obj){
        return ((GNode)obj).courseId == this.courseId;
    }

    }