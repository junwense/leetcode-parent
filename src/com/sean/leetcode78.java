package com.sean;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode78
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/2
 * @Version V1.0
 **/
public class leetcode78 {

    public static void main(String[] args) {
        System.out.println(new leetcode78().subsets(new int[]{1,2,3}));
    }

    List<Integer> temp=new ArrayList<>();

    int n;

    List<List<Integer>> ans=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        n=nums.length;
        res(nums,0);
        return ans;
    }


    private void res(int[] nums,int pos){
        if(pos==n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        res(nums,pos+1);
        temp.add(nums[pos]);
        res(nums,pos+1);
        temp.remove(temp.size()-1);
    }
}
