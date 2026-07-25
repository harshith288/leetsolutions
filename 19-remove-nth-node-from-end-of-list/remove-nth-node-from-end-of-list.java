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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode temp=head;
      int count=0;
      while(temp!=null){
        temp=temp.next;
        count++;
      }
      if(n==count){
         head=head.next;
         return head;
      }
      ListNode ptr=head;
      for(int i=1;i<count-n;i++){
        ptr=ptr.next;
      }
      if(ptr.next!=null){
        ptr.next=ptr.next.next;
      }
      return head;
    }
}