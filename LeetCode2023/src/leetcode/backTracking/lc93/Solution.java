package leetcode.backTracking.lc93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<String> resList = new ArrayList<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(0,1,s);

        return resList;
    }

    public void backtracking(int start,int step,String s){
        // 如果start大于等于s.length(),判断结果是否合法，如果合法，收集并返回
        if(res.size() == 4){
            if(start < s.length()){
                return ;
            }else {
                String temp = "";
                for(int i = 0; i < res.size();i++){
                    temp += res.get(i);
                    if(i != res.size()-1){
                        temp += ".";
                    }
                }
                resList.add(temp);
                return ;
            }
        }

        for(int i = start; i + step <= s.length() && step <= 3;step++){
            String currStr = s.substring(start,start+step);

            // 首先判断第一个字符是否为0，如果为0，直接continue
            if(currStr.length() > 1){
                if(currStr.charAt(0) == '0'){
                    continue;
                }
            }

            // 如果切割后的字符串长度小于3，不用判断直接进入下一层递归
            if(step < 3){
                res.add(currStr);
                backtracking(start+step,1,s);
                res.removeLast();
                continue;
            }
            if(step == 3){
                // 如果切割的字符串长度等于3，
                // 如果第一个字符不为0，将其转为Integer类型，并与255做比较
                if(Integer.parseInt(currStr) <= 255){
                    res.add(currStr);
                    backtracking(start+step,1,s);
                    res.removeLast();
                }else{
                    continue;
                }
            }
        }

        return ;
    }
}
