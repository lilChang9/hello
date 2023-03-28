package leetcode.dp.lc63;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[3][2];
        obstacleGrid[1][0] = 1;
        obstacleGrid[1][1] = 1;
        int i = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 如果入口有障碍物或者出口有障碍物，直接返回0
        if(obstacleGrid[0][0]==1 ||
                obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }

        // 由于存在障碍物，可以先遍历一遍数组把存在障碍物的位置变成-1
        for(int i = 0; i < obstacleGrid.length;i++){
            for(int j = 0; j < obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=-1;
                }
            }
        }
        // 对第一行和第一列进行遍历，如果不等于-1即没有遇到障碍物时就赋值为1
        // 如果碰到障碍物了就直接结束遍历
        for(int i = 0; i < obstacleGrid.length;i++){
            if(obstacleGrid[i][0] != -1){
                obstacleGrid[i][0] = 1;
            }else{
                break;
            }
        }
        for(int j = 0; j < obstacleGrid[0].length;j++){
            if(obstacleGrid[0][j] != -1){
                obstacleGrid[0][j] = 1;
            }else{
                break;
            }
        }
        // 接下来从obstacleGrid[1,1]开始遍历，如果当前值为-1，直接跳过
        // 如果不为-1，则要添加左面和上面不为-1的值
        for(int i = 0; i < obstacleGrid.length;i++){
            for(int j = 0; j < obstacleGrid[i].length;j++){
                if(obstacleGrid[i][j] == -1 || obstacleGrid[i][j] == 1){
                    continue;
                }
                int left = j-1 < 0 || obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1];
                int up =  i-1 < 0 || obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j];
                obstacleGrid[i][j] = left+up;
            }
        }

        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    void print(int[][] arr){
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}