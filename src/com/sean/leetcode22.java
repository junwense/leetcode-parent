package com.sean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName leetcode22
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/26
 * @Version V1.0
 **/
public class leetcode22 {

    public static void main(String[] args) {
        List<String> test=new ArrayList<>();
        test.add("");
        test.forEach(a-> System.out.println(a));
        System.out.println(test);
        System.out.println(new leetcode22().generateParenthesis(2));

    }

    Map<Integer,List<String>> cache=new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }
        List<String> ans = new ArrayList<>();
        //把括号分成(A)B 这样
        //其中A的结果组合存在i-1种
        //B的结果组合存在 n-i总
        //加上A外面一对括号，一共有i-1+(n-i)+1=n2个括号
        //这里 i的最大值为 n-i>=0 即 i<=n
        for (int i = 1; i <= n; i++) {
            List<String> resA = generateParenthesis(i - 1);
            List<String> resB = generateParenthesis(n - i);
            for (String a : resA) {
                for (String b : resB) {
                    ans.add("(" + a + ")" + b);
                }
            }
        }

        return ans;
    }

}
