package com.sean;

import java.util.*;

/**
 * @ClassName leetcode49
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/25
 * @Version V1.0
 **/
public class leetcode49 {

    public static void main(String[] args) {
        leetcode49 leetcode49 = new leetcode49();
        System.out.println(leetcode49.getHash("ill"));
        System.out.println(leetcode49.getHash("duh"));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans =new LinkedList<>();
        Map<String,List<String>> temp=new HashMap<>(strs.length);
        for (String str : strs) {
            String hash = getHash(str);
            if (!temp.containsKey(hash)) {
                List<String> list = new LinkedList<>();
                list.add(str);
                temp.put(hash, list);
            }else{
                temp.get(hash).add(str);
            }
        }

        ans.addAll(temp.values());
        return ans;
    }

    /**
     * hash 26进制
     */
    protected String getHash(String s) {
        char[] temp=new char[26];
        for (char c : s.toCharArray()) {
            temp[c-'a']++;
        }
        return new String(temp);
    }
}
