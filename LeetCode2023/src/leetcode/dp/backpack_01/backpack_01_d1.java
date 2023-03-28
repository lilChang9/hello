package leetcode.dp.backpack_01;

import java.util.Arrays;
import java.util.Scanner;

public class backpack_01_d1 {
    public static void main(String[] args) {
        /**
         * 将01背包求解的dp数组从二维降到一维的优化
         */
        Scanner scanner = new Scanner(System.in);
        // 编号
        int serialNum = scanner.nextInt();
        // 体积
        int volumn = scanner.nextInt();

        int[] dp = new int[volumn+1];

        int[] values = new int[serialNum+1];
        int[] volumns = new int[serialNum+1];

        for(int i = 1; i <= serialNum; i++) {
            // 每次读取v，w 分别表示第i件物品的体积和价值
            volumns[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        for(int i = 1; i <= serialNum;i++){
            System.out.println("==========="+i+"===========");
            for(int j = volumn; j >= 1; j--){
                // i表示当前的编号
                // j表示当前的容量
                if(j < volumns[i]){
                    // 如果当前的容量装不下，就不需要改变值，直接continue
                    continue;
                }else {
                    // 如果当前的容量装的下，就将当前遍历编号的value值与剩余容量的最大价值进行相加与之前的做对比
                    dp[j] = Math.max(dp[j], dp[j - volumns[i]] + values[i]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[volumn]);
    }
}
