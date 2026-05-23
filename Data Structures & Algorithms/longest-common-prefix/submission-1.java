class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];

        int len = Math.min(firstStr.length(), lastStr.length());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++)
        {
            if(firstStr.charAt(i) == lastStr.charAt(i))
                sb.append(firstStr.charAt(i));
            else
                break;
        }

        return sb.toString();
    }
}