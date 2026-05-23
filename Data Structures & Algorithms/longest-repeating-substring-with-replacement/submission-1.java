class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int res = 0;
        int l=0;
        for(int r=0; r<s.length(); r++)
        {
            count[s.charAt(r)-'A']++;
            maxCount = Math.max(count[s.charAt(r)-'A'],maxCount);

            while(r-l+1-maxCount > k)
            {
                count[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
