class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l=0;
        for(int r=s1.length(); r<=s2.length(); r++)
        {
            String subString = s2.substring(l,r);
            if(isAnagram(s1,subString))
                return true;

            l++;
        }
        return false;
    }

    public boolean isAnagram(String s1, String s2)
    {
        int[] count = new int[26];
        for(int i=0; i<s1.length(); i++)
        {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        for(int n : count)
            if(n!=0)
                return false;

        return true;
    }
}
