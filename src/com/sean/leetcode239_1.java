package com.sean;

import java.util.PriorityQueue;

/**
 * @ClassName leetcode239
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/30
 * @Version V1.0
 **/
public class leetcode239_1 {

    public static void main(String[] args) {
        int[] ints = new leetcode239_1().maxSlidingWindow(new int[]{1, -1}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Node> queue = new PriorityQueue<>();

        int size = nums.length;
        int[] ans = new int[size - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.add(new Node(i, nums[i]));
            if (i - k + 1 >= 0) {
                while (queue.peek().index < i - k + 1) {
                    queue.poll();
                }
                ans[i - k + 1] = queue.peek().val;
            }
        }

        return ans;
    }

    class Node implements Comparable<Node> {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {

            if (o.val > this.val) {
                return 1;
            } else if (o.val < this.val) {
                return -1;
            }
            return 0;
        }
    }
}
