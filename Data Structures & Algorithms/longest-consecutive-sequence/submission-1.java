class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);

        int maxLength = 0;
        int length = 0;
        for(int n : set)
        {
            if(!set.contains(n-1))
            {
                length = 0;
                while(set.contains(n+length))
                    length++;

                maxLength = Math.max(maxLength,length);
            }
        } 
        return maxLength;
    }
}
