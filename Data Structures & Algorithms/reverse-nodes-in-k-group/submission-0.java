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
    public ListNode reverseKGroup(ListNode head, int k) {
        int groups = 0;
        ListNode node = head;
        while(node != null)
        {
            groups++;
            node = node.next;
        }
        groups = groups / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode lp = dummy;
        ListNode curr = head;

        while(groups > 0)
        {
            ListNode prev = null;
            ListNode firstNode = curr;
            for(int i=0; i<k; i++)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }    
            lp.next = prev;
            lp = firstNode;
            groups--;
        }
        lp.next = curr;
        
        return dummy.next;
    }
}
