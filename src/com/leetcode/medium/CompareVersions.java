package com.leetcode.medium;
//If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
public class CompareVersions {

    public static void main(String[] args){
        System.out.println(new CompareVersions().compareVersion("0.1","1.1"));
        System.out.println(new CompareVersions().compareVersion("1.0.1","1"));
        System.out.println(new CompareVersions().compareVersion("7.5.2.4","7.5.3"));
        System.out.println(new CompareVersions().compareVersion("1.01","1.001"));
        System.out.println(new CompareVersions().compareVersion("1.0","1.0.0"));
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null){
            return 0;
        }
    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");
    double multiplyer = ver1.length>ver2.length?Math.pow(10, ver1.length-1):Math.pow(10, ver2.length-1);
    int mul1 = (int)multiplyer, mul2 = (int)multiplyer;
    int verInt1 = 0, verInt2 = 0;
    for (String v: ver1){
        int cur = Integer.parseInt(v);
        verInt1 += (cur*mul1);
        mul1/=10;
    }
    for (String v: ver2){
        int cur = Integer.parseInt(v);
        verInt2 += (cur*mul2);
        mul2/=10;
    }
    return verInt1>verInt2?1:(verInt1<verInt2?-1:0);
}
}
