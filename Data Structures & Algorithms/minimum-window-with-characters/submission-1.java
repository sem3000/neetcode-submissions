class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        int have = 0;
        int need = t.length();
        int l=0;
        String subString = "";
        int result = Integer.MAX_VALUE;
        for(int i=0; i<need; i++)
        {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        for(int r=0; r<s.length(); r++)
        {
            char rightChar = s.charAt(r);
            if(have < need)
            {
                if(tMap.containsKey(rightChar))
                {
                    windowMap.put(rightChar, windowMap.getOrDefault(rightChar,0)+1);
                    if(windowMap.get(rightChar) <= tMap.get(rightChar))
                    {
                        have++;
                    }
                    if(r-l+1 < result && have == need)
                    {
                        result = r-l+1;
                        subString = s.substring(l,r+1);
                    }
                }
                else
                {
                    continue;
                }

                while(have >= need)
                {
                    char leftChar = s.charAt(l);
                    if(windowMap.containsKey(leftChar))
                    {
                        windowMap.put(leftChar,windowMap.get(leftChar)-1);
                        if(windowMap.get(leftChar) < tMap.get(leftChar))
                            have--;
                    }
                    l++;
                    if(r-l+1 < result && have == need)
                    {
                        result = r-l+1;
                        subString = s.substring(l,r+1);
                    }
                }
            
            }
        }
        return subString;
    }
}
