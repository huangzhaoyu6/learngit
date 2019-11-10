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
        ListNode listNode = l1;    //取出第一个节点 作为临时变量
        ListNode listNode2 = l2;
        ListNode newNode2 = new ListNode(0);
        ListNode newNode = newNode2;
        while (listNode != null || listNode2 != null){
            int x = listNode!=null ? listNode.val:0;
            int y = listNode2!=null ? listNode2.val:0;
            int z = newNode.next!=null ? newNode.next.val:0;
            newNode.next = new ListNode((x+y+z)%10); //改变第一个节点的val
            if(x+y+z >= 10){
                newNode.next.next = new ListNode(1);//第一个节点大于10，下一个节点加一
            }
            newNode = newNode.next;
            if (listNode != null) {listNode = listNode.next!=null?listNode.next:null;}//换成第二个节点
            if (listNode2 != null) {listNode2 = listNode2.next!=null?listNode2.next:null;}
        }
        return newNode2.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);//初始化为返回列表的第一个结点
        ListNode p = l1, q = l2, curr = dummyHead;//取出两个链表的头节点
        int carry = 0;//进位
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);//新结点的第一个为sum对10的取模
            curr = curr.next;//替换为下一个节点进行计算
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

/*
    将当前结点初始化为返回列表的哑结点。
    将进位 carry初始化为 0。
    将 p 和 q分别初始化为列表 l1 和 l2 的头部。
    遍历列表 l1 和 l2 直至到达它们的尾端。

    将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
    将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
    设定 sum=x+y+carry。
    更新进位的值，carry=sum/10。
    创建一个数值为(sum % 10) 的新结点，
    并将其设置为当前结点的下一个结点，
    然后将当前结点前进到下一个结点。
    同时，将 p 和 q 前进到下一个结点。

    检查 carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
    返回哑结点的下一个结点。
*/


    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1);
        ListNode listNode4 = new ListNode(8);
//        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode4;
//        listNode4.next = listNode3;

        ListNode listNode7 = new ListNode(0);
//        ListNode listNode0 = new ListNode(6);
//        ListNode listNode8 = new ListNode(4);
//        listNode7.next = listNode0;
//        listNode0.next = listNode8;

        System.out.println(addTwoNumbers(listNode2,listNode7));
    }

}
