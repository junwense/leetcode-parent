package com.sean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName leetcode47
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/30
 * @Version V1.0
 **/
public class leetcode47 {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visite;
    Set<List<Integer>> cache = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    int size = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        size = nums.length;
        visite = new boolean[size];
        doUnique(nums, 0);
        return ans;
    }
    //使用cache还是时间太长，需要n*n的时间复杂度，所以需要考虑剪支
    private void doUnique(int[] nums, int index) {
        if (index == size) {
            if (!cache.contains(temp)) {
                ans.add(new ArrayList<>(temp));
            }
            cache.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < size; i++) {
            if (visite[i]) {
                continue;
            }
            temp.add(nums[i]);
            visite[i] = true;
            doUnique(nums, index + 1);
            visite[i] = false;
            temp.remove(index);
        }
    }
}
