package leetcode.binaryTree.lc106;

import leetcode.binaryTree.TreeNode;

public class lc106 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = s.buildTree(inorder, postorder);
        System.out.println("success");
    }
}
