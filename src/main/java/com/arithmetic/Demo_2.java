package com.arithmetic;

/**
 * @author huangzhaoyu
 * @date 2019/10/25 17:05
 */
public class Demo_2 {
/*
    给出两个 非空 的链表用来表示两个非负的整数。
    其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 1;
        ListNode now1 = l1.next;
        while (now1!=null){
            now1 = now1.next;
            num1++;
        }
        int num2 = 1;
        ListNode now2 = l2.next;
        while (now2!=null){
            now2 = now2.next;
            num2++;
        }
        //进行加法运算
        

        return null;
    }


    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode4;
        listNode4.next = listNode3;

        ListNode listNode7 = new ListNode(7);
        ListNode listNode0 = new ListNode(0);
        ListNode listNode8 = new ListNode(8);
        listNode7.next = listNode0;
        listNode0.next = listNode8;

        addTwoNumbers(listNode2,listNode7);
    }

}
