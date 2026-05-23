class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        int ans = 0;
        for(int n : set)
        {
            int count = 0;
            if(!set.contains(n-1))
            {
                while(set.contains(n + count))
                {
                    count++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
