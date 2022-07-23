package com.sean.tree;

/**
 * @ClassName leetcode104_1
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/3
 * @Version V1.0
 **/
public class leetcode104_1 {

    int ans;
    int depth;

    public int maxDepth(TreeNode root) {
        ans=0;
        depth=0;
        cale(root);
        return ans;
    }

    public void cale(TreeNode root){
        if(root==null) {
            return;
        }

        depth++;
        ans=Math.max(ans,depth);
        cale(root.left);
        cale(root.right);
        depth--;
    }

}
