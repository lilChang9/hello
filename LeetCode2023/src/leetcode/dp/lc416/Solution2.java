package leetcode.dp.lc416;

public class Solution2 {

    // 将二维dp数组优化为一维dp数组
    public boolean canPartition(int[] nums) {
        // 先对nums求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果nums为奇数，那么一定无法分割为两个相同的子集
        if(sum % 2 != 0){
            return false;
        }

        // 求分割成两个和相同的子集，将背包的大小设置为sum/2
        int target = sum/2;

        boolean[] dp = new boolean[target+1];

        for(int i = 0; i < nums.length; i++){
            for (int j = target; j >= 1;j--){
                if(j == nums[i]){
                    dp[j] = true;
                }
                if(i == 0){
                    continue;
                }
                if(nums[i] <= j){
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
                if(j == target && dp[j]){
                    return true;
                }
            }
        }

        return dp[target];
    }
}
