package leetcode.binaryTree.lc98;

import leetcode.binaryTree.TreeNode;

public class lc98 {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        System.out.println(s.isValidBST(root));
    }
}
