class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        int count = 0;
        int prefixSum = 0;
        for(int i=0; i<nums.length; i++)
        {
            prefixSum += nums[i];
            int target = prefixSum - k;
            if(map.containsKey(target))     
                count += map.get(target);
            
            if(!map.containsKey(prefixSum))
                map.put(prefixSum,1);
            else
                map.put(prefixSum,map.get(prefixSum)+1);
        }
        return count;
    }
}