package com.example.demo.leetcode.linkedlist;

import java.util.List;

public class ListTest {


    /**
     *  获取倒数k
     * @param head
     * @return
     */
    public ListNode getLastK(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;

        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;

    }

    /**
     * 876. 链表的中间结点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
           /* if (fast==null&&fast.next==null){
                // 扩展，跳过这个循环，会导致slow指针指向中间节点的前一个。
                continue;
            }*/
            slow=slow.next;
        }

        // 此时slow为中间节点

        return slow;

    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre=null;
        ListNode current=head;
        while (current!=null){
            //保存下一个节点
            ListNode temp=current.next;
            // 当前节点指向前一个节点
            current.next=pre;
            // 前一个节点移动到当前节点
            pre=current;
            // 当前节点移动到临时保存的下一个节点
            current=temp;
        }
        return pre;
    }

    /**
     * 234. 回文链表
     * 快慢指针法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = middleNode(head);

        //翻转链表
        ListNode rightNode = reverseList(midNode);

        while (rightNode!=null){
            if (rightNode.val!=head.val){
                return false;
            }
            head=head.next;
            rightNode=rightNode.next;
        }
        return true;
    }

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //定义两个节点
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            //没到头就后移，到头，就指向另一树头结点
            if (nodeA != null) {
                nodeA = nodeA.next;
            } else {
                // 代表到头了，将遍历第二个链表
                nodeA = headB;
            }
            //另一个节点也一样
            if (nodeB != null) {
                nodeB = nodeB.next;
            } else {
                //代表到头了，将遍历第二个链表
                nodeB = headA;
            }
        }
        return nodeA;
    }


    public static ListNode merge(ListNode headA, ListNode headB) {

        ListNode current = new ListNode(0);
        ListNode head = current;

        //
        while(headA!=null&&headB!=null){
            if (headA.val<=headB.val){
                current.next=headA;
                headA=headA.next;
            }else{
                current.next=headB;
                headB=headB.next;
            }
            current=current.next;

        }
        if (headA!=null){
            current.next=headA;
        }
        if (headB!=null){
            current.next=headB;
        }

        return head;
    }


    public static ListNode reverse(ListNode head){
        if (head.next==null){
            return head;
        }
        ListNode temp=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;

    }

    static ListNode temp;
    public static ListNode reverseN(ListNode head, int n){
        if (n==1){
            //记录第N+1个节点
            temp=head.next;
            return head;
        }

        ListNode listNode= reverseN(head.next,n-1);
        head.next.next=head;
        head.next=temp;
        return listNode;
    }


    public static void printAll(ListNode node){
        while (node!=null){
            System.out.print(node.val+",");
            node=node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode node1=ListNode.generateListNode(2);
        ListNode node2=ListNode.generateListNode(3);

        //System.out.println(node1.toString()+node2.toString());

        printAll(reverse(node1));
    }
}
