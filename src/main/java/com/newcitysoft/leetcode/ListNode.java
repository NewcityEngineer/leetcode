package com.newcitysoft.leetcode;

public  class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + this.val +
                ", next=" +  this.next +
                '}';
    }
}