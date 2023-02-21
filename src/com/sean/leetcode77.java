package com.sean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode77
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/24
 * @Version V1.0
 **/
public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        res(n, 0);
        return ans;

    }

    List<Integer> temp = new ArrayList<>();

    int n;

    int k;

    List<List<Integer>> ans = new ArrayList<>();

    private void res(int num, int pos) {

        if (temp.size() > k || temp.size() + n - pos < k) {
            return;
        }

        if (pos == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        res(n, pos + 1);
        temp.add(pos + 1);
        res(n, pos + 1);
        temp.remove(temp.size() - 1);
    }

}
