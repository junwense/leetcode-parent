package com.sean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode46
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/2
 * @Version V1.0
 **/
public class leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        visited = new boolean[n];
        res(nums);
        return ans;
    }

    List<Integer> temp = new ArrayList<>();
    int n;
    boolean[] visited;
    List<List<Integer>> ans = new ArrayList<>();

    private void res(int[] nums) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                res(nums);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }

}
