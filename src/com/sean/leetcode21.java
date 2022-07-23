package com.sean;

import com.sean.base.ListNode;


/**
 * @ClassName leetcode21
 * @Description: TODO
 * @Author a9705
 * @Date 2022/7/22
 * @Version V1.0
 **/
public class leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode ans = head;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }

        return ans.next;
    }

    /**
     * 递归
      * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }
}
