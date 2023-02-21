package com.sean;

import java.util.Stack;

/**
 * 402. 移掉 K 位数字
 */
public class leetcode402 {
    //98765 2
    //1432219 3 1219
    //10200 2 200
    //10200 3 0
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if (size <= k) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            Integer temp = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > temp && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(temp);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        Stack<Integer> stack1 = new Stack<Integer>();
        int size1 = stack.size();
        for (int i = 0; i < size1; i++) {
            stack1.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int size2 = stack1.size();
        for (int i = 0; i < size2; i++) {
            Integer pop = stack1.pop();
            if (!flag && pop != 0) {
                flag = true;
            }
            if (flag) {
                sb.append(pop);
            }
        }
        String s = sb.toString();
        if ("".equals(s)) {
            s = "0";
        }
        return s;
    }

    public String removeKdigits1(String num, int k) {
        int size = num.length();
        if (size <= k) {
            return "";
        }
        char[] res = new char[k];
        int index = 0;
        for (int i = 0; i < size - 1; i++) {
            if (index == k) {
                break;
            }
            if (num.charAt(i) >= num.charAt(i + 1)) {
                res[index] = num.charAt(i);
                index++;
            }
        }
        return new String(res);
    }
}
