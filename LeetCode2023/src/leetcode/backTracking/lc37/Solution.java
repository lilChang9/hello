package leetcode.backTracking.lc37;

class Solution {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    private boolean backtracking(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9';k++){
                        if(used(board,i,j,Character.getNumericValue(k))){
                            board[i][j] = k;
                            if(backtracking(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean used(char[][] board,int row,int col,int val){
        // 行检查
        for(int j = 0; j < 9;j++){
            if(board[row][j] != '.'){
                int num = Character.getNumericValue(board[row][j]);
                if(val == num){
                    return false;
                }
            }
        }

        // 列检查
        for(int i = 0; i < 9;i++){
            if(board[i][col] != '.'){
                int num = Character.getNumericValue(board[i][col]);
                if(val == num){
                    return false;
                }
            }
        }

        // 所在宫格检查
        int xStep = row/3;
        int yStep = col/3;
        for(int i = xStep*3; i < xStep*3+3;i++){
            for(int j = yStep*3; j < yStep*3+3;j++){
                if(board[i][j] != '.'){
                    int num = Character.getNumericValue(board[i][j]);
                    if(val == num){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
