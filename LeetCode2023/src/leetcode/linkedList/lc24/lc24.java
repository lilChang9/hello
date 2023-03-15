package leetcode.linkedList.lc24;

import leetcode.linkedList.ListNode;

public class lc24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,null);
        ListNode n1 = new ListNode(2,null);
        ListNode n2 = new ListNode(3,null);
        //ListNode n3 = new ListNode(4,null);
        head.next = n1;
        n1.next = n2;
        //n2.next = n3;
        head = swapPairs(head);
        ListNode temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode temp;
        ListNode preCur = cur;
        // headChangeflag标识是否为第一次交换，如果是则需要重新指定头节点
        boolean headChangeflag = false;
        // preCurFlag标识是否需要preCur指向下一次交换的起点
        boolean preCurFlag = false;
        while(cur != null){
            if(cur.next == null){
                return head;
            }
            if(preCurFlag){
                preCur.next = cur.next;
                preCur = cur;
            }
            temp = cur.next.next;
            cur.next.next = cur;
            if(headChangeflag == false){
                head = cur.next;
                headChangeflag = true;
                preCurFlag = true;
            }
            cur.next = temp;
            cur = temp;
        }
        return head;
    }
}
