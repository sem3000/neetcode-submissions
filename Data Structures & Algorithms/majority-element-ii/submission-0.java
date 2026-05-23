class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
        {
            if(!map.containsKey(n))
                map.put(n,1);
            else
                map.put(n, map.get(n)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() > (nums.length/3))
                ans.add(entry.getKey());
        }
        return ans;
    }
}