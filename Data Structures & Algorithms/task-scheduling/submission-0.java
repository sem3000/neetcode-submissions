class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t :tasks)
            map.put(t,map.getOrDefault(t,0)+1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            pq.offer(entry.getValue());

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty())
        {
            time++;
            if(!pq.isEmpty())
            {
                int occ = pq.poll();
                occ--;
                if(occ > 0)
                    q.offer(new Pair<>(occ, time + n));
            }
            if(!q.isEmpty() && q.peek().getValue()==time)
            {
                pq.offer(q.poll().getKey());
            }
        }
        return time;
    }
}
