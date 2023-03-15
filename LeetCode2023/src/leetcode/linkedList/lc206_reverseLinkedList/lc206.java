package leetcode.linkedList.lc206_reverseLinkedList;

import leetcode.linkedList.ListNode;

public class lc206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,null);
        ListNode n1 = new ListNode(2,null);
        ListNode n2 = new ListNode(3,null);
        ListNode n3 = new ListNode(4,null);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        reverseList(head);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while(cur != null){
            temp = pre;
            pre = cur;
            cur = cur.next;
            pre.next = temp;
        }
        return pre;
    }
}
