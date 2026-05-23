/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node node = head;
        Map<Node, Node> map = new HashMap<>();

        while(node != null)
        {
            Node newNode = new Node(node.val);
            map.put(node,newNode);
            node = node.next;
        }
        node = head;
        Node curr = map.get(node);
        Node newHead = curr;
        while(node != null)
        {
            curr.next = map.get(node.next);
            curr.random = map.get(node.random);
            node = node.next;
            curr = curr.next;
        }

        return newHead;
    }
}
