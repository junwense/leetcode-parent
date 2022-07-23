package com.sean;

import java.util.Random;

public class leetcode384 {
    private int[] init;
    private int[] shuffle;


    public leetcode384(int[] nums) {
        this.init=nums;
        this.shuffle=new int[init.length];
        System.arraycopy(init,0,shuffle,0,init.length);
    }

    public int[] reset() {
        return init;
    }

    public int[] shuffle() {
        Random random=new Random();
        for(int i=0;i<init.length;i++){
            int j=i+(int)Math.random()*(init.length-i+1)-1;
            swap(shuffle,i,j);
        }
        return  shuffle;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {
        Random random=new Random();
        System.out.println(Math.random()*10);
    }
}
