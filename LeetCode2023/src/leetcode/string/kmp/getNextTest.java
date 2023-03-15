package leetcode.string.kmp;

public class getNextTest {

    public static void main(String[] args) {
       String haystack = "mississippi";
       String needle = "issip";
       int[] next = getNext(needle);
       for (int i = 0; i < next.length; i++) {
           System.out.print(next[i]+" ");
       }
       System.out.println();
       int res = KMP(haystack, needle);
       System.out.println(res);
    }

    private static int KMP(String haystack,String needle){
        // 首先获得needle的next数组
        int[] next = getNext(needle);
        // 遍历haystack同时遍历needle
        // 但每次匹配回退的时候只需要回退到next[j-1]的位置即可
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                if(j==0){
                    i++;
                    j = 0;
                }else {
                    j = next[j-1];
                }
            }
        }
        if(j == needle.length()){
            return i - needle.length();
        }
        return -1;
    }


    private static int[] getNext(String s){
        int[] next = new int[s.length()];
        for(int i = 0; i < s.length();i++){
            // next数组的第一个值肯定是0
            // 因为第一个元素既没有前缀也没有后缀
            if(i == 0){
                next[0] = 0;
                continue;
            }
            // 每次求子串的最大公共前后缀长度
            // 可以直接从最大值开始求，如果满足那么直接将值设置到next数组中，进行下一次遍历
            // 定义两个指针prefix和suffix
            // prefix初始为0
            // suffix初始为1
            int prefix = 0;
            int suffix = 1;
            int maxLen = i;
            while (maxLen != 0){
                while (prefix < i && suffix < i+1 && s.charAt(prefix) == s.charAt(suffix)){
                    // 前缀指向的值与后缀指向的值相等;
                    prefix++;
                    suffix++;
                }
                if(prefix == i || suffix == i+1){
                    // 当prefix > i 并且 suffix==i+1时
                    // 证明已经完成了部分前后缀匹配，直接将maxLen设置到next数组中
                    next[i] = maxLen;
                    break;
                }
                // 走到这里证明没有找到前缀和后缀相等的条件发生
                maxLen--;
                if(maxLen == 0){
                    next[i] = 0;
                    break;
                }
                prefix = 0;
                suffix = i - maxLen + 1;
            }
        }
        return next;
    }
}
