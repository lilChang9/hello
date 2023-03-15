package leetcode.binaryTree.lc257;

import leetcode.binaryTree.TreeNode;

public class lc257 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        System.out.println("hot-fix first changed");
        System.out.println("hot-fix second changed");
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        solution.binaryTreePaths(root);
    }
}
