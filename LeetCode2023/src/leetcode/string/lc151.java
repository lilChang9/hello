package leetcode.string;

public class lc151 {
    public static void main(String[] args) {
        String res = reverseWords("a good   example");
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        /**
         * (1)首先对字符串进行如下操作:
         * 去除字符串所有的前导空格、中间多余的空格以及后置空格
         * (2)对处理后的字符串进行反转
         * (3)对单词再进行反转
         */
        String res = "";
        int j = 0;
        int end = 0;
        int start = 0;
        // 定义j来去除前导空格和后置空格以及所有的冗余空格
        // 如果首先j指向的为空格，则j++，直到j指向的字符不为空格
        // 将i置为j的大小，这样就得到了子字符串的头位置
        // 接着j继续向前遍历，当j碰
        while(s.charAt(j)==' '){
            j++;
        }
        while(j < s.length()){
            start = j;
            while(j < s.length() && s.charAt(j)!=' '){
                j++;
            }
            if(j == s.length()){
                res = res + s.substring(start,j);
                break;
            }
            // 当前j指向单词后的第一个空格
            // 两种情况:
            // (1)j处于最后一个单词的后面的空格
            // (2)j处于不是最后一个单词的后面的空格
            // 所以要定义一个temp=j判断j是否处于最后一个单词
            int temp = j;
            while(temp < s.length()){
                if (s.charAt(temp) == ' '){
                    temp++;
                }else {
                    break;
                }
            }
            if(temp == s.length()){
                // 如果temp与字符串s的长度相等，则刚才遍历的都为后置空格
                // 所以将截取字符串的end节点取为j-1即可
                end = j;
                res = res + s.substring(start,end);
                j = temp;
            }else {
                // 如果temp与字符串s的长度不相等，则证明后面还有单词
                // 所以将j作为end进行单词的截取，然后令j=temp即可
                end = j + 1;
                res = res + s.substring(start,end);
                j = temp;
            }
        }
        // 对处理后的字符串进行反转
        char[] chars = res.toCharArray();
        reverse(chars,0,chars.length-1);
        int i = 0;
        int k = 0;
        while(k < chars.length){
            while(k < chars.length && chars[k] != ' '){
                k++;
            }
            reverse(chars,i,k-1);
            i = k+1;
            k = k+1;
        }
        res = String.valueOf(chars);
        return res;
    }

    private static void reverse(char[] chars,int start,int end){
        while(start != end && start < end){
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
}
