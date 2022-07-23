package com.sean;

import com.sean.base.ListNode;

/**
 * @ClassName leetcode142
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/27
 * @Version V1.0
 **/
public class leetcode142 {

    public static void main(String[] args) {
        new leetcode142().detectCycle(null);
    }

    /**
     * @MethodName: detectCycle
     * @Description: 找到链表中环的开始节点，没有返回空
     * 思路：
     *      假设链表有环，环开始的节点为 a ，快慢指针相遇的节点为a节点后面的 b个节点, 环长度剩下长度为c
     *      那么有： 假设 n 圈后快慢指针相遇，快指针是慢指针走的步数的2倍
     *      快指针走的步数  a+b+ n(b+c)
     *      慢指针的步数 a+b
     *      就有 a+(n+1)b+nc=2(a+b)  ==>  a=c+(n-1)(b+c) ==> 可以看出，如果有指针分别在 头节点/c 2个位置上 n-1 圈后2个指针会相遇在a节点，即我们的结果
     * @Param: [head]
     * @Return: com.sean.base.ListNode
     * @Author: a9705
     * @Date: 2022/6/27
    **/
    public ListNode detectCycle(ListNode head) {
        ListNode meet=hasCycle(head);
        ListNode init=head;
        //无环
        if(meet==null){
            return null;
        }
        while(meet!=init){
            meet=meet.next;
            init=init.next;
        }
        return init;
    }

    /**
     * @MethodName:
     * @Description: 链表寻找是否有环
     * @Param:
     * @Return:
     * @Author: a9705
     * @Date: 2022/6/27
    **/
    public ListNode hasCycle(ListNode head) {
        //使用快慢指针
        ListNode fast=head;
        ListNode low=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low) {
                return fast;
            }
        }
        return null;
    }
}
