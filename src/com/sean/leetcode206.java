package com.sean;

import com.sean.base.ListNode;

public class leetcode206 {

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        //表示 head的下一个节点
        ListNode temp;

        while (head != null) {
            temp = head.next;
            head.next = last;
            last = head;
            head = temp;

        }
        return last;
    }

    public ListNode reverseList1(ListNode head) {
        // 判断空处理
        if (head == null) {
            return head;
        }
        //如果下个节点为null，则终止递归（递归终止条件）
        if (head.next == null) {
            return head;
        }

        //直接到下个节点，这里其实可以直接获取到最后一个节点，即结果节点
        ListNode ans = reverseList1(head.next);

        //节点反转
        head.next.next = head;
        //防止第一个节点有环，然后第一个节点指向null
        head.next = null;

        return ans;
    }
}
