package leetcode.array.removeElement;

public class leetcode_27 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int res = removeElement(nums, 2);
        System.out.println("res = " + res);
    }

    public static int removeElement(int[] nums, int val) {
        // 初始化两个指针fastIndex和slowIndex都为0
        // (1)当fastIndex指向的数字不为val时:
        // 令slowIndex指向的数变为fastIndex指向的数
        // slowIndex++,fastIndex++
        // (2)当fastIndex指向的数字为val时:
        // slowIndex不动，fastIndex++
        // 当fastIndex为nums.length时,停止循环
        // 新的数组长度应该为slowindex
        int fastIndex = 0;
        int slowIndex = 0;
        while(fastIndex != nums.length){
            if(nums[fastIndex] == val){
                fastIndex++;
            }else {
                nums[slowIndex] = nums[fastIndex];
                fastIndex++;
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
