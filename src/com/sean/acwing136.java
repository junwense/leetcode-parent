package com.sean;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName acwing136
 * @Description: https://www.acwing.com/problem/content/description/138/
 * @Author a9705
 * @Date 2022/6/25
 * @Version V1.0
 **/
public class acwing136 {

    class DqListNode<T> {
        public T val;
        public DqListNode<T> next;
        public DqListNode<T> pre;

        public DqListNode(T val) {
            this.val = val;
        }

        public DqListNode<T> add(DqListNode<T> node) {
            this.next.pre = node;
            node.next = this.next;
            this.next = node;
            node.pre = this;
            return node;
        }

        public void remove() {
            this.next.pre = this.pre;
            this.pre.next = this.next;
        }
    }

    class Index implements Comparable<Index> {
        public int value;
        public int index;

        @Override
        public int compareTo(Index o) {
            if (this.value > o.value) {
                return 1;
            } else if (this.value < o.value) {
                return -1;
            }
            return 0;
        }

        public Index(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Index{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String in = scanner.nextLine();
        String in2 = scanner.nextLine();
        scanner.close();
        String[] s = in2.split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.valueOf(s[i]);
        }
        //a=new int[]{4,5,6,1,2,3,7,8,9,10 };
        //a=new int[]{1000000000,-1000000000 };
        new acwing136().findMinPoint(a);
    }

    public void findMinPoint(int[] a) {

        int size = a.length;

        if (size == 1) {
            System.out.println("输入非法");
            return;
        }

        // a[1,5,3]
        // rk[a[1],a[3],a[2]]  [1,3,2]
        Index[] rk = new Index[size];
        for (int i = 0; i < size; i++) {
            rk[i] = new Index(a[i], i);
        }
        //排序数组
        Arrays.sort(rk);
        int mixNum = rk[0].value - 1000000001;
        int maxNum = rk[size - 1].value + 1000000001;
        DqListNode<Index> head = new DqListNode(new Index(mixNum, Integer.MIN_VALUE));
        DqListNode<Index> tail = new DqListNode(new Index(maxNum, Integer.MAX_VALUE));
        head.next = tail;
        tail.pre = head;

        //把rk数组添加到指针数组，同时构建链表
        DqListNode<Index>[] pos = new DqListNode[size];
        for (int i = 0; i < size; i++) {
            DqListNode dqListNode = new DqListNode(rk[i]);
            pos[rk[i].index] = dqListNode;
            head = head.add(dqListNode);
        }
        int[] ans = new int[size];
        for (int i = size - 1; i > 0; i--) {
            DqListNode<Index> curr = pos[i];
            //考虑边界值
            if (curr.pre.val.value == mixNum) {
                ans[i] = curr.next.val.index;
            } else if (curr.next.val.value == maxNum) {
                ans[i] = curr.pre.val.index;
            } else {
                //排除边界值后计算
                if (curr.val.value - curr.pre.val.value <= curr.next.val.value - curr.val.value) {
                    ans[i] = curr.pre.val.index;
                } else {
                    ans[i] = curr.next.val.index;
                }
            }
            //计算完成后从链表删除元素
            curr.remove();
        }


        for (int i = 1; i < size; i++) {
            System.out.println(Math.abs(a[i] - a[ans[i]]) + " " + (ans[i] + 1));
        }
    }
}
