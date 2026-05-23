class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c : arr)
        {
            switch(c)
            {
                case '}': if(stack.isEmpty() || stack.pop() !='{')
                        return false;
                        break;
                case ']': if(stack.isEmpty() || stack.pop() !='[')
                        return false;
                        break;
                case ')': if(stack.isEmpty() || stack.pop() !='(')
                        return false;
                        break;
                default: stack.push(c);
                        break;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
