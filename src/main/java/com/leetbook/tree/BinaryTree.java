package com.leetbook.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTree
 * @Description 二叉树
 * @Author Zhang Yao
 * @Date Create in 17:58 2021/1/25 0025
 * @Version 1.0
 */
public class BinaryTree {

    //https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xeywh5/
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归实现前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();


        return result;
    }
}
