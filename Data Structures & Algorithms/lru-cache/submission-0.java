class LRUCache {
    DoublyLinkedList LRU;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        LRU = new DoublyLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            LRU.update(node);
            return node.value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;
            LRU.update(node);
        }
        else
        {
            Node node = new Node(key, value);
            map.put(key,node);
            LRU.add(node);

            if(map.size() > capacity)
            {
                Node evictedNode = LRU.evict();
                map.remove(evictedNode.key);
            }
        }
    }
}

class Node
{
    Node prev;
    Node next;
    int key;
    int value;

    Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList
{
    Node head;
    Node tail;

    DoublyLinkedList()
    {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node node)
    {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public Node evict()
    {
        if(head.next == tail)
            return null;

        Node node = head.next;
        head.next = node.next;
        node.next.prev = head;
        
        return node;
    }

    public void update(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        add(node);
    }
}
