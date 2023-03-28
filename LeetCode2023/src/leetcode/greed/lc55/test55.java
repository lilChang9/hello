package leetcode.greed.lc55;

public class test55 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean backtracking = solution.backtracking(0, new int[]{2, 0});
        System.out.println(backtracking);
    }
}
