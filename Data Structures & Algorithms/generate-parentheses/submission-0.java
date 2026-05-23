class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        helper(n,"",0,0);
        return result;      
    }
    public void helper(int n, String s, int open, int closed)
    {
        if(s.length() == (n*2))
        {
            result.add(s);
            return;
        }

        if(open < n)
            helper(n, s+"(", open+1, closed);
        
        if(closed < open)
        helper(n, s+")", open, closed+1);

    }
}
