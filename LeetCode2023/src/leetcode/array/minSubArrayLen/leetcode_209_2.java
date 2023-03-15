package leetcode.array.minSubArrayLen;

public class leetcode_209_2 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7,nums);
    }


    public static int minSubArrayLen(int target, int[] nums) {
        /**
         * 定义一个slowIndex,每次作为连续子数组的第一个元素的下标
         * 定义一个fastIndex,初始为0,接下来的每次遍历都初始为上一次得到的满足条件的连续子数组的最后一个元素的下标
         * 如果sum >= target,slowIndex++,sum-=nums[slowIndex-1],currLen--
         * 如果sum < target,fastIndex++;sum+=nums[fastIndex];currLen++
         */
        int fastIndex = 0;
        int sum = 0;
        int currLen = 0;
        int minLen = 0;
        for(int slowIndex=0; slowIndex < nums.length; slowIndex++){
            if(slowIndex == 0){
                sum = 0;
            }else {
                sum -= nums[slowIndex-1];
            }
            while(sum < target && fastIndex != nums.length){
                sum+=nums[fastIndex];
                fastIndex++;
            }
            if(sum < target && fastIndex == nums.length){
                return minLen;
            }else {
                currLen = fastIndex - slowIndex;
                if(minLen != 0){
                    if(currLen < minLen){
                        minLen = currLen;
                    }
                }else {
                    minLen = currLen;
                }
            }
        }
        return minLen;
    }
}
