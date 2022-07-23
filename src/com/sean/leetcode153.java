package com.sean;

public class leetcode153 {
    public int findMin(int[] nums) {
        int size =nums.length;
        int left=0;
        int right=size-1;

        while (left<right){
            int point= (right+left)/2;
            //由于是向0取整，所以point不可能等于right，这点很关键
            if(nums[point]<nums[right]){
                //如果右侧为递增序列，但是point左边的节点比他大，则最小就是point
                if(point>0&&nums[point-1]>nums[point]){
                    return nums[point];
                }
                //如果右侧为递增序列，排除上面的特殊情况，说明最小点在左边
                right=point;
            }else{
                //左侧为递增序列，最小点不可能在左边
                left=point+1;
            }
        }
        return nums[left];
    }
}
