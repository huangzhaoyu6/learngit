package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/30
*/

import com.model.ListNode;

public class Demo_25 {

    /**
     *
     *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 示例 :
     * 给定这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * 说明 :
     *     你的算法只能使用常数的额外空间。
     *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     */

    /**
     * 思路：
     * 每次递归处理K个节点
     * 递归基：如果本次处理的k个节点中有空节点，直接返回head
     * 递归处理本组最后一个节点 后面的所有节点
     * 交换本次的k个元素的顺序
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        ListNode[] arr = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return head;
            }
            arr[i] = node;
            node = node.next;
        }
        head.next = reverseKGroup(node, k);
        ListNode lastNode = arr[k - 1];
        ListNode node2 = lastNode;
        //将本次处理的k个节点交换位置
        for (int i = k; i > 1; i--) {
            node2.next = arr[i-2];
            node2 = node2.next;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        new Demo_25().reverseKGroup(listNode1, 4);

    }

}
