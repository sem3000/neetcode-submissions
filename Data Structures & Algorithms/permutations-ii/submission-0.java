class Solution {
    List<List<Integer>> result;
    int length;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);

        helper(new ArrayList<>(), map);
        return result;
    }
    public void helper(List<Integer> subList, Map<Integer,Integer> map)
    {
        if(subList.size() == length)
        {
            result.add(new ArrayList<>(subList));
            return;
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int num = entry.getKey();
            int count = entry.getValue();

            if(count > 0)
            {
                subList.add(num);
                map.put(num, count-1);

                helper(subList, map);

                subList.remove(subList.size()-1);
                map.put(num,count);
            }
        }
    }
}