class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if(!map.containsKey(key))
            {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key,list);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list = map.get(key);
                list.add(s);
                map.put(key,list);
            }
        }
        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            res.add(entry.getValue());
        }

        return res;
    }
}
