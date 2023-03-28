package leetcode.backTracking.lc77;

import java.util.*;

class Solution {

    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();



    public List<List<Integer>> combine(int n, int k) {
        String temp = "sadajsiod";
        temp.getBytes();
        for(int i = 1; i <= n-k+1 ; i++){
            res.add(i);
            backtracking(i+1,n,k);
            res.removeLast();
        }
        return resList;
    }

    public void backtracking(int start,int n,int k){
        // 如果当前结果集的大小等于k，收集结果并返回
        if(res.size() == k){
            resList.add(new ArrayList<>(res));
            return ;
        }
        // 如果当前结果集的大小小于k，则遍历当前所有的选择
        for(int i = start; i <= n; i++){
            res.add(i);
            backtracking(i+1,n,k);
            res.removeLast();
        }
        return;
    }
}