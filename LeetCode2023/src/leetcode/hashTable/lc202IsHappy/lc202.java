package leetcode.hashTable.lc202IsHappy;

import java.util.HashSet;

public class lc202 {

    public static void main(String[] args) {
        isHappy(19);
    }

    public static boolean isHappy(int n) {
        /**
         * 定义一个集合hashSet存放sum和来判断是否有重复值出现，若有则返回false
         * 定义一个长度为数字长度的数组存放数字的各位数字
         * 每次通过遍历数组求sum，若sum==1，返回true，否则继续执行
         */

        HashSet<Integer> sumSet = new HashSet<>();
        sumSet.add(n);
        int sum = n;
        int i = 1;
        int quotient = n;
        while(sum != 1){
            String numStr = sum + "";
            int[] digits = new int[numStr.length()];
            i = 1;
            while(quotient!=0){
                int remainder = quotient % 10;
                quotient = quotient / 10;
                digits[numStr.length()-i] = remainder;
                i++;
            }
            // 先对sum清零
            sum = 0;
            // 遍历digits数组对sum求和
            int index = 0;
            while(index < digits.length){
                sum+=(digits[index] * digits[index]);
                index++;
            }
            // 判断sumSet中是否存在当前sum，如果存在则会产生无限循环，返回false
            if(sumSet.contains(sum)){
                return false;
            }
            quotient = sum;
            sumSet.add(sum);
        }
        return true;
    }
}
