package com.sean;

import java.util.Stack;

/**
 * @ClassName leetCode227 计算器
 * @Description: 直接双栈运算
 * @Author a9705
 * @Date 2022/6/27
 * @Version V1.0
 **/
public class leetCode227_1 {

    public static void main(String[] args) {
        System.out.println(new leetCode227_1().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        if (s.startsWith("-")) {
            s = 0 + s;
        }
        Stack<Character> chars = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        String tempNumStr = "";
        char[] schar = s.toCharArray();
        boolean needAdd0 = false;
        for (int n = 0; n < schar.length; n++) {
            char c = schar[n];
            if (c == ' ') {
                continue;
            }

            if (c >= '0' && c <= '9') {
                needAdd0 = false;
                tempNumStr += c;
                continue;
            } else {
                if (!"".equals(tempNumStr)) {
                    nums.push(Integer.valueOf(tempNumStr));
                }
                tempNumStr = "";
            }

            if (c == '-' && needAdd0) {
                nums.push(0);
            }

            if (c == '(') {
                needAdd0 = true;
                chars.push(c);
                continue;
            } else if (c == ')') {
                needAdd0 = false;
                while (!chars.isEmpty() && chars.peek() != '(') {
                    char c1 = chars.pop();
                    int j = nums.pop();
                    int i = nums.pop();
                    nums.push(doProcess(String.valueOf(c1), i, j));
                }
                //最后取出"("
                chars.pop();
            } else {
                //"3+2*2-1/2" ->   322*+12/-
                //"3+2*2*1/2" ->   322*1*2/+
                // + - 先入栈，如果遇到输入符号比栈顶级别低的就都出栈，计算结果
                needAdd0 = true;
                while (!chars.isEmpty() && getRank(chars.peek()) >= getRank(c)) {
                    char c1 = chars.pop();
                    int j = nums.pop();
                    int i = nums.pop();
                    nums.push(doProcess(String.valueOf(c1), i, j));
                }
                chars.push(c);
            }
        }

        if (!"".equals(tempNumStr)) {
            nums.push(Integer.valueOf(tempNumStr));
        }

        while (!chars.isEmpty()) {
            char c1 = chars.pop();
            int j = nums.pop();
            int i = nums.pop();
            nums.push(doProcess(String.valueOf(c1), i, j));
        }

        return nums.peek();
    }

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
