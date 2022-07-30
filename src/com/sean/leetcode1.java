package com.sean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode1
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/25
 * @Version V1.0
 **/
public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            if(map.containsKey(target - num)){
                return new int[]{map.get(target - num),i};
            }
            map.put(num,i);
        }
        return new int[2];
    }

}
