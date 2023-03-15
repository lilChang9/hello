package leetcode.binaryTree.lc257;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        getPath(root,"");
        return res;
    }

    public void getPath(TreeNode node,String path){
        if(node == null){
            return;
        }
        path += String.valueOf(node.val);
        if(node.left == null && node.right == null){
            res.add(path);
            return;
        }
        if(node.left != null || node.right != null){
            path += "->";
            if(node.left != null){
                getPath(node.left,path);
            }
            if(node.right != null){
                getPath(node.right,path);
            }
        }
        return;
    }
}