package leetcode.stackAndQueue.lc347;

import java.util.*;

public class lc347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int[] res = topKFrequent(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        /**
         * 遍历nums，然后将nums的值作为键，出现的次数作为value传入map中
         */
        int[] res = new int[k];
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        list = list.subList(0, k);
        int n = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(list.contains(entry.getValue())){
                res[n] = entry.getKey();
                n++;
            }
        }
        return res;
    }
}
