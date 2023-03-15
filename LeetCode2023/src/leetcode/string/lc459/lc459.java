package leetcode.string.lc459;

public class lc459 {

    public static void main(String[] args) {
        boolean res = repeatedSubstringPattern("bb");
        System.out.println(res);
    }

    public static boolean repeatedSubstringPattern(String s) {
        /*
            判断是否有重复字串
            如果有重复字串，那么个数最小为2
            若重复个数为n，则每个子串的长度为s/n
            要判断s.length()是否可以整除n:
            (1)如果不可以那么直接进行下一次判断
            (2)如果可以，那么以<s.length()为判断条件，每次步长step为s/n，判断两个字符是否相等
         */
        for(int divisor = 2; divisor <= s.length(); divisor++){
            // 若要判断是否存在重复子串，那么除数可以从2开始，到s.length-1结束
            if(s.length()%divisor!=0){
                // 如果s的长度无法被除数整除，证明无法被切分成长度相等的块，进行下次遍历
                continue;
            }else{
                // s的长度可以被divisor整除，证明可以被切分成长度相等的块
                int i = 0;
                int step = s.length() / divisor;
                while(i < step){
                    int j = i;
                    while(j < s.length() - step){
                        if(s.charAt(j) == s.charAt(j+step)){
                            j += step;
                        }else{
                            break;
                        }
                    }
                    if(j >= s.length()-step){
                        // 如果j大于等于s.length(),证明每一次符号判断都相等
                        // i++，进行下一次遍历即可
                        i++;
                    }else{
                        // 如果j小于s.length(),证明存在不相同的符号，打破循环，找下一个除数即可
                        break;
                    }
                }
                if(i == step){
                    // 当i与step相等时，证明找到了重复的子串，返回true
                    return true;
                }
            }
        }
        return false;
    }
}
