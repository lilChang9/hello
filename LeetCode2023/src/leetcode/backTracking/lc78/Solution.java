package leetcode.backTracking.lc78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0,nums);

        return resList;
    }

    public void backtracking(int start,int[] nums){
        if(start == nums.length){
            return ;
        }

        for(int i = start; i < nums.length; i++){
            res.add(nums[i]);
            List<Integer> temp = new ArrayList<>(res);
            resList.add(temp);
            backtracking(start+1,nums);
            res.removeLast();
        }

        return ;
    }
}
