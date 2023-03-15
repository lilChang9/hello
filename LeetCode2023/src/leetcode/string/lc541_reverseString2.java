package leetcode.string;

public class lc541_reverseString2 {
    public static void main(String[] args) {
        String s = "abcdefgl";
        String reverseStr = reverseStr(s, 3);
        System.out.println(reverseStr);

    }

    public static String reverseStr(String s, int k) {
        /**
         * 首先将s转换成一个字符数组
         * 每次遍历字符数组，走的步数定义为k
         * 定义一个flag表示当前是否需要将前面几个字符进行反转
         * true：需要反转
         * false：不需要反转
         */
        char[] chars = s.toCharArray();
        boolean flag = true;
        int i = 0;
        for (i=0; i < chars.length; i = i + k) {
            if(i == 0){
                continue;
            }
            if(flag) {
                int start = i - k;
                int end = i - 1;
                while (start < end) {
                    char temp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = temp;
                    start++;
                    end--;
                }
                flag = false;
            }else {
                flag = true;
                continue;
            }
        }
        if(flag){
            int start = i - k;
            int end = i - 1;
            while(end > chars.length-1){
                end--;
            }
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(chars);
    }
}
