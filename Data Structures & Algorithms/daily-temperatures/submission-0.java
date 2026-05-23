class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temp.length];
        int ansIndex = 0;
        for(int i=temp.length-1; i>=0; i--)
        {
            int currTemp = temp[i];
            if(stack.isEmpty())
            {
                ans[i] = 0;
            }
            else if(!stack.isEmpty() && currTemp >= temp[stack.peek()])
            {
                while(!stack.isEmpty() && currTemp >= temp[stack.peek()])
                    stack.pop();
                
                if(stack.isEmpty())
                    ans[i] = 0;
                else    
                    ans[i] = stack.peek()-i;
            }
            else if(currTemp < temp[stack.peek()])
            {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
