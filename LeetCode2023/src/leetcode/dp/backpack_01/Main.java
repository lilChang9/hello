package leetcode.dp.backpack_01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 编号
		int serialNum = scanner.nextInt();
		// 体积
		int volumn = scanner.nextInt();
		
		int[][] dp = new int[serialNum+1][volumn+1];
		
		int[] values = new int[serialNum+1];
		int[] volumns = new int[serialNum+1];
		
		for(int i = 1; i <= serialNum; i++) {
			// 每次读取v，w 分别表示第i件物品的体积和价值
			volumns[i] = scanner.nextInt();
			values[i] = scanner.nextInt();
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[i].length;j++) {
				System.out.println("====================");
				// 每一次选择都是放或不放两个选择
				// 每次取放或不放中的最大值
				// 如果当前容量大于等于当前编号物品的容量，可以放
				if(j >= volumns[i]){
					dp[i][j] = Math.max(dp[i-1][j], values[i]+dp[i-1][j-volumns[i]]);
				}else{
					dp[i][j] = dp[i-1][j];
				}
				print(dp);
			}
		}
		System.out.println(dp[serialNum][volumn]);
		
	}

	public static void print(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
		
}