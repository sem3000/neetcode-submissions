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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        if(lists.length == 0)
            return null;

        for(int i=0; i<lists.length; i++)
        {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty())
        {
            ListNode node = pq.poll();
            ListNode newNode = new ListNode(node.val);
            curr.next = newNode;
            curr = curr.next;
            if(node.next != null)
                pq.offer(node.next);
        }

        return dummy.next;
    }
}
