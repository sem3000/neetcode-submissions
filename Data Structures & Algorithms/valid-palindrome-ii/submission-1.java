class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                boolean leftSkip = true;
                int l1 = l+1;
                int r1 = r;
                while(l1 < r1)
                {
                    if(s.charAt(l1) != s.charAt(r1))
                    {
                        leftSkip = false;
                        break;
                    }
                    l1++;
                    r1--;
                }

                boolean rightSkip = true;
                int l2 = l;
                int r2 = r-1;
                while(l2 < r2)
                {
                    if(s.charAt(l2) != s.charAt(r2))
                    {
                        rightSkip = false;
                        break;
                    }
                    l2++;
                    r2--;
                }

                return (leftSkip || rightSkip);
            }
            l++;
            r--;
        }
        return true;
    }
}