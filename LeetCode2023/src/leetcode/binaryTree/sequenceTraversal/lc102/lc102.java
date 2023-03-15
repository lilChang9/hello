package leetcode.binaryTree.sequenceTraversal.lc102;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<Integer> lists = levelOrder(root);
        System.out.println(lists);
    }

    public static List<Integer> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rightSideList = new ArrayList<>();
        if(root == null){
            return rightSideList;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int curLayerNum = 1;
        int nextLayerNum = 0;
        while(!deque.isEmpty() && curLayerNum!=0){
            List<Integer> tempList = new ArrayList<>();
            while(curLayerNum != 0){
                TreeNode node = deque.pollFirst();
                tempList.add(node.val);
                curLayerNum--;
                if(node.left != null){
                    deque.addLast(node.left);
                    nextLayerNum++;
                }
                if(node.right != null){
                    deque.addLast(node.right);
                    nextLayerNum++;
                }
            }
            curLayerNum = nextLayerNum;
            nextLayerNum = 0;
            res.add(tempList);
        }
        for (List<Integer> re : res) {
            rightSideList.add(re.get(re.size()-1));
        }

        return rightSideList;
    }
}
