package leetcode.binaryTree.lc106;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> postorderList = Arrays.stream(postorder).boxed().collect(Collectors.toList());
        return constructTree(inorderList,postorderList);
    }

    public TreeNode constructTree(List<Integer> inorder, List<Integer> postorder){
        if(postorder.size() == 0){
            return null;
        }
        // 每次递归首先找后序遍历数组的最后一个元素
        int midVal = postorder.get(postorder.size()-1);

        TreeNode root = new TreeNode(midVal);
        if(postorder.size() == 1){
            return root;
        }

        // 通过midVal将中序数组切割成两个数组
        List<Integer> leftInList = inorder.subList(0,inorder.indexOf(midVal));
        List<Integer> rightInList = inorder.subList(inorder.indexOf(midVal)+1,inorder.size());

        // 再通过左中序数组的大小对后序数组进行切割
        List<Integer> leftPostList = postorder.subList(0,leftInList.size());
        List<Integer> rightPostList = postorder.subList(leftInList.size(),postorder.size()-1);

        // 递归进行切割
        root.left = constructTree(leftInList,leftPostList);
        root.right = constructTree(rightInList,rightPostList);
        return root;
    }
}
