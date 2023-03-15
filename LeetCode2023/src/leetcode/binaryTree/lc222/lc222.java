package leetcode.binaryTree.lc222;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayDeque;

public class lc222 {

    int leafNum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
    }

    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return count;
        }
        // 首先遍历最左面的节点得到完全二叉树的最大深度
        int maxDepth = getMaxDepth(root);
        // 初始curDepth=1;
        int leafNum = getLeafNodeNums(root,1,maxDepth);
        return (int) Math.pow(2,maxDepth-1) - 1 + leafNum;
    }

    public int getLeafNodeNums(TreeNode node,int curDepth,int maxDepth){
        if(curDepth == maxDepth && node.left == null && node.right == null){
            leafNum++;
        }
        if(node.left != null){
            getLeafNodeNums(node.left,curDepth+1,maxDepth);
        }
        if(node.right != null){
            getLeafNodeNums(node.right,curDepth+1,maxDepth);
        }
        return leafNum;
    }

    public int getMaxDepth(TreeNode node){
        int maxDepth = 0;
        while(node!=null){
            maxDepth++;
            node = node.left;
        }
        return maxDepth;
    }
}
