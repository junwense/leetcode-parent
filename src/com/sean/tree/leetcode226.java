package com.sean.tree;

/**
 * @ClassName leetcode226
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/3
 * @Version V1.0
 **/
public class leetcode226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode treeNode) {
        TreeNode temp = treeNode.right;
        treeNode.right = treeNode.left;
        treeNode.left = temp;
    }
}
