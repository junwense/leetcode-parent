package com.sean;

import com.sean.base.ListNode;

/**
 * @ClassName leetcode92
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/23
 * @Version V1.0
 **/
public class leetcode92 {

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);


        System.out.println(new leetcode92().reverseBetween(l1, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode protect = new ListNode(0, head);
        int k = right - left;
        ListNode last = protect;
        ListNode endNext = null;
        while (left > 1) {
            left--;
            last = head;
            head = head.next;
        }

        ListNode end = getEnd(head, k);
        endNext = end.next;

        reverse(head, end.next);

        last.next = end;
        head.next = endNext;

        return protect.next;

    }

    ListNode getEnd(ListNode start, int k) {
        while (start != null) {

            if (k == 0) {
                return start;
            }
            k--;
            start = start.next;
        }
        return null;
    }

    void reverse(ListNode start, ListNode end) {
        ListNode last = start;
        start = start.next;
        while (start != end) {
            ListNode temp = start.next;
            start.next = last;
            last = start;
            start = temp;
        }
    }
}
