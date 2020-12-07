package com.leetcode.medium;

public class SortColors {
    public void sortColors(int[] colors) {
        if(colors == null || colors.length<=1){
            return;
        }

        int cur = 0, left = 0, right = colors.length-1;
        //elements towards the left of left will be 0
        //elements towards left of cur will either be 0 or 1, as we will be shifting all the 2s before we move right
        //elements towards right of right will be 2 always

        while (cur<=right){
            if (colors[cur] == 0){//swap with left
                colors[cur] = colors[left];
                colors[left] = 0;
                left++;//as anything before this is 0
                cur++;//anything before this is 0 or 1 , 2s are already shifted to right, hence we can move to right
            }else if (colors[cur] == 1){
                cur++;//simply move right as this will arrange 1s in middle
            }else if (colors[cur] == 2){
                colors[cur] = colors[right];
                colors[right] = 2;
                right--;//anything right of this is 2
                //IMP - we are not doing cur++ at this place, as we might have swapped a 0 or a 1 from right, which will be adjusted in it's correct place in the next iteration
            }
        }

    }
}
