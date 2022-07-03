package com.sean;

import com.sean.base.ListNode;

import java.util.Arrays;

/**
 * @ClassName leetcode25
 * @Description: TODO
 * @Author a9705
 * @Date 2022/6/24
 * @Version V1.0
 **/
public class leetcode25 {

    public static void main(String[] args) {

        ListNode l2=new ListNode(2,null);
        ListNode l1=new ListNode(1,l2);

        System.out.println(new leetcode25().reverseKGroup(l1,2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect =new ListNode(0,head);
        ListNode last=protect;
        while(head !=null){

            ListNode end= getEnd(head,k-1);

            if(end==null){
                break;
            }

            ListNode  nextGroupHead =end.next;

            reverseList(head,nextGroupHead);

            last.next=end;
            head.next=nextGroupHead;
            last=head;
            head=nextGroupHead;


        }

        return protect.next;
    }

    private ListNode getEnd(ListNode head, int k){
        while(head!=null){
            if(k==0){
                return head;
            }
            k--;
            head=head.next;
        }
        return null;
    }

    private void reverseList(ListNode start,ListNode end){
        ListNode last=start;
        start=start.next;
        while(start!=end){
            ListNode temp =start.next;
            start.next=last;
            last=start;
            start=temp;
        }
    }
}
