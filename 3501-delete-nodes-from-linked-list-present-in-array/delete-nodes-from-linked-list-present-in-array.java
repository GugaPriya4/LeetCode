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
    public ListNode modifiedList(int[] nums, ListNode head) {
       Set<Integer> hash=new HashSet<>();
       for(int num:nums){
        hash.add(num);
       }

       ListNode dummy=new ListNode(-1);
       dummy.next=head;
       ListNode curr=head, prev=dummy;

       while(curr!=null){
        if(hash.contains(curr.val)){
            prev.next=curr.next;
        }
        else{
            prev=curr;
        }
        curr=curr.next;
       }

       return dummy.next;
        
    }
}