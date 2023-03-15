package leetcode.binaryTree.sequenceTraversal.lc111;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.List;

public class lc111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root == null){
            return minDepth;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            while(len != 0){
                TreeNode node = deque.pollFirst();
                len--;
                if(node.left==null && node.right == null){
                    minDepth++;
                    return minDepth;
                }
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }
}
