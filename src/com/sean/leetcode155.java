package com.sean;

import java.util.Stack;

public class leetcode155 {

    Stack<Integer> stack = null;
    Stack<Integer> mid = null;

    public leetcode155() {
        stack = new Stack<>();
        mid = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!mid.isEmpty()) {
            mid.push(Math.min(mid.peek(), val));
        } else {
            mid.push(val);
        }
    }

    public void pop() {
        stack.pop();
        mid.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mid.peek();
    }
}
