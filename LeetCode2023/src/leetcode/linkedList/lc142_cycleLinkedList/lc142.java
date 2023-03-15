package leetcode.linkedList.lc142_cycleLinkedList;

import leetcode.linkedList.ListNode;

public class lc142 {

    public static void main(String[] args) {
        ListNode headA = new ListNode(3,null);
        ListNode a1 = new ListNode(2,null);
        ListNode a2 = new ListNode(0,null);
        ListNode a3 = new ListNode(-4,null);
        ListNode a4 = new ListNode(5,null);
        headA.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2;
        ListNode listNode = detectCycle(headA);
        System.out.println(listNode);

    }

    public static ListNode detectCycle(ListNode head) {
        /**
         * 定义一个fast指针和一个slow指针,初始都为head
         * 当fast指针不等于slow指针时，fast指针向前走两步，slow指针向前走一步
         * 当fast指针与slow指针相等时，定义两个指针index1和index2
         * index1初始化为head
         * index2初始化为相遇节点
         * 然后当index1和index2不相等时，index1和index2均向前走一步
         * index1与index2相等时，index1和index2指向的节点即为环入口
         */
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode index1 = head;
                ListNode index2 = fast;
                while(index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
