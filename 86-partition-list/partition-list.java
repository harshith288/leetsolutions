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
    public ListNode partition(ListNode head, int x) {
       ListNode dummy1 =new ListNode(0);
       ListNode dummy2 =new ListNode(0);
       ListNode newhead=dummy1;
       ListNode tail=dummy2;
       ListNode temp=head;
       while(temp!=null){
        if(temp.val<x){
            newhead.next=temp;
            newhead=newhead.next;
        }
        if(temp.val>=x){
           tail.next=temp;
           tail=tail.next;
        }
        temp=temp.next;
       }
       tail.next=null;
       newhead.next=dummy2.next;
       return dummy1.next;
        
    }
}