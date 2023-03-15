package leetcode.array.minSubArrayLen;

public class leetcode_209 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7,nums);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        /**
         * 定义slowIndex对数组进行遍历，每次slowIndex作为连续子数组的第一位
         * 定义fastIndex，每次遍历过程开始时初始其值为slowIndex的值
         * 利用fastIndex对数组进行遍历，当sum>=target时，将当前连续子数组的长度与存储的最小长度进行比较
         * 若小于最小长度，则进行替换，否则不进行操作
         */
        int fastIndex;
        int sum;
        int currLen;
        int minLen = 0;
        for (int slowIndex = 0; slowIndex < nums.length; slowIndex++) {
            sum = 0;
            currLen = 0;
            fastIndex = slowIndex;
            while(sum < target && fastIndex < nums.length){
                sum+=nums[fastIndex];
                fastIndex++;
            }
            if(fastIndex == nums.length && sum < target){
            }else {
                currLen = fastIndex - slowIndex;
            }
            if(currLen != 0){
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
