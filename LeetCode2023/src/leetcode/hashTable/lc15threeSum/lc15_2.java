package leetcode.hashTable.lc15threeSum;

import java.util.*;

public class lc15_2 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         * 先对数组进行排序
         * 定义两个指针left和right
         * 每次遍历时将left定义为i+1，right为nums.length-1
         * 定义sum=nums[i]+nums[left]+nums[right]
         * 如果sum>0,则right = right - 1;
         * 如果sum<0,则left = left + 1;
         * 当left == right，退出当前循环
         */
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int sum = 0;
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0){
                return resList;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                // 对每次遍历的首元素进行去重，如果当前最左边的元素与它上一个值相等，则肯定存在此结果，直接进行下次遍历即可
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while(right > left){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    resList.add(res);
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;

                }else if(sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return resList;
    }
}
