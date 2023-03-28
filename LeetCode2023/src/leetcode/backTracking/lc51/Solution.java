package leetcode.backTracking.lc51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<String>> resList = new ArrayList<>();
    LinkedList<String> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        // 首先创建一个行列大小都为n的二维数组作为棋盘
        char[][] board = new char[n][n];
        // 对每一行每一列都初始为'.'
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = '.';
            }
        }
        backtracking(board,n,0);
        return resList;
    }

    public void backtracking(char[][] board,int n,int row){
        // 当遍历的行数大于等于n时，收集结果返回
        if(row >= n){
            resList.add(new ArrayList<>(res));
            return ;
        }

        // 对每一次的遍历从0开始，到n-1结束，i代表列数，row代表行数
        for(int i = 0; i < n; i++){
            // 每次放置之前先判断当前位置是否合法，如果合法再进行放置
            if(positionCheck(board,row,i,n)){
                board[row][i] = 'Q';
                res.add(String.valueOf(board[row]));
                backtracking(board,n,row+1);
                board[row][i] = '.';
                res.removeLast();
            }else{
                continue;
            }
        }
    }

    // 判断传入的行列的位置是否合法
    private boolean positionCheck(char[][] board,int row,int col,int n){
        // 列检查
        for(int i = 0; i < n; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // 左斜线检查
        int x = row;
        int y = col;
        // 将当前点先移到左上方
        while(x != 0 && y != 0){
            x--;
            y--;
        }
        while(x!=n-1 && y!=n-1){
            if(board[x][y]=='Q'){
                return false;
            }
            x++;
            y++;
        }

        // 右斜线检查
        x = row;
        y = col;
        // 将当前点先移到右上方
        while(x!=0 && y!=n-1){
            x--;
            y++;
        }
        while(y!=0 && x!=n-1){
            if(board[x][y]=='Q'){
                return false;
            }
            x++;
            y--;
        }

        return true;
    }
}
