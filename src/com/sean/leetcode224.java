package com.sean;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName leetcode224
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/27
 * @Version V1.0
 **/
public class leetcode224 {
    public static void main(String[] args) {
        System.out.println(new leetcode224().calculate("1-(-2)"));
    }

    public int calculate(String s) {
        s = s + " ";

        if (s.startsWith("-")) {
            s = 0 + s;
        }

        List<String> strings = new LinkedList<String>();
        Stack<Character> stack1 = new Stack<>();
        String tempNumStr = "";
        boolean needAdd0 = false;
        char[] schar = s.toCharArray();
        for (int n = 0; n < schar.length; n++) {
            char c = schar[n];

            if (c >= '0' && c <= '9') {
                needAdd0 = false;
                tempNumStr += c;
                continue;
            } else {
                if(!"".equals(tempNumStr)){
                    strings.add(tempNumStr);
                    tempNumStr = "";
                }
            }

            if (c == ' ') {
                continue;
            }

            if (c == '(') {
                needAdd0 = true;
                stack1.push(c);
                continue;
            }

            if (c == ')') {
                needAdd0 = false;
                while (!stack1.isEmpty() && stack1.peek() != '(') {
                    strings.add(stack1.pop().toString());
                }
                //最后取出"("
                stack1.pop();
                continue;
            }

            //TODO
            if ((c == '-' || c == '+') && needAdd0) {
                strings.add("0");
            }

            while (!stack1.isEmpty() && getRank(stack1.peek()) >= getRank(c)) {
                strings.add(stack1.pop().toString());
            }
            stack1.push(c);
            needAdd0 = true;
        }

        while (!stack1.isEmpty()) {
            strings.add(stack1.pop().toString());
        }

        int ans = evalRPN(strings.toArray(new String[]{}));

        return ans;
    }
    //"3+2*2-1/2" ->   322*+12/-
    //"3+2*2*1/2" ->   322*1*2/+

    /**
     * 获取符号等级
     *
     * @param c
     * @return
     */
    public int getRank(char c) {
        if (c == 42 || c == 47) {
            return 2;
        } else if (c == 43 || c == 45) {
            return 1;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {

            if ("".equals(token)) {
                continue;
            }

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
