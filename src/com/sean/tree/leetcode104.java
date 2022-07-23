package com.sean.tree;

/**
 * @ClassName leetcode104
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/3
 * @Version V1.0
 **/
public class leetcode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        return ans;
    }

}
