package leetcode.dp.lc416;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canPartition(new int[]{1,5,11,5});
    }

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
        int volumn = sum/2;
        // 每次从nums[0,i]中进行选择,所以创建dp数组dp[nums.length][volumn]
        // dp[i][j]表示背包容量为j的情况下从nums[0,i]中进行选择是否可以将背包装满
        boolean[][] dp = new boolean[nums.length][volumn+1];

        for(int i = 0; i < nums.length; i++){
            // 因为容量为0的背包没有意义，所以直接从j=1开始遍历
            for(int j = 1;j <= volumn; j++){
                // 如果当前遍历的值可以直接装满背包，那么可以直接置为true，进行下一次遍历
                if(nums[i] == j){
                    dp[i][j] = true;
                    continue ;
                }
                if(i == 0){
                    if(nums[i] != j){
                        continue;
                    }
                }
                if(nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[nums.length-1][volumn];
    }

    public static void print(boolean[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
