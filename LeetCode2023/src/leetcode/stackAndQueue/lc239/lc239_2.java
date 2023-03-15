package leetcode.stackAndQueue.lc239;

import java.util.ArrayDeque;

public class lc239_2 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        lc239_2 lc = new lc239_2();
        int[] res = lc.maxSlidingWindow(nums, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 维护一个双端队列，存储每次滑动窗口中可能为最大值的元素
         */
        myDeque deque = new myDeque();
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            if(i == 0){
                for(int j = 0;j < k;j++){
                    deque.push(nums[j]);
                }
                res[0] = deque.maxValue();
                continue;
            }
            deque.pop(nums[i-1]);
            deque.push(nums[i+k-1]);
            res[i] = deque.maxValue();
        }
        return res;
    }

    public class myDeque{

        private ArrayDeque<Integer> deque;

        public myDeque(){
            deque = new ArrayDeque<>();
        }

        public void push(int x){
            while(!deque.isEmpty()&& x > deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(x);
        }

        public void pop(int x){
            if(x != deque.peekFirst()){
                return;
            }else {
                deque.pollFirst();
            }
        }

        public int maxValue(){
            return deque.peekFirst();
        }


    }
}
