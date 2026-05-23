class StockSpanner {
    Stack<Pair<Integer, Integer>> stack;
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index++;
        int ans=0;
        if(stack.isEmpty())
        {
            ans = 1;
        }
        else if(!stack.isEmpty() && price >= stack.peek().getValue())
        {
            while(!stack.isEmpty() && price >= stack.peek().getValue())
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                ans = index+1;
            }
            else
            {
                ans = index - stack.peek().getKey();
            }
        }
        else
        {
            ans = index - stack.peek().getKey();
        }

        stack.push(new Pair<>(index,price));
        return ans;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */