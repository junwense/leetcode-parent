package com.sean;

import java.util.Stack;

public class leetcode20 {
    public boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='('|| c =='{'|| c =='[') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(c==')') {
                if(stack.pop()!='('){
                    return  false;
                }else{
                    continue;
                }
            }
            if(c==']') {
                if(stack.pop()!='['){
                    return  false;
                }else{
                    continue;
                }
            }
            if(c=='}') {
                if(stack.pop()!='{'){
                    return  false;
                }else{
                    continue;
                }
            }
        }
        return stack.isEmpty();
    }
}
