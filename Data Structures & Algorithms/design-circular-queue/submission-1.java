class MyCircularQueue {
    Node front;
    Node rear;
    int size;
    int capacity;
    public MyCircularQueue(int k) {
        front = null;
        rear = null;
        capacity = k;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        
        Node node = new Node(value);
        size++;
        if(front == null)
        {
            front = node;
            rear = node;
        }
        else
        {
            rear.next = node;
            rear = rear.next;
            rear.next = front;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        if(size == 1)
        {
            front = null;
            rear = null;
            size--;
            return true;
        }
        front = front.next;
        rear.next = front;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        else
            return front.value;
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        else
            return rear.value;
    }
    
    public boolean isEmpty() {
        if(front == null && rear == null)
            return true;
        else
            return false;
    }
    
    public boolean isFull() {
        if(size >= capacity)
            return true;
        else
            return false;
    }
}

class Node
{
    Node next;
    int value;

    Node(int value)
    {
        this.value = value;
        next = this;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */