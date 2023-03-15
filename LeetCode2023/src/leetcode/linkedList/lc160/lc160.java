package leetcode.linkedList.lc160;

import leetcode.linkedList.ListNode;

public class lc160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4,null);
        ListNode a1 = new ListNode(1,null);
        ListNode a2 = new ListNode(8,null);
        ListNode a3 = new ListNode(4,null);
        ListNode a4 = new ListNode(5,null);
        headA.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode headB = new ListNode(5,null);
        ListNode b1 = new ListNode(0,null);
        ListNode b2 = new ListNode(1,null);
        ListNode b3 = new ListNode(8,null);
        ListNode b4 = new ListNode(4,null);
        ListNode b5 = new ListNode(5,null);
        headB.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode node = getIntersectionNode(headA, headB);
        System.out.println("node = " + node.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 创建curA和curB两个指针对两个链表进行遍历得到A链表和B链表的长度(sizeA和sizeB)
         * 1.求sizeA和sizeB的差值sub:
         * (1)sub大于0，A链表长度大于B链表，将curA向前走sub步与B链表对齐
         * (2)sub小于0，B链表长度大于A链表，将curB向前走sub步与A链表对齐
         * (3)sub等于0，A链表与B链表已对齐，不需要移动
         * 2.将curA指向节点的值与curB指向的值进行比较
         * (1)不相等，则curA=curA.next;curB=curB.next;
         * (2)相等，返回curA即可
         */
        ListNode tempA = headA;
        ListNode tempB = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(tempA != null){
            sizeA++;
            tempA = tempA.next;
        }
        while(tempB != null){
            sizeB++;
            tempB = tempB.next;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int sub = sizeA - sizeB;
        if(sub > 0){
            while(sub != 0){
                curA = curA.next;
                sub--;
            }
        }else{
            sub = Math.abs(sub);
            while(sub != 0){
                curB = curB.next;
                sub--;
            }
        }
        while(curA != null){
            if(curA.val == curB.val){
                return curA;
            }else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return curA;
    }
}
