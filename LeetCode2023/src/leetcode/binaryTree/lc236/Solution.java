package leetcode.binaryTree.lc236;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean pFlag = false;
    boolean qFlag = false;
    boolean findFlag = false;
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历整颗树，如果得到结果为true的话直接返回节点即可
        if(root == null){
            return root;
        }

        // 左
        lowestCommonAncestor(root.left,p,q);

        // 右
        lowestCommonAncestor(root.right,p,q);

        // 中
        containsTwoNode(root,p,q);
        if(pFlag && qFlag){
            if(!findFlag){
                res = root;
                findFlag = true;
            }
        }

        return res;
    }

    public void containsTwoNode(TreeNode node,TreeNode p,TreeNode q){
        List<Integer> list = new ArrayList<>();
        list.remove(list.size()-1);
        // 判断当前节点的左子树和右子树是否含有p和q两个节点
        // 如果含有，将结果进行保存
        if(node == null){
            return;
        }

        // 对当前节点进行先序遍历
        if(node == p){
            pFlag = true;
        }
        if(node == q){
            qFlag = true;
        }

        if(node.left != null){
            containsTwoNode(node.left,p,q);
        }

        if(node.right != null){
            containsTwoNode(node.right,p,q);
        }
    }
}
