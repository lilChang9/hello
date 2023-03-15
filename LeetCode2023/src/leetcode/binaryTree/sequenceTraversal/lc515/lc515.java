package leetcode.binaryTree.sequenceTraversal.lc515;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class lc515 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(43);
        TreeNode node1 = new TreeNode(35);
        TreeNode node2 = new TreeNode(-77);
        TreeNode node3 = new TreeNode(40);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        List<Integer> integers = largestValues(root);
        System.out.println(integers);
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            int max = deque.peekFirst().val;
            while(len != 0){
                TreeNode node = deque.pollFirst();
                len--;
                if(node.val > max){
                    max = node.val;
                }
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
