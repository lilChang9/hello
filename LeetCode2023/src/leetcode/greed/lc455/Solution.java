package leetcode.greed.lc455;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        int children = solution.findContentChildren(g, s);
        System.out.println(children);
    }



    public int findContentChildren(int[] g, int[] s) {
        // 对饼干和胃口都进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = 0;
        for(int i = 0; i < s.length && start < g.length; i++){
            if(s[i] >= g[start]){
                start++;
                count++;
            }
        }
        return count;
    }
}
