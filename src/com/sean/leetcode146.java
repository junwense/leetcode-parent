package com.sean;

import java.util.HashMap;
import java.util.Map;

public class leetcode146 {

    public static void main(String[] args) {
        leetcode146 leetcode146=new leetcode146(2);
        leetcode146.put(2,1);
        leetcode146.put(1,1);
        leetcode146.get(2);
        leetcode146.put(4,1);
        leetcode146.get(1);
        leetcode146.get(2);
    }

    int capacity=0;
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map;
    int size=0;

    public leetcode146(int capacity) {
        this.capacity=capacity;
        head=new ListNode();
        tail=new ListNode();
        head.next=tail;
        tail.pre=head;
        map=new HashMap<>();
    }

    public int get(int key) {

        ListNode ans=map.get(key);
        if(ans==null){
            return -1;
        }
        moveFirst(ans);
        return  ans.val;
    }

    public void put(int key, int value) {

        ListNode listNode = map.get(key);
        if(listNode==null){
            listNode=new ListNode(value,key);
            addFirst(listNode);
        }else{
            listNode.val=value;
            moveFirst(listNode);
        }
        map.put(key,listNode);
    }

    private synchronized void addFirst(ListNode node)  {

        if(size+1>capacity){
            removeLast();
        }
        size++;
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private synchronized void moveFirst(ListNode node)  {

        node.next.pre = node.pre;
        node.pre.next = node.next;

        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private synchronized void remove(ListNode node) {
        size--;
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void removeLast() {
        if(size==0){
            return;
        }
        map.remove(tail.pre.key);
        remove(tail.pre);
    }

    private class ListNode {
        public int val;
        public int key;
        public ListNode next;
        public ListNode pre;

        public ListNode() {
        }

        public ListNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
}
