class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l = word1.length();
        int m = word2.length();
        int i=0;
        int j=0;
        boolean word1Flag = true;
        while(i < l && j < m)
        {
            if(word1Flag)
            {
                sb.append(word1.charAt(i));
                i++;
                word1Flag = false;
            }
            else
            {
                sb.append(word2.charAt(j));
                j++;
                word1Flag = true;
            }
        }

        while(i < l)
        {
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < m)
        {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}