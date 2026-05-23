class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();

        for(char c : charArray)
        {
            if(c >= 65 && c <= 90)
            {
                c +=32;
                sb.append(c);
            }
            else if(c >= 97 && c <= 122)
            {
                sb.append(c);
            }
            else if(c >=48 && c <= 57)
            {
                sb.append(c);
            }
        }

        
        String str = sb.toString();
        int left = 0;
        int right = str.length()-1;

        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
