class MinStack {
    int[] stack;
    int[] minStack;
    int top;
    public MinStack() {
        stack = new int[1000];
        minStack = new int[1000];
        top = -1;
    }
    
    public void push(int val) {
        top++;
        if(top==0)
        {
            stack[top] = val;
            minStack[top] = val;
        }else if(top <=99)
        {
            stack[top] = val;
            minStack[top] = Math.min(val, minStack[top-1]);
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
