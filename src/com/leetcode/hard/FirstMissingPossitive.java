package com.leetcode.hard;

//https://leetcode.com/problems/first-missing-positive/solution/
public class FirstMissingPossitive {
//[3,4,-1,1]
    public static void main(String[] args){
    int[] nums1 = {7,8,9,11,12};
        int[] nums2 = {-1,-2};
    System.out.println(new FirstMissingPossitive().firstMissingPositive(nums2));

    }

    /*
    Find the min positive number by iterating
    replace all the numbers > nums.length and negative numbers with the number found at he above step (we dont care about these numbers, so just invalidate those)
    now we have an array with of length n, with numbers from 1 to n. Use it as a set if flipping the sign (similar to aug/FindDuplicates and easy/DisappearedNumbers
     */
    public int firstMissingPositive(int[] nums) {

        //Special case
        if(nums.length == 1 && nums[0] == 1){
            return 2;
        }else if(nums.length == 1 && nums[0] != 1){
            return 1;
        }

        int randomPositive = -1;//un initialized number
        for (int i: nums){
            if (i>0 && i <= nums.length){
                randomPositive = i;//set it with any positive number which occurs in the array
                break;
            }
        }

        if (randomPositive == -1){//randomPositive wasn't set, so set it with the max possible number (we need to find min positive, so this approach wont cause any issue)
            randomPositive = nums.length;
        }

        for (int i = 0; i< nums.length; i++){
            if (nums[i]<1 || nums[i] > nums.length){
                nums[i] = randomPositive;//invalidating the indexes which were either negative or more than the size of the array. as Min positive will always lie from 1 to n
            }
        }

        for (int i = 0; i< nums.length; i++){//mark the indexes which we already seeing
            int ind = Math.abs(nums[i])-1;
            if(nums[ind]>0){
                nums[ind] *= -1;//seen it
            }
        }

        //now use the nums array as set

        for (int i = 1; i <= nums.length; i++){//start from 1 and find the first index which we didn't see
            int ind = i-1;
            if (nums[ind]>0){//we didn't see this element
                return i;
            }
        }

        return nums.length+1;//its the case when input is like {1,2,3}. We have seen everything so the solution is the next positive number
    }
}
