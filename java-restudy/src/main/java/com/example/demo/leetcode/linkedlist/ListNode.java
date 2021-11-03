package com.example.demo.leetcode.linkedlist;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode generateListNode(int n){
        ListNode node0=new ListNode(1+n);
        ListNode node1=new ListNode(2+n);
        ListNode node2=new ListNode(4+n);
        ListNode node3=new ListNode(6+n);
        ListNode node4=new ListNode(10+n);
        ListNode node5=new ListNode(25+n);

        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        return node0;
    }
}
