package com.sean;

import java.util.Stack;

/**
 * @ClassName leetcode150
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/27
 * @Version V1.0
 **/
public class leetcode150 {

    public static void main(String[] args) {
        //to use tokens = ["2","1","+","3","*"]
        String s = "322*+12/-";
        System.out.println(new leetcode150().evalRPN(s.split("")));

    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {

            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                // j先出栈
                int j = stack.pop();
                int i = stack.pop();
                int tempAns = doProcess(token, i, j);
                stack.push(tempAns);
                continue;
            }

            stack.push(Integer.parseInt(token));
        }

        return stack.peek();
    }

    private int doProcess(String token, int i, int j) {
        switch (token) {
            case "+":
                return i + j;
            case "-":
                return i - j;
            case "*":
                return i * j;
            case "/":
                return i / j;
            default:
                return 0;
        }
    }
}
