package leetcode.backTracking.lc491;

import java.util.*;

class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(0,nums);

        return resList;
    }

    public void backtracking(int start,int[] nums){
        if(res.size() > 1){
            resList.add(new ArrayList<>(res));
        }

        if(start >= nums.length){
            return;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = start; i < nums.length;i++){
            if(i > start && res.size() != 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(list.contains(nums[i])){
                continue;
            }
            // 当前结果集不为空，则需要判断当前值是否大于等于结果集的最后一个值
            if(res.size()==0 || nums[i] >= res.get(res.size()-1)){
                res.add(nums[i]);
                list.add(nums[i]);
                backtracking(i+1,nums);
                res.removeLast();
            }else{
                continue;
            }

        }
        return ;
    }
}
