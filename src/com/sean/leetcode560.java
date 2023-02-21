package com.sean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode560
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/29
 * @Version V1.0
 **/
public class leetcode560 {

    public static void main(String[] args) {
        System.out.println(new leetcode560().subarraySum(new int[]{-1, -1, 1}, 0));
    }

    /**
     * 类似于1248题
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int length = nums.length;
        int[] sumPre = new int[length + 1];
        sumPre[0] = 0;
        for (int i = 1; i <= length; i++) {
            sumPre[i] = sumPre[i - 1] + nums[i - 1];
        }

        // sumPre[k]-sumPre[i-k]=k
        Map<Integer, Integer> cache = new HashMap<>(length);
        cache.put(sumPre[0], 1);
        for (int i = 1; i <= length; i++) {
            //由于前缀和存在为负数的值，所以不用判断下标大于0
            // if(sumPre[i]-k>=0){
            ans += cache.getOrDefault(sumPre[i] - k, 0);
            // }
            cache.put(sumPre[i], cache.getOrDefault(sumPre[i], 0) + 1);
        }

        return ans;
    }

}
