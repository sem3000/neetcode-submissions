class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l=0;
        map.put(nums[0],0);
        for(int r = 1; r<nums.length; r++)
        {
            if(r-l > k)
                l++;

            if(map.containsKey(nums[r]) && map.get(nums[r]) >= l)
                return true;
            
            map.put(nums[r],r);
        }
        return false;
    }
}