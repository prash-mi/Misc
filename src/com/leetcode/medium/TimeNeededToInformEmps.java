package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeNeededToInformEmps {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager==null || manager.length == 0){
            return 0;
        }
        //We will do a DFS in the managerToEmpId Map to find a path with max infoTime
        Map<Integer, ArrayList<Integer>> managerToEmpId = getManagerEmpMapping(manager);
        int[] maxTime = {Integer.MIN_VALUE};
        getMaxDFS(managerToEmpId, headID, informTime[headID], maxTime, informTime);

        return maxTime[0];
    }

    void getMaxDFS(Map<Integer, ArrayList<Integer>> managerToEmpId, int curId, int curTimeSum, int[] maxTime, int[] informTime){
        ArrayList<Integer> children = managerToEmpId.getOrDefault(curId, null);
        if (children == null){//leaf node
            maxTime[0] = Math.max(maxTime[0], curTimeSum);//see if we have a bigger time value
            return;
        }

        for (int childId: children){
            //informTime[childId]
            getMaxDFS(managerToEmpId, childId, curTimeSum+informTime[childId], maxTime, informTime);//no need to backtrack on curTimeSum as it's primitive
        }
    }

    private Map<Integer, ArrayList<Integer>> getManagerEmpMapping(int[] manager) {
        Map<Integer, ArrayList<Integer>> managerToEmpId = new HashMap<>();
        for (int i = 0; i<manager.length; i++){
            //manager[i] is the direct manager of the i-th employee
            ArrayList<Integer> emps = managerToEmpId.getOrDefault(manager[i], new ArrayList<Integer>());
            emps.add(i);
            managerToEmpId.put(manager[i], emps);//managerId to employees map
        }
        return managerToEmpId;
    }
}