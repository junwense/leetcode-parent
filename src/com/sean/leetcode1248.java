package com.sean;

/**
 * @ClassName leetcode1248
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/30
 * @Version V1.0
 **/
public class leetcode1248 {

    public static void main(String[] args) {
        int i = new leetcode1248().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
        System.out.println(i);
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int ans=0;
        int size=nums.length;
        int[] preSum=new int[size+1];
        preSum[0]=0;
        for (int i = 1; i <= size; i++) {
            preSum[i]=preSum[i-1]+nums[i-1]%2;
        }
        int[] count=new int[size+1];
        //定义一个count数组 ，假如 count[1]=2 则 preSum 中值为1的节点有2个
        count[preSum[0]]++;
        for (int i = 1; i <= size; i++) {
            //这里用preSum[i]-k，主要是为了找到 preSum中值为preSum[i]-k的下标
            if(preSum[i]-k>=0){
                //preSum中值为preSum[i]-k 的下标个数记录在count[preSum[i]-k]中，直接加总到ans里
                ans+=count[preSum[i]-k];
            }
            //把当前元素的preSum[i]前缀和的值加入到count[preSum[i]]，count[preSum[i]]的数量加一
            count[preSum[i]]++;
        }

        // count [1,1,2,1,1,0]
        // 表示 preSum[0]的个数有1个即count[preSum[0]]=1
        // count[2] =2 表示 preSum中值为2的节点有2个，即为preSum[2],preSum[3]
        // preSum[0,1,2,2,3,4]
        return ans;
    }

}
