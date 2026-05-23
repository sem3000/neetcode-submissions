class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        for(int i=0; i<arr.length; i++)
            arr[i] = 0;

        for(int i=0; i<s.length(); i++)
        {
            int index = s.charAt(i) - 'a';
            arr[index] += 1;
        }

        for(int i=0; i<t.length(); i++)
        {
            int index = t.charAt(i) - 'a';
            arr[index] -= 1;
        }

        for(int n : arr)
            if(n != 0)
                return false;
        
        return true;
    }
}
