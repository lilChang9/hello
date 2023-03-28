package leetcode.binaryTree.lc98;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    long maxVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.toArray(new Integer[list.size()]);
        return isValid(root,maxVal);
    }

    public boolean isValid(TreeNode root,long max){
        if(root == null){
            return true;
        }

        // 左
        boolean f1 = isValid(root.left,maxVal);

        // 中
        if(maxVal >= root.val){
            return false;
        }else{
            maxVal = root.val;
        }

        boolean f2 = isValid(root.right,maxVal);

        return (f1 && f2);
    }
}
