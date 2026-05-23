class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] list= new List[nums.length+1];

        for(int n : nums)
            map.put(n, map.getOrDefault(n,0) + 1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int occ = entry.getValue();
            if(list[occ] == null)
            {
                list[occ] = new ArrayList<>();
            }
            list[occ].add(entry.getKey());
        }

        int[] result = new int[k];
        int resIndex = 0;

        for(int i = list.length-1; i > 0 && resIndex < k; i--)
        {
            if(list[i] != null)
            {
                for(int j=0; j<list[i].size() && resIndex < k; j++)
                {
                    result[resIndex] = list[i].get(j);
                    resIndex++;
                }
            }
        }
        return result;

    }
}
