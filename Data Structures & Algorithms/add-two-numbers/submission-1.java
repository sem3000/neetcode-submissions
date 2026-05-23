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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carry = 0;
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry;
            int unit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(unit,null);
            if(head == null)
            {
                head = node;
                last = node;
            }
            else
            {
                last.next = node;
                last = last.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null)
        {
            int sum = l1.val + carry;
            int unit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(unit, null);
            if(head == null)
            {
                head = node;
                last = node;
            }
            else
            {
                last.next = node;
                last = last.next;
            }
            l1 = l1.next;
        }
        while(l2 != null)
        {
            int sum = l2.val + carry;
            int unit = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(unit, null);
            if(head == null)
            {
                head = node;
                last = node;
            }
            else
            {
                last.next = node;
                last = last.next;
            }
            l2 = l2.next;
        }
        if(carry > 0)
        {
            ListNode node = new ListNode(carry, null);
             last.next = node;
                last = last.next;

        }
        return head;
    }
}
