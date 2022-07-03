package com.sean;

/**
 * @ClassName leetcode81_1
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/28
 * @Version V1.0
 **/
public class leetcode84_1 {

    public static void main(String[] args) {
        System.out.println(new leetcode84_1().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        //边界条件判断
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return heights[0];
        }
        int ans=0;
        //left记录元素左边第一个小于它的元素的下标
        //right记录元素右边第一个小于它的元素的下标
        int[] left = new int[n];
        int[] right = new int[n];
        //stack是用来模拟栈的数组 ，类似于heights的索引素组
        int[] stack = new int[n+1];

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //边界条件判断
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return heights[0];
        }
        //left记录元素左边第一个小于它的元素的下标
        //right记录元素右边第一个小于它的元素的下标
        int[] left = new int[n];
        int[] right = new int[n];
        //stack是用来模拟栈的数组 ，类似于heights的索引素组
        int[] stack = new int[n+1];
        //tt记录栈中元素位置
        int tt = 0;
        for (int i = 0; i < n; i++) {
            //遍历栈，直到下标元素小于heights[i]
            while (tt != 0 && heights[stack[tt]] >= heights[i]) {
                tt--;
            }
            left[i] = (tt == 0) ? -1 : stack[tt];
            stack[++tt] = i;
        }

        //将tt置为0即可当做一个空栈，用来找每个元素右边第一个小于它的元素的下标
        tt = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (tt != 0 && heights[stack[tt]] >= heights[i]) {
                tt--;
            }
            right[i] = (tt == 0) ? n : stack[tt];
            stack[++tt] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
}
