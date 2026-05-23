class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        path += "/";
        for(int i=0; i<path.length(); i++)
        {

            if(path.charAt(i) == '/')
            {
                if(sb.toString().equals(".."))
                {
                    if(!stack.isEmpty()) stack.pop();
                }
                else if(!sb.toString().isEmpty() && !sb.toString().equals("."))
                {
                    stack.push(sb.toString());
                }
                sb.setLength(0);
            }
            else
            {
                sb.append(path.charAt(i));
            }
        }

        sb.setLength(0);
        if(stack.isEmpty())
            sb.append("/");
        
        for(int i=0; i<stack.size(); i++)
        {
            sb.append("/");
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}