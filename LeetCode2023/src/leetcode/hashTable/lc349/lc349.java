package leetcode.hashTable.lc349;

import java.util.ArrayList;
import java.util.List;

public class lc349 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersection(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.println();
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        /**
         * 设定一个大小为10的数组保存nums1中出现0~9的个数
         * 遍历nums1，将每个数字出现的对应位置++
         * 遍历nums2，并计算当前遍历数字应该处于数组的位置pos
         * 判断inter[pos]是否大于0
         * 如果大于0,inter[pos]对应的数放到交集数组中,inter[pos]--
         * 如果小于等于0，代表nums1中没有出现过这个数，直接continue即可
         */

        List<Integer> res = new ArrayList<>();
        int[] numCount = new int[10];
        int pos;
        for (int i = 0; i < nums1.length; i++) {
            numCount[nums1[i]%10]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            pos = nums2[i]%10;
            if(numCount[pos] > 0){
                res.add(nums2[i]);
                numCount[pos]--;
            }
        }
        return res.stream().distinct().mapToInt(i->i).toArray();
    }
}
