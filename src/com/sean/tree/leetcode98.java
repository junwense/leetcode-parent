package com.sean.tree;

/**
 * @ClassName leetcode98
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/3
 * @Version V1.0
 **/
public class leetcode98 {

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isValidTreeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 采用long，防止越界
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean isValidTreeNode(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return isValidTreeNode(root.left, min, (long) root.val - 1) && isValidTreeNode(root.right, (long) root.val + 1, max);

    }

}
