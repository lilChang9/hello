package leetcode.backTracking.lc47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();
    int[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 用长度为nums.length的数组标记此位置的数是否使用过
        // 0表示未使用，1表示使用过
        used = new int[nums.length];

        Arrays.sort(nums);

        backtracking(nums);

        return resList;
    }

    public void backtracking(int[] nums){
        if(res.size() == nums.length){
            resList.add(new ArrayList<>(res));
            return ;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == 0){
                continue;
            }
            // 首先判断当前位置是否使用过
            if(used[i] == 0){
                res.add(nums[i]);
                used[i] = 1;
                backtracking(nums);
                res.removeLast();
                used[i] = 0;
            }else if (used[i] == 1){
                continue;
            }
        }

        return ;
    }
}
