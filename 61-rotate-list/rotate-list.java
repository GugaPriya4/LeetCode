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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null)
        {
            tail=tail.next;
            len++;
        }
        tail.next=head;
        int r=k%len;
        int rotate=len-r;

        ListNode newTail=tail;
        while(rotate-->0){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
        
    }
}