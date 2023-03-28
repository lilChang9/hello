package leetcode.binaryTree.lc513;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {


    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> resList = new ArrayList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            while(len != 0){
                List<Integer> tempList = new ArrayList<>();
                TreeNode node = deque.pollFirst();
                len--;
                tempList.add(node.val);
                if(len == 0){
                    resList.add(tempList);
                }
            }
        }
        return resList.get(resList.size()-1).get(0);
    }
}
