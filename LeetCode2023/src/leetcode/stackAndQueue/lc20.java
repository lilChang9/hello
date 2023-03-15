package leetcode.stackAndQueue;

import java.util.Stack;

public class lc20 {
    public static void main(String[] args) {
        String s = "()()[]{{}}";
        boolean res = isValid(s);
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        /**
         * 使用栈完成符号匹配
         * 若碰到左括号，则直接入栈，若碰到右括号，则出栈
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '['
                    || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop() == '('){
                    continue;
                }else {
                    return false;
                }
            }
            if(s.charAt(i) == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop() == '['){
                    continue;
                }else {
                    return false;
                }
            }
            if(s.charAt(i) == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop() == '{'){
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
