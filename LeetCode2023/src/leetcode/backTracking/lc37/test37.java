package leetcode.backTracking.lc37;

public class test37 {
    public static void main(String[] args) {
        char[][] boards = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        Solution solution = new Solution();
        solution.solveSudoku(boards);
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards.length; j++) {
                System.out.print(boards[i][j] + " ");
            }
            System.out.println();
        }
    }
}
