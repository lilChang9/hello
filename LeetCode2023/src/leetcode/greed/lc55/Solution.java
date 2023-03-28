package leetcode.greed.lc55;

class Solution {

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        return backtracking(0,nums);
    }

    public boolean backtracking(int start, int[] nums){
        if(start == nums.length-1){
            return true;
        }
        if(start >= nums.length){
            return false;
        }

        // 每一次递归都贪心的跳最多的步数
        // 如果发现不可以就回溯，跳的步数减1
        for(int i = nums[start]; i >= 1; i--){
            if(backtracking(i+start,nums)){
                return true;
            }
        }

        // 如果所有的办法都没有返回true，那么就返回false
        return false;
    }
}
