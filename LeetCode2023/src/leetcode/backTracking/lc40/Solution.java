package leetcode.backTracking.lc40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();
    int currSum = 0;
    boolean flag = false;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 首先对candidates数组进行排序
        Arrays.sort(candidates);

        if(candidates[0] > target){
            return resList;
        }

        backtracking(0,candidates,target);

        return resList;
    }

    private void backtracking(int start,int[] candidates,int target){
        if(currSum == target){
            resList.add(new ArrayList<>(res));
            return ;
        }


        for(int i = start; i < candidates.length && currSum + candidates[i] <= target;i++){
            if(i > 0 && candidates[i] == candidates[i-1] && flag){
                 continue;
            }
            res.add(candidates[i]);
            currSum += candidates[i];
            backtracking(i+1,candidates,target);
            res.removeLast();
            if(res.size() == 0){
                // 当res数组第一次清零的时候，证明第一轮的遍历已经结束了
                flag = true;
            }
            currSum -= candidates[i];
        }

        return ;
    }
}
