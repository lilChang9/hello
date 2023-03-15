package leetcode.binaryTree.lc94_inorderTraversal;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        inOrder(root,deque);
        System.out.println(deque);
    }

    public static ArrayDeque<TreeNode> inOrder(TreeNode root,ArrayDeque<TreeNode> deque){
        if(root != null && root.left == null && root.right == null){
            deque.addLast(root);
            return deque;
        }
        if(root == null){
            deque.addLast(root);
            return deque;
        }
        inOrder(root.left,deque);
        deque.addLast(root);
        inOrder(root.right,deque);
        return deque;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        TreeNode node;
        while(!stack.isEmpty()){
            while(cur != null && cur.left != null){
                cur = cur.left;
                stack.push(cur);
            }
            node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                cur = node.right;
                stack.push(cur);
            }
        }
        return res;
    }
}
