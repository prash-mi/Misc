package com.leetcode.medium;

public class PickRandomWeights {

    public static void main(String[] args){
        int[] ip = {1,3};
        PickRandomWeights p = new PickRandomWeights(ip);
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
    }

    int totalWeight = 0;
    int[] runningWeights;
    public PickRandomWeights(int[] weights) {
        runningWeights = new int[weights.length];
        for (int i = 0; i < weights.length; i++){
            totalWeight += weights[i];
            runningWeights[i] = totalWeight;
        }
    }
    public int pickIndex() {
        double rand = (totalWeight*Math.random());
        int left = 0, right= runningWeights.length-1;
        //binary search the index where rand belongs to. The analogy is that runningWeights are in a line and then we are randomly throwing a ball on the line. The higher weight the higher the probability
        while(left < right){
            int mid = left + (right-left)/2;
            if (runningWeights[mid] < rand){
                left = mid+1;
            }else{
                right = mid;//IMPORTANT
            }
        }
        return left;
    }
  /*
   //This logic times out at 56/57th testcase
   class Range{
        double start, end;
        public Range(double start, double end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int hashCode()
        {
            return 0;//always go to equals
        }
        @Override
        public boolean equals(Object obj)
        {
            Range r = (Range)obj;
            return this.start>=r.start && this.end < r.end;
        }
    }

    private int[] weights;
    Map<Range, Integer> rangeIndex = new HashMap<>();
    double runningWeight = 0;
    public PickRandomWeights(int[] weights) {
        this.weights = weights;
        for (int i =0; i < weights.length; i++){
            double start = runningWeight;
            runningWeight += weights[i];
            rangeIndex.put(new Range(start, runningWeight), i);
        }
    }
Range temp = new Range(0, 0);
    public int pickIndex() {
        double rand = Math.random()*runningWeight;
        temp.start=rand;
        temp.end=rand;
        return rangeIndex.getOrDefault(temp, -1);
    }*/
}
