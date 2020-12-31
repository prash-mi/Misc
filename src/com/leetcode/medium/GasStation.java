package com.leetcode.medium;

public class  GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0, surplusGas=0, deficitGas = 0;
        for (int i=0; i < gas.length; i++){
            surplusGas += (gas[i] - cost[i]);
            if (surplusGas<0){//cant reach the next gas station, so the start would be the next node
                deficitGas += surplusGas;
                surplusGas=0;
                start = i+1 < gas.length?i+1: -1;
            }
        }
        return (surplusGas+deficitGas) >=0? start: -1;//if there is no deficit of gas then there is a solution, else return -1
    }
}
