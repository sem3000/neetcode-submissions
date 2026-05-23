class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones)
            pq.add(n);

        while(pq.size() > 1)
        {
            int first = pq.remove();
            int sec = pq.remove();

            pq.add(Math.abs(first-sec));
        }

        return pq.peek();
    }
}
