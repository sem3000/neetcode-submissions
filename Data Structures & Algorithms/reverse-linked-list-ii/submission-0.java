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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode lp = dummy;
        ListNode curr = head;
        ListNode prev = null;
        for(int i=0; i<left-1; i++)
        {
            lp = lp.next;
            curr = curr.next;
        }

        for(int i=0; i<(right-left+1); i++)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        lp.next.next = curr;
        lp.next = prev;

        return dummy.next;
    }
}