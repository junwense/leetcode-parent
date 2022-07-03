package com.sean;

import java.util.Stack;

/**
 * @ClassName leetcode42
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/29
 * @Version V1.0
 **/
public class leetcode42 {

    public static void main(String[] args) {
        System.out.println(new leetcode42().trap(new int[]{4,2,0,3,2,5}));
    }

    class Node {
        public int height;
        public int weight;

        public Node(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public int trap(int[] heights) {
        int ans=0;
        Stack<Node> stack=new Stack<>();
        for (int height : heights) {
            int countWeight=0;
            while (!stack.isEmpty()&&height>=stack.peek().height){
                Node pop = stack.pop();
                countWeight+=pop.weight;
                //如果这个时候栈为空，则直接跳过不处理
                if(stack.isEmpty()){
                    continue;
                }
                //底边
                int low=pop.height;
                //高边
                int up = Math.min(stack.peek().height,height);
                ans+=countWeight*(up-low);
            }
            stack.push(new Node(height,countWeight+1));
        }
        return  ans;
    }
}
