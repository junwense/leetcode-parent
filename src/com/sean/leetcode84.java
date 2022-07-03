package com.sean;

import java.util.Stack;

/**
 * @ClassName leetcode84
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/28
 * @Version V1.0
 **/
public class leetcode84 {

    public static void main(String[] args) {
        System.out.println(new leetcode84().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    class Node {
        public int height;
        public int weight;

        public Node(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public int largestRectangleArea(int[] heights) {

        if(heights.length==1){
            return heights[0];
        }

        int ans=0;
        Stack<Node> stack=new Stack<>();
        for (int height : heights) {
            int weight=0;
            while (!stack.isEmpty()&&stack.peek().height>=height){
                Node pop = stack.pop();
                weight+=pop.weight;
                //取出栈顶元素并算出最大值
                ans=Math.max(ans,pop.height*weight);
            }
            //最后加入栈
            stack.push(new Node(height,weight+1));
        }

        //最后再出栈一次，
        if(!stack.isEmpty()) {
            int weight = 0;
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                weight += pop.weight;
                //取出栈顶元素并算出最大值
                ans = Math.max(ans, pop.height * weight);
            }
        }

        return ans;
    }


}
