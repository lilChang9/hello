package leetcode.array.leetcode_904;

public class leetcode_904 {

    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        int res = totalFruit(fruits);
        System.out.println("res = " + res);
    }

    public static int totalFruit(int[] fruits) {
        /**
         * 定义一个数组长度为2，初始值都为-1的篮子
         * -1表示篮子中的水果类型还没有确定
         * 定义slowIndex对整个fruits数组进行遍历，当slowIndex遍历到最后一个元素时，采摘结束
         * 定义fastIndex对一次遍历中的水果进行探测:
         * (1)若水果满足篮子中的类型，则采摘数量+1,fastIndex++
         * (2)若水果不满足篮子中的类型，则slowIndex++,采摘数量-1,并设置篮子中的水果类型
         */
        int[] buckets = {-1,-1};
        int fastIndex = 0;
        int maxFruits = 0;
        int currFruits = 0;
        for(int slowIndex = 0; slowIndex < fruits.length;slowIndex++){
            while(fastIndex < fruits.length){
                if(isPickable(buckets,fruits[fastIndex])){
                    currFruits++;
                    fastIndex++;
                }else {
                    currFruits = fastIndex - slowIndex;
                    if(currFruits > maxFruits){
                        maxFruits = currFruits;
                    }
                    while (isTwoTypes(fruits,slowIndex,fastIndex)){
                        slowIndex++;
                        currFruits--;
                    }
                    buckets[0] = fruits[slowIndex];
                    buckets[1] = -1;
                }
            }
            currFruits = fastIndex - slowIndex;
            if(currFruits > maxFruits){
                maxFruits = currFruits;
            }
            return maxFruits;
        }
        return maxFruits;
    }

    public static boolean isPickable(int[] buckets,int type){
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] == type || buckets[i] == -1){
                if(buckets[i] == -1){
                    buckets[i] = type;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isTwoTypes(int[] fruits,int start,int end){
        int typeNum = 0;
        int temp = -1;
        for(int i = start; i < end;i++){
            if(temp == -1){
                temp = fruits[i];
            }
            if(fruits[i] != temp){
                return true;
            }
        }
        return false;
    }
}
