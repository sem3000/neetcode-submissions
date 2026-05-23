class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            pq.offer(new Pair<>(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        Pair<Character, Integer> prev = null;
        while(!pq.isEmpty() || prev != null)
        {
            if(pq.isEmpty() && prev != null)
                return "";
            
            Pair<Character, Integer> curr = pq.poll();
            char ch = curr.getKey();
            int occ = curr.getValue()-1;

            sb.append(ch);

            if(prev != null)
            {
                pq.offer(prev);
                prev = null;
            }
            if(occ > 0)
            {
                prev = new Pair<>(ch,occ);
            }
        }
        return sb.toString();
    }
}