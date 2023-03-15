package leetcode.hashTable.lc15threeSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         * 首先将数组所有的元素保存到一个hashMap中，
         * hashMap的键为数字，值为存放这个数字的所有位置
         * 两层for循环遍历所有元素，并保证i不等于j
         * 求两个元素之和，并将0-sum作为target，找map中是否存在target值
         * 若不存在，则进行下一次循环
         * 若存在，还要判断List中存放的数字是否和i或j相等
         * 若不相等则count++
         * 若相等，继续遍历List
         */
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int sum = 0;
        int target = 0;
        boolean flag = false;
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                map.put(nums[i],positions);
            }else {
                List<Integer> positions = map.get(nums[i]);
                positions.add(i);
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                target = 0 - sum;
                if(!map.containsKey(target)){
                    continue;
                }else {
                    // 获取与目标值相等的值的所有位置
                    List<Integer> positionList = map.get(target);
                    for(int position : positionList){
                        // position > j的原因是为了保证不重复，大于j的同时就已经保证了大于i并且与i和j不相等
                        if(position > j){
                            List res = new ArrayList<>();
                            // 收集结果
                            res.add(nums[i]);
                            res.add(nums[j]);
                            res.add(nums[position]);
                            Collections.sort(res);
                            for (List<Integer> temp : resList) {
                                if(temp.equals(res)){
                                    // flag表示resList中是否存在相同的res
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag){
                                resList.add(res);
                            }
                            flag = false;
                        }
                    }
                }
            }
        }
        return resList;
    }
}
