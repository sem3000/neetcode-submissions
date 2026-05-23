class Solution {
    public final String ADD = "+";
    public final String DOUBLE = "D";
    public final String CLEAR = "C";
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String s : operations)
        {
            switch(s)
            {
                case ADD :  int top = stack.pop();
                            int belowTop = stack.peek();
                            stack.push(top);
                            stack.push(top+belowTop);
                            break;
                case DOUBLE :top = stack.peek();
                            stack.push(top * 2);
                            break;
                case CLEAR :stack.pop();
                            break;
                default :   stack.push(Integer.parseInt(s));
                            break;
            }
        }

        int sum = 0;
        for(int n : stack)
        {
            sum += n;
        }
        return sum;
    }
}