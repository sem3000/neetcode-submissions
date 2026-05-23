class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        int length = Math.min(firstString.length(), lastString.length());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++)
        {
            if(firstString.charAt(i) == lastString.charAt(i))
                sb.append(firstString.charAt(i));
            else
                break;
        }

        return sb.toString();
    }
}