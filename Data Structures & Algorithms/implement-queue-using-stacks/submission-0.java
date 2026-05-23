class MyQueue {
    Stack<Integer> pS;
    Stack<Integer> sS;
    
    public MyQueue() {
        pS = new Stack<>();
        sS = new Stack<>();
    }
    
    public void push(int x) {
        while(!pS.isEmpty())
            sS.push(pS.pop());
        
        pS.push(x);

        while(!sS.isEmpty())
            pS.push(sS.pop());
    }
    
    public int pop() {
        return pS.pop();
    }
    
    public int peek() {
        return pS.peek();
    }
    
    public boolean empty() {
        return pS.isEmpty();
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