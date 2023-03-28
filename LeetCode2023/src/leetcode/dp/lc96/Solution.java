package leetcode.dp.lc96;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i = 1; i <= 10;i++){
            System.out.println(solution.numTrees(i));
        }
    }

    public int numTrees(int n) {
        // 初始化dp数组，dp[i]表示i个节点能表示的二叉搜索子树的个数
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // 从2到n进行遍历，1和0已经初始化好了
        for(int i = 2; i <= n; i++){
            // 每次要遍历1到i,即选择谁当根节点
            System.out.println("=========="+i+"============");
            for(int j = 1; j <=i ; j++){
                // 左子树的节点个数为j-1
                // 右子树的节点个数为i-j
                int leftNodes = j-1;
                int rightNodes = i-j;
                // 通过dp数组得到左子树节点的可能性和右子树节点的可能性
                // 并与当前的可能性相加
                dp[i] = dp[i] + (dp[leftNodes] * dp[rightNodes]);
                System.out.println(Arrays.toString(dp));
            }

        }
        return dp[n];
    }
}
