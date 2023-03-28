package leetcode.greed.lc376;

class Solution {

    int count = 0;
    // lastIndex表示上一个有效的数字
    int lastIndex = 0;
    // 用一个标志位标记当前需要的差值是正数还是负数
    // true表示需要正数，false表示需要负数
    boolean flag = false;

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1 || nums.length == 0){
            return nums.length;
        }
        // 如果要求摆动序列，就要求波峰和波谷之间不能存在其他的数字
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                count++;
                continue;
            }
            // 如果lastIndex==0，证明还没有找到下一个差值需要正数还是负数
            if(lastIndex == 0){
                // 如果找波峰，就找最大的波峰
                // 如果找波谷，就找最小的波谷
                if(nums[i] == nums[lastIndex]){
                    continue;
                }else if(nums[i] > nums[lastIndex]){
                    if(i < nums.length-1 && nums[i+1] > nums[i]){
                        continue;
                    }
                    lastIndex = i;
                    count++;
                    flag = false;
                }else{
                    if(i < nums.length-1 && nums[i+1] < nums[i]){
                        continue;
                    }
                    lastIndex = i;
                    count++;
                    flag = true;
                }
            }else{
                if(nums[i] > nums[lastIndex] && flag){
                    if(i < nums.length-1 && nums[i+1] > nums[i]){
                        continue;
                    }
                    count++;
                    flag = false;
                    lastIndex = i;
                }else if(nums[i] < nums[lastIndex] && !flag){
                    if(i < nums.length-1 && nums[i+1] < nums[i]){
                        continue;
                    }
                    count++;
                    flag = true;
                    lastIndex = i;
                }else{
                    continue;
                }
            }
        }
        return count;
    }
}