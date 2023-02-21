package com.sean;


/**
 * @ClassName leetcode53
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/1
 * @Version V1.0
 **/
public class leetcode53 {

    public static void main(String[] args) {
        System.out.println(new leetcode53().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    public int maxSubArray(int[] nums) {

        int size = nums.length;
        int[] s = new int[size + 1];
        int[] minPre = new int[size + 1];
        s[0] = 0;
        for (int i = 1; i <= size; i++) {
            //求前缀和
            s[i] = s[i - 1] + nums[i - 1];
        }
        minPre[0] = s[0];
        for (int i = 1; i <= size; i++) {
            //求最小前缀和
            minPre[i] = Math.min(minPre[i - 1], s[i]);
        }
        int ans = -10000;
        for (int i = 1; i <= size; i++) {
            // 前缀和i减去i-1中最小前缀和，即可得到最大子数组和
            ans = Math.max(s[i] - minPre[i - 1], ans);
        }

        return ans;
    }
}
