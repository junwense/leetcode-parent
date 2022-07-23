package com.sean.tree;

/**
 * @ClassName TreeNode
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/3
 * @Version V1.0
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
