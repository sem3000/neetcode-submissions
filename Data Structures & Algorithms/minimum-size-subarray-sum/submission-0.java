class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int result = Integer.MAX_VALUE;
        int l=0;
        for(int r=0; r<nums.length; r++)
        {
            windowSum += nums[r];
            while(windowSum >= target && l < nums.length)
            {
                result = Math.min(result, r-l+1);
                windowSum -= nums[l];
                l++;
            }
        }
        if(result == Integer.MAX_VALUE)
            return 0;
        else 
            return result;
    }
}