package com.sean.base;

/**
 * @ClassName ListNode
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/23
 * @Version V1.0
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "this{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
