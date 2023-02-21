package com.sean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName leetcode30
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/25
 * @Version V1.0
 **/
public class leetcode30 {

    public static void main(String[] args) {
        //System.out.println(new leetcode30().findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
        //System.out.println(new leetcode30().findSubstring("a",new String[]{"a","a"}));
        //System.out.println(new leetcode30().findSubstring("aaa", new String[]{"a", "a"}));
        //System.out.println(new leetcode30().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new leetcode30().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));


    }

    public List<Integer> findSubstring1(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>(words.length);
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        int wordLength = words[0].length();
        int allLength = wordLength * words.length;
        for (int i = 0; i < wordLength; i++) {

            for (int j = i; j <= s.length() - allLength; j += wordLength) {
                Map<String, Integer> windoesMap = new HashMap<>(words.length);
                windoesMap.putAll(wordsMap);
                String body = s.substring(j, j + allLength);
                for (int k = 0; k < words.length; k++) {
                    String temp = body.substring(0, wordLength);
                    body = body.substring(wordLength);
                    if (windoesMap.containsKey(temp)) {
                        Integer integer = windoesMap.get(temp);
                        if (integer == 1) {
                            windoesMap.remove(temp);
                        } else {
                            windoesMap.put(temp, integer - 1);
                        }
                    }
                }
                if (windoesMap.isEmpty()) {
                    ans.add(j);
                }
                continue;
            }
        }
        return ans;
    }

    /**
     * 时间复杂度 O() s长度 *word长度
     * 空间复杂度 O() words 单词数 * words长度
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        int wordNum = words.length;
        int allLength = wordNum * wordLen;
        int slen = s.length();

        for (int i = 0; i < wordLen; i++) {

            //当i+窗格长度大于素组的时候，说明窗口移动到了最后，需要返回
            if (i + allLength > slen) {
                break;
            }

            //存放单词个数的map
            Map<String, Integer> wordsMap = new HashMap<>(wordNum * 2);

            //先把需要匹配的单词放入map
            for (String word : words) {
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
            }

            //处理第一个窗口，按照单词长度截取窗口中的数据和map比对，存在则map里面的先减1
            //不存在的直接设置 -1，表示是多余的字符，不匹配。
            for (int x = 1; x <= wordNum; x++) {
                String body = s.substring(i + (x - 1) * wordLen, i + x * wordLen);
                wordsMap.put(body, wordsMap.getOrDefault(body, 0) - 1);
                //如果是0，则直接删除map里面的数据，表示匹配上了
                if (wordsMap.get(body) == 0) {
                    wordsMap.remove(body);
                }
            }

            //按照单词长度遍历，即每次都会把窗口向后移动一个单词长度
            //这样只需要处理前后个单词就可以
            for (int j = i; j <= slen - allLength; j += wordLen) {
                //如果是刚刚开始移动，则跳过处理，因为上面第一次其实已经处理过了
                if (j != i) {
                    //找到上个窗口最前面的一个单词组，即这次移动从窗口里面去除的单词
                    String last = s.substring(j - wordLen, j);
                    //重新添加入匹配map，因为上个单词已经不在窗口里面了
                    wordsMap.put(last, wordsMap.getOrDefault(last, 0) + 1);
                    //注意，这里需要处理0的情况，因为可能存在原串里面存在匹配项里面不存在的单词，即多余的单词
                    //当不存在的单词last移出窗口时，窗口里面的-1会+1直到
                    //
                    //变成0，这个时候需要去除掉不存在的匹配项。
                    if (wordsMap.get(last) == 0) {
                        wordsMap.remove(last);
                    }

                    //找到这次窗口移动新增的单词，即最后一个单词
                    String next = s.substring(j + allLength - wordLen, j + allLength);
                    //从map中去除匹配项
                    wordsMap.put(next, wordsMap.getOrDefault(next, 0) - 1);
                    if (wordsMap.get(next) == 0) {
                        wordsMap.remove(next);
                    }
                }
                if (wordsMap.isEmpty()) {
                    ans.add(j);
                }
            }
        }
        return ans;
    }
}
