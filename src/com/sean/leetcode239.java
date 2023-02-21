package com.sean;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName leetcode239
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/30
 * @Version V1.0
 **/
public class leetcode239 {

    public static void main(String[] args) {
        int[] ints = new leetcode239().maxSlidingWindow(new int[]{1, -1}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int[] ans = new int[size - k + 1];

        //双端队列，用于保存窗口,保存的为数组的下标
        Deque<Integer> dq = new ArrayDeque<>(k);
        for (int i = 0; i < size; i++) {

            //需要把不合法的下标给去除掉，比如i等于4，那么窗口中最小的元素下标应该是4-k+1=2
            // 1  3 [-1  -3  5] 3  6  7   这里3就要从队列中移除
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            //添加元素时要保证队列成递减序列，如果是队列最后一个元素比当前元素小或者相等，则队列最后一个元素出队。
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            //加入当前元素到队列最后
            dq.addLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }

}
