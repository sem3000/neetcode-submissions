class Solution {
    public final String ADD = "+";
    public final String SUB = "-";
    public final String MUL = "*";
    public final String DIV = "/";
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens)
        {
            int top;
            int belowTop;
            switch(s)
            {
                case ADD :  top = stack.pop();
                            belowTop = stack.pop();
                            stack.push(belowTop + top);
                            break;
                case SUB :  top = stack.pop();
                            belowTop = stack.pop();
                            stack.push(belowTop - top);
                            break;
                case MUL :  top = stack.pop();
                            belowTop = stack.pop();
                            stack.push(belowTop * top);
                            break;
                case DIV :  top = stack.pop();
                            belowTop = stack.pop();
                            stack.push(belowTop / top);
                            break;
                default :   stack.push(Integer.parseInt(s));
                            break;
            }
        }
        return stack.peek();
    }
}
