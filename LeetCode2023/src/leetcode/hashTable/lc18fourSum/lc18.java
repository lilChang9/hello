package leetcode.hashTable.lc18fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc18 {
    public static void main(String[] args) {
        int[] nums = {2,-4,-5,-2,-3,-5,0,4,-2};
        List<List<Integer>> res = fourSum(nums, -14);
        System.out.println(res);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * 首先将数组排序
         * 定义i遍历数组
         * 在每次遍历中定义j，初始化为i+1，遍历数组
         */
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > target && nums[i] > 0){
                return resList;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1;j < nums.length;j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length-1;
                while(left < right){
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else {
                        // sum与target相等,收集结果
                        resList.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[right] == nums[right-1] ){
                            right--;
                        }
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return resList;
    }
}
