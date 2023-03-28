package leetcode.backTracking.lc131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<String>> resList = new ArrayList<>();
    LinkedList<String> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(0,1,s);

        return resList;
    }

    private void backtracking(int start,int step,String s){
        // start表明字符串开始分割的位置
        // step代表步长，表示当前应该分割几位
        // 当step为1时，肯定符合条件，直接加入res集中
        if(start >= s.length()){
            // 当起始位置已经超出字符串的索引
            // 收集结果，返回
            resList.add(res);
            return;
        }

        for(int i = start; i+step <= s.length(); step++){
            // 将起始位置为start，末位为start+step的字符串进行切割
            String curStr = s.substring(start,start+step);
            // 判断切割完成的字符串是否为回文串
            if(isPalindromic(curStr)){
                // 如果是回文串，添加到结果集并进行下一层递归
                res.add(curStr);
                backtracking(start+step,1,s);
                res.removeLast();
            }else{
                continue;
            }
        }

        return;
    }

    // 判断分割后的字符串是否为回文串
    private boolean isPalindromic(String s){
        if(s.length() == 1){
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
