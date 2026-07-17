/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotate(ListNode head, int k, int count) {
        ListNode temp = head;
        for (int i = 1; i < count - k; i++) {
            temp = temp.next;
        }
        ListNode newhead = temp.next;
        temp.next = null;
        ListNode temp2 = newhead;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = head;

        return newhead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
          return head;
        }
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        return rotate(head, k, count);

    }
}