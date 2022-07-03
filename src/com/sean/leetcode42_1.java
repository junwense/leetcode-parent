package com.sean;

/**
 * @ClassName leetcode42
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/29
 * @Version V1.0
 **/
public class leetcode42_1 {

    public static void main(String[] args) {
        System.out.println(new leetcode42_1().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public int trap(int[] heights) {
        int ans=0;
        int length = heights.length;
        int[] left=new int[length];
        int[] right=new int[length];

        left[0]=heights[0];
        for (int i = 1; i < length; i++) {
            left[i]=left[i-1]>heights[i]?left[i-1]:heights[i];
        }
        right[length-1]=heights[length-1];
        for (int i = length-2; i >=0 ; i--) {
            right[i]=right[i+1]>heights[i]?right[i+1]:heights[i];
        }

        for (int i = 0; i < length; i++) {
            ans+=Math.min(left[i],right[i])-heights[i];
        }
        return  ans;
    }
}
