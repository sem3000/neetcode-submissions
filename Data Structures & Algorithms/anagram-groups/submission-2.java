class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);

            if(!map.containsKey(str))
            {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(str, newList);
            }
            else
            {
                List<String> list = map.get(str);
                list.add(s);
                map.put(str, list); 
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
