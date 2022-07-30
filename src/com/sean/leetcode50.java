package com.sean;

/**
 * @ClassName leetcode50
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/26
 * @Version V1.0
 **/
public class leetcode50 {

    public static void main(String[] args) {
        System.out.println(-1<<31);
    }

    public double myPow(double x, int n) {

        if(n==0){
            return 1;
        }
        //考虑边界问题 int边界为 -1<<31 和 1<<31-1，所以这里直接用 -n会越界，需要先+1再补一个x
        if(n==-1<<31){
            return 1.0/(myPow(x,-(n+1))*x);
        }

        // -n用 1除以当前值来计算
        if(n<0) {
            return 1.0/myPow(x,-n);
        }

        double temp = myPow(x, n / 2);
        //如果n是奇数，由于是向下取整，则补一个x
        if(n%2==1){
            return temp*temp*x;
        }else{
            return temp*temp;
        }

    }

}
