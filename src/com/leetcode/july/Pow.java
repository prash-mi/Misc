package com.leetcode.july;

public class Pow {

    public static void main(String[] args){
       // System.out.println(Math.abs(-2147483648));
        System.out.println(myPow(2,-2147483648));
        System.out.println(myPow(2,6));
        System.out.println(myPow(2.10000,3));//9.26100
     System.out.println(myPow(8.84372,-5));

    }

    //calculate x^n in log time
        public static double myPow(double x, int n) {

            if(x == 1 || n ==0){
                return 1;
            }

            long N = Math.abs((long)n);

            double pow = getPowHelper(x, N);

            if(n < 0){
                return (1d/pow);
            }else {
                return pow;
            }

        }

        public static double getPowHelper(double x, long N){
            if (N == 0){
                return 1;
            }

            if (N % 2 == 0){
                double temp = getPowHelper(x, N/2);
                return temp * temp;
            }else{
                return getPowHelper(x, N-1) * x;
            }
        }

   public static double myPow2(double x, int n) {

        if (n == 0 || x == 1) {
            return 1d;
        }
        double m = 1;
        for (long i = 0; i < Math.abs((long)n); i++) {
            m = m * x;
        }
        if (n < 0) {
            return (1d / m);
        } else {
            return m;
        }

    }


    public static double myPow1(double x, int n) {
        int prime = 9973;
        if (n == 0 || x == 1) {
            return 1d;
        }
        double m = 1;
        long absN =  Math.abs((long)n);
        long div = 0, rem = 0;
        if(absN> prime){
            div =  absN/prime;
            rem = absN%prime;

            for (long i = 0; i < prime; i++) {
                m = m * x;
            }
            double temp = 1;
            for (long i = 0; i < div; i++) {
                temp = m * temp; ;
            }
            m = temp;

            double mm = 1;
            for (long i = 0; i < rem; i++) {
                mm = mm * x;
            }

            m = m * mm;

        }else{
            for (long i = 0; i < absN; i++) {

                m = m * x;
            }
        }


        if (n < 0) {
            return (1d / m);
        } else {
            return m;
        }

    }

}
