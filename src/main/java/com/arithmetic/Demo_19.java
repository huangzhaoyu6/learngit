package com.arithmetic;/*
 @author hzy
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/1/18
*/

import com.model.ListNode;

import java.util.HashMap;

public class Demo_19 {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     */

    /**
     * 思路：
     * 遍历一次链表，将对应的下标作为K，对应的node作为value存储起来
     * 删除k元素时，只需要将 k-1 的node的下个节点设置为k+1的node即可
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int i = 0;
        ListNode listNode2 = new ListNode(0);
        listNode2.next = head;
        ListNode listNode3 = listNode2;
        while (listNode3.next != null) {
            hashMap.put(i, listNode3);
            listNode3 = listNode3.next;
            i++;
        }
        hashMap.put(i, listNode3);
        hashMap.get(i - n).next = hashMap.get(i - n + 2);
        return listNode2.next;
    }

    /**
     * 首先我们将添加一个哑结点作为辅助，
     * 该结点位于列表头部。
     * 哑结点用来简化某些极端情况，
     * 例如列表中只含有一个结点，或需要删除列表的头部。
     * 在第一次遍历中，我们找出列表的长度 L。
     * 然后设置一个指向哑结点的指针，
     * 并移动它遍历列表，直至它到达第 (L−n)个结点那里。
     * 我们把第 (L−n) 个结点的 next 指针重新链接至第 (L−n+2)个结点，完成这个算法。
     */

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
//        head3.next = head4;
//        head4.next = head5;
        ListNode listNode = new Demo_19().removeNthFromEnd(head1, 3);
        while (listNode.next != null) {
            System.out.println(listNode.getVal());
            listNode = listNode.next;
        }
        System.out.println(listNode.getVal());
    }

}
