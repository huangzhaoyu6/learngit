package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/24
*/

import com.model.ListNode;

public class Demo_24 {
    /**
     *
     *  给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     */

    /**
     * 改变链表的值
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        while (head != null && head.next != null) {
            int tmp = head.val;
            head.val = head.next.val;
            head.next.val = tmp;
            head = head.next.next;
        }
        return result.next;
    }

    /**
     *
     *  从链表的头节点 head 开始递归。
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     *
     */
    public ListNode swapPairs2(ListNode head) {
        // 如果本次递归处理的两个节点中有一个空节点 直接返回head
        if ((head == null) || (head.next == null)) {
            return head;
        }
        // 获取本次需要交换顺序的两个节点
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        // 递归处理被交换到后面的节点 后面的所有节点
        firstNode.next  = swapPairs(secondNode.next);
        //将两个节点交换位置
        secondNode.next = firstNode;
        //交换了两个节点以后，返回后面节点，因为它是交换后的新头。
        return secondNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        new Demo_24().swapPairs(listNode1);

    }

}
