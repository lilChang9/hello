package leetcode.backTracking.lc491;

import java.util.List;

public class test491 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsequences = solution.findSubsequences(new int[]{-100,-100,0,0,0,100,100,0,0});
        for (List<Integer> subsequence : subsequences) {
            System.out.println(subsequence);
        }
    }
}
