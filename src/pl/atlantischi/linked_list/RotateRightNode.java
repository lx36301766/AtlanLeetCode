package pl.atlantischi.linked_list;

import pl.atlantischi.base.ListNode;

/**
 * Created on 2019/10/21.
 *
 * @author lx
 */

class RotateRightNode {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;

        ListNode tail = head;
        int length = 1;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;

        ListNode newHead = tail;
        ListNode breakNode = tail;
        for (int i = 0; i < length - k % length; i++) {
            breakNode = breakNode.next;
            newHead = breakNode.next;
        }
        breakNode.next = null;
        return newHead;
    }

}
