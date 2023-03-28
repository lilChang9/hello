package leetcode.dp.lc343;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.integerBreak(58);
        System.out.println(i);
    }

    public int integerBreak(int n) {
        // 创建一个大小为n+1的dp数组
        // 其中dp[i]表示i这个数拆分后的最大乘积
        int[] dp = new int[n+1];
        // 初始化dp[1]=1
        dp[1] = 1;
        // 从2开始遍历
        for(int i = 2; i <= n;i++){
            // 每次将当前遍历的数拆为两个数
            for(int j = 1; j <= i-1;j++){
                if(j > i-j){
                    // 如果j大于i-j就退出
                    // 因为3可以分为1、2也可以分为2、1，但他们的乘积是一样的
                    break;
                }
                // 当前的数会被分成两个数,一个数为j，一个数为i-j
                // 判断这两个数是否能通过拆分得到更大的值，如果不能就取当前数为乘数
                int factor1;
                int factor2;
                if(j > dp[j]){
                    factor1 = j;
                }else{
                    factor1 = dp[j];
                }
                if(i-j > dp[i-j]){
                    factor2 = i-j;
                }else{
                    factor2 = dp[i-j];
                }
                int currMulti = factor1 * factor2;
                if(currMulti > dp[i]){
                    dp[i] = currMulti;
                }
                System.out.println(Arrays.toString(dp));
            }
        }

        return dp[n];
    }
}
