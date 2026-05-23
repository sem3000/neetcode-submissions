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
    public void reorderList(ListNode head) {
        ListNode middle = getMiddle(head);

        ListNode secondHalf = middle.next;
        ListNode head2 = reverseList(secondHalf);
        middle.next = null;

        ListNode p1 = head;
        ListNode p2 = head2;

        while (p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;

            // Link p1 (L_i) -> p2 (L_n-i)
            p1.next = p2;
            
            // Link p2 (L_n-i) -> next1 (L_i+1)
            p2.next = next1;

            // Move to the next nodes for the merge
            p1 = next1;
            p2 = next2;
        }

    }
    public ListNode getMiddle(ListNode node)
    {
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
