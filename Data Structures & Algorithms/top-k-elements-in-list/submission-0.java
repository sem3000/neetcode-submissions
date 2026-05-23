class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] arr = new List[nums.length + 1];
        Map<Integer,Integer> map = new HashMap<>();

        for(int n :nums)
            map.put(n,map.getOrDefault(n,0)+1);
    
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int occurence = entry.getValue();
            if(arr[occurence] == null)
                arr[occurence] = new ArrayList<>();

            arr[occurence].add(entry.getKey());
        }

        int[] res = new int[k];
        int resIndex = 0;

        for(int i=arr.length-1; i>=0 && resIndex<k; i--)
        {
            if(arr[i] != null)
            {
                List<Integer> list= arr[i];
                for(int j=0; j<list.size() && resIndex<k; j++)
                {
                    res[resIndex] = arr[i].get(j);
                    resIndex++;
                }
            }
        }
        return res;
    }
}
