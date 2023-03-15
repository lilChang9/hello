package leetcode.stackAndQueue.lc239;

import java.util.ArrayList;
import java.util.List;

public class lc239 {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        int[] res = maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 流程正确，但是超时
        /**
         * 遍历nums数组，窗口的每次起始位置定义为i
         * 当遍历到nums.length-k+1时为最后一个窗口
         * 只需要计算第一个滑动窗口的最大值
         */
        int[] res = new int[nums.length-k+1];
        int max = 0;
        for (int i = 0; i <= nums.length-k; i++) {
            // 当i=0时，需要比较窗口中的每个元素得出最大值
            if(i == 0){
                max = nums[0];
                for(int j = 0;j < k;j++){
                    if(nums[j] > max){
                        max = nums[j];
                    }
                }
                res[i] = max;
            }else {
                // 当i!=0时，首先判断窗口的第一个元素的下标-1是否为最大值
                // (1)如果是最大值，那么将当前窗口的最后一个元素与窗口之前的那个元素进行比较
                // 如果比最大值大，那么将最大值设为当前窗口的最后一个元素
                // 如果比最大值小，那么需要遍历窗口得出最大值
                // (2)如果不是最大值，那么将窗口的最后一个元素与最大值做比较
                // 如果比最大值大，那么将最大值设为当前窗口的最后一个元素
                // 如果比最大值小，那么直接得出max不变，进行下一次遍历
                int lastNum = nums[i+k-1];
                if(nums[i-1]==max){
                    if(lastNum >= max){
                        max = lastNum;
                        res[i] = max;
                    }else{
                        max = nums[i];
                        for(int j = i+1 ; j <= i+k-1;j++){
                            if(nums[j] > max){
                                max = nums[j];
                            }
                        }
                        res[i] = max;
                    }
                }else{
                    if(lastNum > max){
                        max = lastNum;
                        res[i] = max;
                    }else{
                        res[i] = max;
                    }
                }
            }
        }
        return res;
    }
}
