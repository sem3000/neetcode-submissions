class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, y)->y.getValue()-x.getValue());
        if(a > 0) pq.offer(new Pair<>('a',a));
        if(b > 0) pq.offer(new Pair<>('b',b));
        if(c > 0) pq.offer(new Pair<>('c',c));

        StringBuilder sb = new StringBuilder();
        Pair<Character, Integer> top = null;
        Pair<Character, Integer> sec = null;
        while(!pq.isEmpty())
        {
            top = pq.poll();
            int len = sb.length();
            if(len >=2 && sb.charAt(len-1) == top.getKey() && sb.charAt(len-2) == top.getKey())
            {
                if(pq.isEmpty()) break;
                sec = pq.poll();
                char ch = sec.getKey();
                int occ = sec.getValue()-1;

                sb.append(ch);
                if(occ > 0)
                    pq.offer(new Pair<>(ch, occ));

                pq.offer(top);
            }
            else
            {
                char ch = top.getKey();
                int occ = top.getValue()-1;

                sb.append(ch);
                if(occ > 0)
                    pq.offer(new Pair<>(ch,occ));
            }
        }
        return sb.toString();
    }
}