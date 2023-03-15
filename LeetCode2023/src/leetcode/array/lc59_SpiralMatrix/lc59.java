package leetcode.array.lc59_SpiralMatrix;

public class lc59 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        fillMatrix(matrix,0,0,3,1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 填充组成矩阵的某一圈
     * @param x 初始位置横坐标
     * @param y 初始位置纵坐标
     * @param n 阶数
     */
    public static void fillMatrix(int[][] matrix,int x,int y,int n,int currNum) {
        if (n > 0) {
            if (n == 1) {
                matrix[x][y] = currNum;
                return ;
            }
            // 从左到右
            for (int i = y; i <= y + n - 1; i++) {
                matrix[x][i] = currNum;
                currNum++;
            }
            y = y + n - 1;
            // 从上到下
            for (int i = x + 1; i <= x + n - 1; i++) {
                matrix[i][y] = currNum;
                currNum++;
            }
            x = x + n - 1;
            // 从右到左
            for (int i = y - 1; i >= y - n + 1; i--) {
                matrix[x][i] = currNum;
                currNum++;
            }
            y = y - n + 1;
            // 从下到上
            for (int i = x - 1; i >= x - n + 2; i--) {
                matrix[i][y] = currNum;
                currNum++;
            }
            x = x - n + 1;
            n = n - 2;
            fillMatrix(matrix, x + 1, y + 1, n, currNum);
        }
        return;
    }
}


