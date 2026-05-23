class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int n : asteroids)
        {
            boolean flag = true;
            while(!stack.isEmpty() && n < 0 && stack.peek() > 0)
            {
                flag = false;
                int diff = n + stack.peek();
                if(diff == 0)
                {
                    flag = false;
                    stack.pop();
                    break;
                }
                else if(diff < 0)
                {
                    stack.pop();
                    flag = true;
                }
                else if(diff > 0)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
                stack.push(n);
        }
        int[] ans = new int[stack.size()];
        for(int i=0; i<stack.size(); i++)
        {
            ans[i] = stack.get(i);
        }
        return ans;
    }
    
}