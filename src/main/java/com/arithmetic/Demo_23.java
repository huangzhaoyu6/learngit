package com.arithmetic;

import com.model.ListNode;

/**
 * @author huangzhaoyu
 * @date 2020/1/21 14:16
 */
public class Demo_23 {

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * 示例:
     * 输入:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     */

    /**
     * lists中一共需要合并n-1次链表
     * n = 0 ;n++
     * m = n+1
     * f(lists) = fx(n,fx(m))
     * fx(a,b) 为21题解法
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length < 1) {
            return null;
        }
        ListNode listNode = lists[0];
        for (int i = 0; i < length - 1; i++) {
            listNode = Demo_21.mergeTwoLists(listNode, lists[i + 1]);
        }
        return listNode;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] arr = {node1,node4,node7};
        new Demo_23().mergeKLists(arr);
    }


}
