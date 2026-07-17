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
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        if(first.val == second.val) {

            while(second != null && second.val == first.val) {
                second = second.next;
            }

            return deleteDuplicates(second);
        }

        first.next = deleteDuplicates(second);
        return first;
    }
}