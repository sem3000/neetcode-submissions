class MyQueue {
    Stack<Integer> pStack;
    Stack<Integer> sStack;
    public MyQueue() {
        pStack = new Stack<>();
        sStack = new Stack<>();      
    }
    
    public void push(int x) {
        while(!pStack.isEmpty())
            sStack.push(pStack.pop());
        
        pStack.push(x);

        while(!sStack.isEmpty())
            pStack.push(sStack.pop());
    }
    
    public int pop() {
        return pStack.pop();
    }
    
    public int peek() {
        return pStack.peek();
    }
    
    public boolean empty() {
        return pStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */