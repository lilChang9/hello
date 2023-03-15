package leetcode.linkedList.lc160;

import leetcode.linkedList.ListNode;

public class lc160_2 {
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
         * 定义p指向A头节点，q指向B头节点
         * 当p!=q的情况下:
         * 若p!=null,则p = p.next 否则将其指向B的头节点
         * 若q!=null,则q = q.next 否则将其指向A的头节点
         */
        ListNode p = headA;
        ListNode q = headB;
        while(p != q){
            p = (p==null) ? headB : p.next;
            q = (q==null) ? headA : q.next;
        }
        return p;
    }
}
