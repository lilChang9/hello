package leetcode.backTracking.lc51;

import java.util.List;

public class test51 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println(list);
        }
        System.out.println(lists.size());
    }
}
