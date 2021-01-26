package com.leetcode.medium;

public class LexicographicallySmallestFromLeaf {
    public static void main(String[] args){
        //[2,2,1,null,1,0,null,0]
        TreeNode two_1 = new TreeNode(2);
        TreeNode two_2 = new TreeNode(2);
        TreeNode one_1 = new TreeNode(1);
        TreeNode one_2 = new TreeNode(2);
        TreeNode zero_1 = new TreeNode(0);
        TreeNode zero_2 = new TreeNode(0);
        two_1.left = two_2;
        two_1.right=one_1;
        two_2.right = one_2;
        one_2.left=zero_1;
        one_1.left=zero_2;
        System.out.println(new LexicographicallySmallestFromLeaf().smallestFromLeaf(two_1));
    }
  
    public String smallestFromLeaf(TreeNode cur) {
        StringBuffer res = new StringBuffer();
        getSmallestDFS(cur, new StringBuffer(), res);
        return res.toString();
    }

    private void getSmallestDFS(TreeNode cur, StringBuffer path, StringBuffer res) {//preorder traversal and backtracking. Postorder wont work, explaination below
        if (cur == null){
            return;
        }
        path.append((char)(cur.val+97));
        if (cur.left == null && cur.right == null){//leaf node
            StringBuffer curPath = new StringBuffer(path).reverse();//deep copy and reverse, as we will be backtracking on the same ref
            if (res.length() == 0 || res.compareTo(curPath)>0){
                res.delete(0,res.length());//clear the buffer
                res.append(curPath);
            }
        }

        getSmallestDFS(cur.left, path, res);
        getSmallestDFS(cur.right, path, res);
        path.deleteCharAt(path.length()-1);//backtrack, delete the char we added at this level
    }
    
    

    /*IMP: This logic for post order traversal will fail for inputs like
     [25,1,null,0,0,1,null,null,null,0] Output
             "abz"
    Expected
             "ababz"

     As while coming back we will pick "ab" over "abab" , resulting in the wrong answer abz

     */
 /*   public String smallestFromLeaf(TreeNode cur) {
        if (cur == null){
            return null;
        }
        if (cur.left==null && cur.right == null){//leaf node
            return String.valueOf((char) (cur.val+97));
        }

        String left = smallestFromLeaf(cur.left);
        String right = smallestFromLeaf(cur.right);
       if (left == null || right == null){//return non null value
            return left == null? right+((char)(cur.val+97)): left+((char)(cur.val+97));//both can't be null. Add the current char in the non null value
        }
        //both are non null, return smallest
        //add current char in the strings and see which is bigger AFTER adding the char

        left = left + ((char)(cur.val+97));
        right = right + ((char)(cur.val+97));

        return left.compareTo(right) <=0? left : right;

    }
    */


}
