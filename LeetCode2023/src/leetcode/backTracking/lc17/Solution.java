package leetcode.backTracking.lc17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    List<String> resList = new ArrayList<>();
    Map<Integer,String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return resList;
        }

        // 首先要建立数字与字母之间的映射，可以用Map进行存放
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        char[] currStr = new char[digits.length()];
        Integer[] numDigits = new Integer[digits.length()];
        // 传进来的字符串可以按位进行切割转换成单数并存放进数组
        for(int i = 0; i<digits.length();i++){
            numDigits[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }

        backtracking(0,currStr,0,numDigits);

        return resList;
    }

    private void backtracking(int start,char[] currStr,int curlen,Integer[] numDigits){
        if(curlen == numDigits.length){
            resList.add(String.valueOf(currStr));
            return ;
        }

        // 当前长度大于等于存放字符数组的长度，直接返回
        if(curlen >= currStr.length){
            return ;
        }

        // 根据当前数字的值得到该遍历的字符串
        String str = map.get(numDigits[start]);
        for(int i = 0;i < str.length();i++){
            currStr[curlen++] = str.charAt(i);
            backtracking(start+1,currStr,curlen,numDigits);
            curlen--;
        }

        return ;
    }
}
