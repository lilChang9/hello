package leetcode.hashTable.lc350;

import java.util.ArrayList;
import java.util.List;

public class lc350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect(nums1,nums2);

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        int max1 = -1;
        int max2 = -1;
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i] > max1){
                max1 = nums1[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(nums2[i] > max2){
                max2 = nums2[i];
            }
        }
        int[] numCount;
        if(max1 > max2){
            numCount  = new int[max1];
        }else {
            numCount = new int[max2];
        }
        for (int i = 0; i < nums1.length; i++) {
            numCount[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if(numCount[nums2[i]]>0){
                resList.add(nums2[i]);
                numCount[nums2[i]]--;
            }
        }
        int[] res = resList.stream().mapToInt(x -> x).toArray();
        return res;
    }
}
