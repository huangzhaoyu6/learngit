package com.arithmetic;

import com.model.ListNode;

/**
 * @author huangzhaoyu
 * @date 2020/1/19 14:36
 */
public class Demo_21 {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4,
     * 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
        }
        if(l1 == null){
            l3.next = l2;
        }
        if(l2 == null){
            l3.next = l1;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node7 = new ListNode(7);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node7;
//        ListNode node4 = new ListNode(0);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        node4.next = node5;
//        node5.next = node6;

        new Demo_21().mergeTwoLists(node2, node1);

    }


}
