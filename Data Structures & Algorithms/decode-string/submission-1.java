class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> occ = new Stack<>();
        int currNum = 0;
        String currStr = "";
        char[] arr =  s.toCharArray();
        for(char c : arr)
        {
            if(Character.isDigit(c))
            {
                currNum = (currNum * 10) + (c - '0');
            }
            else if(c == '[')
            {   
                stack.push(currStr);
                occ.push(currNum);
                currNum = 0;
                currStr = "";
            }
            else if(c == ']')
            {
                int l = occ.pop();
                StringBuilder sb = new StringBuilder(stack.pop());
                for(int j=0; j<l; j++)
                    sb.append(currStr);

                currStr = sb.toString();
            }
            else
            {
                currStr += c;
            }
        }
        return currStr;
    }
}